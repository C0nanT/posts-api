package com.posts.api.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.posts.api.domains.post_reaction.PostReaction;

import java.util.UUID;

import com.posts.api.domains.post_reaction.EnumReactionType;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostReactionRepository extends JpaRepository<PostReaction, UUID> {
    @Query("SELECT COUNT(pr) FROM PostReaction pr WHERE pr.post_id = :post_id AND pr.reaction_type = :reaction_type")
    long countByPost_idAndReaction_type(@Param("post_id") UUID post_id,
            @Param("reaction_type") EnumReactionType reaction_type);

}
