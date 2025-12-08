package com.posts.api.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.posts.api.domains.post.Post;
import com.posts.api.domains.post.PostRequestDTO;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import com.amazonaws.services.s3.AmazonS3;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;

@Service
public class PostService {

    @Value("${aws.s3.bucket-name}")
    private String awsBucketName;

    @Autowired
    private AmazonS3 amazonS3;

    /**
     * Create a new post
     * @param data Post data
     * @return Created post
     */
    public Post createPost(PostRequestDTO data) {
        
        String imageUrl = null;
        
        if(data.image() != null){
            imageUrl = this.uploadImage(data.image());
        }

        Post post = new Post();
        post.setTitle(data.title());
        post.setContent(data.content());
        post.setImage_url(imageUrl);

        return post;
    }

    
    /**
     * Upload image to storage and return the URL
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

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convertedFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convertedFile);
        fos.write(file.getBytes());
        fos.close();
        return convertedFile;
    }

}
