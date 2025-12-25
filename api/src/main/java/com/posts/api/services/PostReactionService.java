package com.posts.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posts.api.domains.post_reaction.EnumReactionType;
import com.posts.api.domains.post_reaction.PostReaction;
import com.posts.api.domains.post_reaction.PostReactionResponseDTO;
import com.posts.api.repositories.PostReactionRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PostReactionService {

    @Autowired
    private PostReactionRepository postReactionRepository;

    public PostReactionResponseDTO addVote(UUID postId, EnumReactionType reactionType) {
        PostReaction postReaction = new PostReaction();
        postReaction.setPost_id(postId);
        postReaction.setReaction_type(reactionType);
        
        PostReaction savedReaction = postReactionRepository.save(postReaction);
        
        return new PostReactionResponseDTO(
            savedReaction.getId(),
            savedReaction.getPost_id(),
            savedReaction.getReaction_type(),
            savedReaction.getCreated_at(),
            savedReaction.getUpdated_at()
        );
    }

    public Map<String, Long> getVoteStatistics(UUID postId) {
        long upvotes = postReactionRepository.countByPost_idAndReaction_type(postId, EnumReactionType.UPVOTE);
        long downvotes = postReactionRepository.countByPost_idAndReaction_type(postId, EnumReactionType.DOWNVOTE);
        
        Map<String, Long> statistics = new HashMap<>();
        statistics.put("upvotes", upvotes);
        statistics.put("downvotes", downvotes);
        
        return statistics;
    }
}
