package com.developer.colorblast.comment.controller;

import com.developer.colorblast.client.entity.ClientEntity;
import com.developer.colorblast.client.service.ClientService;
import com.developer.colorblast.comment.dto.CommentRequest;
import com.developer.colorblast.comment.entity.CommentEntity;
import com.developer.colorblast.comment.service.CommentService;
import com.developer.colorblast.favoris.entity.FavorisEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    private final ClientService clientService;

    public CommentController(CommentService commentService, ClientService clientService) {
        this.commentService = commentService;
        this.clientService = clientService;
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

    @PostMapping("/create/{idClient}")
    public ResponseEntity<List<CommentEntity>> createComment(@RequestBody List<CommentRequest> commentRequests, @PathVariable Long idClient) {
        Optional<ClientEntity> client = clientService.findById(idClient);
        List<CommentEntity> result = new ArrayList<>();
        for (CommentRequest commentRequest : commentRequests) {
            CommentEntity newComment = new CommentEntity();
            newComment.setIdProduct(commentRequest.getIdProduct());
            newComment.setFirstname(client.get().getFirstname());
            newComment.setLastname(client.get().getLastname());
            newComment.setContent(commentRequest.getContent());
            newComment.setNote(commentRequest.getNote());
            CommentEntity savedComment = commentService.saveComment(newComment);
            result.add(savedComment);
        }

        return new ResponseEntity<>(result, HttpStatus.CREATED);
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
