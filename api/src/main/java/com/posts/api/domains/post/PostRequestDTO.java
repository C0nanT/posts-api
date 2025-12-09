package com.posts.api.domains.post;

import org.springframework.web.multipart.MultipartFile;

public record PostRequestDTO(String title, String content, MultipartFile image, String type_name) {

}
