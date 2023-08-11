package com.developer.colorblast.line.controller;

import com.developer.colorblast.line.entity.LineEntity;
import com.developer.colorblast.line.service.LineService;
import com.developer.colorblast.messagerie.entity.MessagerieEntity;
import com.developer.colorblast.messagerie.service.MessagerieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lines")
public class LineController {
    private final LineService lineService;

    private final MessagerieService messagerieService;

    public LineController(LineService lineService, MessagerieService messagerieService) {
        this.lineService = lineService;
        this.messagerieService = messagerieService;
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
        Optional<MessagerieEntity> messagerieEntity = messagerieService.findById(lineEntity.getIdMessagerie());
        messagerieEntity.get().setLastMessage(lineEntity.getContent());
        messagerieEntity.get().setDLastMessage(lineEntity.getDate());
        messagerieService.updateMessagerie(messagerieEntity.get());
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

