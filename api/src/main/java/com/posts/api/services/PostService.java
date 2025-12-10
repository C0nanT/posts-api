package com.posts.api.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.posts.api.domains.post.Post;
import com.posts.api.domains.post.PostRequestDTO;
import com.posts.api.domains.post.PostResponseDTO;
import com.posts.api.domains.type.Type;
import com.posts.api.repositories.PostRepository;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import com.amazonaws.services.s3.AmazonS3;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Service
public class PostService {

    @Value("${aws.s3.bucket-name}")
    private String awsBucketName;

    @Autowired
    private AmazonS3 amazonS3;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TypeService typeService;

    /**
     * Create a new post
     * 
     * @param data Post data
     * @return Created post
     */
    public Post store(PostRequestDTO data) {
        String imageUrl = null;

        if (data.image() != null) {
            imageUrl = this.uploadImage(data.image());
        }

        // Find or create the type
        Type type = typeService.findOrCreateType(data.type_name());

        Post newPost = new Post();
        newPost.setTitle(data.title());
        newPost.setContent(data.content());
        newPost.setImage_url(imageUrl);
        newPost.setType(type);

        return postRepository.save(newPost);
    }

    /**
     * Get a paginated list of posts, optionally filtered by type name
     * 
     * @param page     Page number
     * @param perPage  Number of items per page
     * @param typeName Optional type name to filter by
     * @return List of PostResponseDTO
     */
    public List<PostResponseDTO> index(int page, int perPage, String typeName) {
        Pageable pageable = PageRequest.of(page, perPage);
        Page<Post> posts;

        if (typeName != null && !typeName.trim().isEmpty()) {
            posts = postRepository.findByTypeNameIgnoreCase(typeName.trim(), pageable);
        } else {
            posts = postRepository.findAll(pageable);
        }

        return posts.map(post -> new PostResponseDTO(
            post.getId(),
            post.getTitle(),
            post.getContent(),
            post.getImage_url(),
            post.getType().getName(),
            post.getCreated_at(),
            post.getUpdated_at()
        )).getContent();
    }

    /**
     * Upload image to storage and return the URL
     * 
     * @param image Image file
     * @return URL of the uploaded image
     */
    private String uploadImage(MultipartFile image) {
        String imageName = UUID.randomUUID().toString() + "_" + image.getOriginalFilename();

        File file = null;

        try {
            file = this.convertMultiPartToFile(image);
            amazonS3.putObject(awsBucketName, imageName, file);
        } catch (Exception e) {
            throw new RuntimeException("Failed to upload image", e);
        } finally {
            if (file != null) {
                file.delete();
            }
        }

        return amazonS3.getUrl(awsBucketName, imageName).toString();
    }

    /**
     * Convert MultipartFile to File
     * 
     * @param file MultipartFile
     * @return Converted File
     * @throws IOException
     */
    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convertedFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convertedFile);
        fos.write(file.getBytes());
        fos.close();
        return convertedFile;
    }
}
