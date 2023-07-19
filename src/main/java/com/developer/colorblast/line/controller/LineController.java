package com.developer.colorblast.line.controller;

import com.developer.colorblast.line.entity.LineEntity;
import com.developer.colorblast.line.service.LineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lines")
public class LineController {
    private final LineService lineService;

    public LineController(LineService lineService) {
        this.lineService = lineService;
    }

    @GetMapping
    public ResponseEntity<List<LineEntity>> getAllLines() {
        List<LineEntity> lines = lineService.findAllLines();
        return new ResponseEntity<>(lines, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LineEntity> getLineById(@PathVariable Long id) {
        return lineService.findById(id)
                .map(line -> new ResponseEntity<>(line, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<LineEntity> createLine(@RequestBody LineEntity lineEntity) {
        LineEntity createdLine = lineService.saveLine(lineEntity);
        return new ResponseEntity<>(createdLine, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LineEntity> updateLine(@PathVariable Long id, @RequestBody LineEntity lineEntity) {
        lineEntity.setId(id);
        LineEntity updatedLine = lineService.updateLine(lineEntity);
        return new ResponseEntity<>(updatedLine, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLine(@PathVariable Long id) {
        lineService.deleteLine(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/messagerie/{idMessagerie}")
    public ResponseEntity<List<LineEntity>> getLinesByMessagerieId(@PathVariable Long idMessagerie) {
        List<LineEntity> lines = lineService.findLinesByMessagerieId(idMessagerie);
        return new ResponseEntity<>(lines, HttpStatus.OK);
    }
}

