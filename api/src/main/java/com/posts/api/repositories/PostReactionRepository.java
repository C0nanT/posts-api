package com.posts.api.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.posts.api.domains.post_reaction.PostReaction;

import java.util.UUID;

public interface PostReactionRepository extends JpaRepository<PostReaction, UUID> {
}
