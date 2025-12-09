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

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Post> create(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("image") MultipartFile image,
            @RequestParam("type_name") String typeName) {

        PostRequestDTO body = new PostRequestDTO(title, content, image, typeName);
        Post newPost = this.postService.createPost(body);
        return ResponseEntity.ok(newPost);
    }
}
