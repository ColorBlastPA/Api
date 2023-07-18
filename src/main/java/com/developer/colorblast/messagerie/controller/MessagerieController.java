package com.developer.colorblast.messagerie.controller;

import com.developer.colorblast.messagerie.entity.MessagerieEntity;
import com.developer.colorblast.messagerie.service.MessagerieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/messagerie")
public class MessagerieController {

    private final MessagerieService messagerieService;

    public MessagerieController(MessagerieService messagerieService) {
        this.messagerieService = messagerieService;
    }

    @GetMapping
    public ResponseEntity<List<MessagerieEntity>> getAllMessagerie() {
        List<MessagerieEntity> messagerieEntities = messagerieService.findAllMessagerie();
        return new ResponseEntity<>(messagerieEntities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessagerieEntity> getMessagerieById(@PathVariable Long id) {
        Optional<MessagerieEntity> messagerieEntity = messagerieService.findById(id);
        return messagerieEntity.map(entity -> new ResponseEntity<>(entity, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/client/{idClient}")
    public List<MessagerieEntity> getMessageriesByIdClient(@PathVariable Long idClient) {
        return messagerieService.getMessageriesByIdClient(idClient);
    }

    @GetMapping("/pro/{idPro}")
    public List<MessagerieEntity> getMessageriesByIdPro(@PathVariable Long idPro) {
        return messagerieService.getMessageriesByIdPro(idPro);
    }

    @PostMapping
    public ResponseEntity<MessagerieEntity> createMessagerie(@RequestBody MessagerieEntity messagerieEntity) {
        MessagerieEntity savedMessagerie = messagerieService.saveMessagerie(messagerieEntity);
        return new ResponseEntity<>(savedMessagerie, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessagerieEntity> updateMessagerie(@PathVariable Long id, @RequestBody MessagerieEntity messagerieEntity) {
        if (!id.equals(messagerieEntity.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        MessagerieEntity updatedMessagerie = messagerieService.updateMessagerie(messagerieEntity);
        return new ResponseEntity<>(updatedMessagerie, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessagerie(@PathVariable Long id) {
        messagerieService.deleteMessagerie(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
