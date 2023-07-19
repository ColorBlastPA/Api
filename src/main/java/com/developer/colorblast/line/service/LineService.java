package com.developer.colorblast.line.service;

import com.developer.colorblast.line.entity.LineEntity;

import java.util.List;
import java.util.Optional;

public interface LineService {
    List<LineEntity> findAllLines();
    Optional<LineEntity> findById(Long id);
    LineEntity saveLine(LineEntity lineEntity);
    LineEntity updateLine(LineEntity lineEntity);
    void deleteLine(Long id);

    List<LineEntity> findLinesByMessagerieId(Long messagerieId);
}

