package com.developer.colorblast.comment.repository;

import com.developer.colorblast.comment.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findByIdPro(Long idPro);
    List<CommentEntity> findByIdProduct(Long idProduct);
}
