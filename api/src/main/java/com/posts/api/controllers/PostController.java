package com.posts.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.posts.api.domains.post.PostRequestDTO;
import com.posts.api.services.PostService;
import com.posts.api.domains.post.Post;

@RestController
@RequestMapping("/api/posts")
public class PostController {
     
    @Autowired
    private PostService postService;

    public ResponseEntity<Post> create(@RequestBody PostRequestDTO body) {
        Post newPost = this.postService.createPost(body);
        return ResponseEntity.ok(newPost);
    }
}
