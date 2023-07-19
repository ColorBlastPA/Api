package com.developer.colorblast.line.service.impl;

import com.developer.colorblast.line.entity.LineEntity;
import com.developer.colorblast.line.repository.LineRepository;
import com.developer.colorblast.line.service.LineService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class LineServiceImpl implements LineService {
    private final LineRepository lineRepository;

    public LineServiceImpl(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    @Override
    public List<LineEntity> findAllLines() {
        return lineRepository.findAll();
    }

    @Override
    public Optional<LineEntity> findById(Long id) {
        return lineRepository.findById(id);
    }

    @Override
    public LineEntity saveLine(LineEntity lineEntity) {
        return lineRepository.save(lineEntity);
    }

    @Override
    public LineEntity updateLine(LineEntity lineEntity) {
        if (!lineRepository.existsById(lineEntity.getId())) {
            throw new EntityNotFoundException("LineEntity with ID " + lineEntity.getId() + " not found");
        }
        return lineRepository.save(lineEntity);
    }

    @Override
    public void deleteLine(Long id) {
        lineRepository.deleteById(id);
    }

    @Override
    public List<LineEntity> findLinesByMessagerieId(Long messagerieId) {
        return lineRepository.findByIdMessagerie(messagerieId);
    }
}

