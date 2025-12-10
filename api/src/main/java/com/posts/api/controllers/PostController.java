package com.posts.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.posts.api.domains.post.PostRequestDTO;
import com.posts.api.services.PostService;
import com.posts.api.domains.post.Post;
import org.springframework.web.bind.annotation.GetMapping;

import com.posts.api.domains.post.PostResponseDTO;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    /**
     * Create a new post
     * 
     * @param title     Post title
     * @param content   Post content
     * @param image     Post image
     * @param type_name Post type name
     * @return Created post
     */
    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Post> store(
        @RequestParam String title,
        @RequestParam String content,
        @RequestParam MultipartFile image,
        @RequestParam String type_name
    ) {
        PostRequestDTO body = new PostRequestDTO(title, content, image, type_name);
        Post newPost = this.postService.store(body);
        return ResponseEntity.ok(newPost);
    }

    /**
     * Get a paginated list of posts, optionally filtered by type name
     * 
     * @param page     Page number
     * @param per_page Number of items per page
     * @param type     Optional type name to filter by
     * @return List of PostResponseDTO
     */
    @GetMapping()
    public ResponseEntity<List<PostResponseDTO>> index(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int per_page,
        @RequestParam(required = false) String type
    ) {
        List<PostResponseDTO> allPosts = this.postService.index(page, per_page, type);
        return ResponseEntity.ok(allPosts);
    }

}
