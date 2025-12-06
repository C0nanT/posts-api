package com.posts.api.repositories;
import com.posts.api.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
    void deleteAllByTypeId(UUID typeId);
}
