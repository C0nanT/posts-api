package com.posts.api.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.posts.api.domains.post.Post;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
    void deleteAllByTypeId(UUID typeId);
}
