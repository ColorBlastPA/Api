package com.developer.colorblast.line.repository;

import com.developer.colorblast.line.entity.LineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineRepository extends JpaRepository<LineEntity, Long> {
    List<LineEntity> findByIdMessagerie(Long idMessagerie);
}
