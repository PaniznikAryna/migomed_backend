package com.migomed.backend.Controller;

import com.migomed.backend.Entity.Comments;
import com.migomed.backend.Service.CommentsService;
import com.migomed.backend.dto.CommentResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentsController {

    private final CommentsService commentsServices;

    private CommentResponseDTO convertToDto(Comments comment) {
        return new CommentResponseDTO(
                comment.getId(),
                comment.getUsers() != null ? comment.getUsers().getId() : null,
                comment.getContent()
        );
    }

    @GetMapping
    public ResponseEntity<List<CommentResponseDTO>> getAllComments() {
        List<Comments> commentsList = commentsServices.getAllComments();
        List<CommentResponseDTO> dtos = commentsList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentResponseDTO> getCommentById(@PathVariable Long id) {
        Comments comment = commentsServices.getCommentsById(id);
        if (comment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(convertToDto(comment));
    }

    @PostMapping
    public ResponseEntity<CommentResponseDTO> createComments(@RequestBody Comments comments) {
        Comments savedComment = commentsServices.saveComments(comments);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDto(savedComment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentResponseDTO> updateComments(@PathVariable Long id, @RequestBody Comments updatedCommentsData) {
        Comments existingComments = commentsServices.getCommentsById(id);
        if (existingComments == null) {
            return ResponseEntity.notFound().build();
        }
        existingComments.setContent(updatedCommentsData.getContent());
        Comments updatedComments = commentsServices.saveComments(existingComments);
        return ResponseEntity.ok(convertToDto(updatedComments));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComments(@PathVariable Long id) {
        commentsServices.deleteComments(id);
        return ResponseEntity.noContent().build();
    }
}
