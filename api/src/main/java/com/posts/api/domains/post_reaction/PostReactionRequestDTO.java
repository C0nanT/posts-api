package com.posts.api.domains.post_reaction;

import java.util.UUID;

public record PostReactionRequestDTO(UUID post_id, EnumReactionType reaction_type) {

}
