package com.posts.api.domains.post_reaction;

import java.util.Date;
import java.util.UUID;

public record PostReactionResponseDTO(UUID id, UUID post_id, EnumReactionType reaction_type, Date created_at, Date updated_at) {

}
