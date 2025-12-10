package com.posts.api.domains.post;

import java.util.Date;
import java.util.UUID;

public record PostResponseDTO(UUID id, String title, String content, String image_url, String type_name, Date created_at, Date updated_at) {}
