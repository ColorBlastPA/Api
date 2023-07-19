package com.developer.colorblast.comment.controller;

import com.developer.colorblast.comment.entity.CommentEntity;
import com.developer.colorblast.comment.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<List<CommentEntity>> getAllComments() {
        List<CommentEntity> comments = commentService.findAllComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentEntity> getCommentById(@PathVariable Long id) {
        Optional<CommentEntity> comment = commentService.findById(id);
        return comment.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CommentEntity> createComment(@RequestBody CommentEntity commentEntity) {
        CommentEntity savedComment = commentService.saveComment(commentEntity);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentEntity> updateComment(@PathVariable Long id, @RequestBody CommentEntity commentEntity) {
        if (!id.equals(commentEntity.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        CommentEntity updatedComment = commentService.updateComment(commentEntity);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/Pro/{idPro}")
    public ResponseEntity<List<CommentEntity>> getCommentsByProId(@PathVariable Long idPro) {
        List<CommentEntity> comments = commentService.findCommentsByProId(idPro);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/Product/{idProduct}")
    public ResponseEntity<List<CommentEntity>> getCommentsByProductId(@PathVariable Long idProduct) {
        List<CommentEntity> comments = commentService.findCommentsByProductId(idProduct);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
}
