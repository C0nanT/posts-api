package com.posts.api.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.posts.api.domains.post.Post;
import com.posts.api.domains.post.PostRequestDTO;

@Service
public class PostService {

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
        return ".";
    }

}
