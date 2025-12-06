package com.posts.api.repositories;
import com.posts.api.domain.post_reaction.PostReaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PostReactionRepository extends JpaRepository<PostReaction, UUID> {
}
