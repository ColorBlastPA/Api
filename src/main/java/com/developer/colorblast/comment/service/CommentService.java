package com.developer.colorblast.comment.service;

import com.developer.colorblast.comment.entity.CommentEntity;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<CommentEntity> findAllComments();
    Optional<CommentEntity> findById(Long id);
    CommentEntity saveComment(CommentEntity commentEntity);
    CommentEntity updateComment(CommentEntity commentEntity);
    void deleteComment(Long id);
    List<CommentEntity> findCommentsByProId(Long idPro);
    List<CommentEntity> findCommentsByProductId(Long idProduct);
}
