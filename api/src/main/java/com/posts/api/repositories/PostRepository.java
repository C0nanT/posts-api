package com.posts.api.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.posts.api.domains.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
    /**
     * Find posts by type name (case insensitive) with pagination
     * 
     * @param typeName Type name to filter by
     * @param pageable Pagination information
     * @return Page of posts matching the type name
     */
    Page<Post> findByTypeNameIgnoreCase(String typeName, Pageable pageable);
}
