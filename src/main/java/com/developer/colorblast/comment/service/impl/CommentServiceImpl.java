package com.developer.colorblast.comment.service.impl;

import com.developer.colorblast.comment.entity.CommentEntity;
import com.developer.colorblast.comment.repository.CommentRepository;
import com.developer.colorblast.comment.service.CommentService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<CommentEntity> findAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<CommentEntity> findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public CommentEntity saveComment(CommentEntity commentEntity) {
        return commentRepository.save(commentEntity);
    }

    @Override
    public CommentEntity updateComment(CommentEntity commentEntity) {
        if (!commentRepository.existsById(commentEntity.getId())) {
            throw new EntityNotFoundException("CommentEntity with ID " + commentEntity.getId() + " not found");
        }
        return commentRepository.save(commentEntity);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<CommentEntity> findCommentsByProId(Long idPro) {
        return commentRepository.findByIdPro(idPro);
    }

    @Override
    public List<CommentEntity> findCommentsByProductId(Long idProduct) {
        return commentRepository.findByIdProduct(idProduct);
    }
}
