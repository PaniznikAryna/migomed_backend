package com.migomed.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResponseDTO {
    private Long id;
    private Long userId;
    private String content;

    public CommentResponseDTO(Long id, Long userId, String content) {
        this.id = id;
        this.userId = userId;
        this.content = content;
    }
}
