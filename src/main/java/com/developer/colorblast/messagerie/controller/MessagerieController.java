package com.developer.colorblast.messagerie.controller;

import com.developer.colorblast.client.entity.ClientEntity;
import com.developer.colorblast.client.service.ClientService;
import com.developer.colorblast.favoris.entity.FavorisEntity;
import com.developer.colorblast.messagerie.dto.response.MessagerieForClient;
import com.developer.colorblast.messagerie.dto.response.MessagerieForPro;
import com.developer.colorblast.messagerie.entity.MessagerieEntity;
import com.developer.colorblast.messagerie.service.MessagerieService;
import com.developer.colorblast.pro.entity.ProfessionnelEntity;
import com.developer.colorblast.pro.service.ProfessionnelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/messagerie")
public class MessagerieController {

    private final MessagerieService messagerieService;

    private final ClientService clientService;

    private final ProfessionnelService professionnelService;

    public MessagerieController(MessagerieService messagerieService, ClientService clientService, ProfessionnelService professionnelService) {
        this.messagerieService = messagerieService;
        this.clientService = clientService;
        this.professionnelService = professionnelService;
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

    /*@GetMapping("/client/{idClient}")
    public List<MessagerieEntity> getMessageriesByIdClient(@PathVariable Long idClient) {
        return messagerieService.getMessageriesByIdClient(idClient);
    }*/

    @GetMapping("/client/{idClient}")
    public List<MessagerieForClient> getMessageriesByIdClient(@PathVariable Long idClient) {
        List<MessagerieEntity> messageries =  messagerieService.getMessageriesByIdClient(idClient);
        Optional<ProfessionnelEntity> pro;
        List<MessagerieForClient> result = new ArrayList<>();
        for (MessagerieEntity message : messageries){
            pro = professionnelService.findById(message.getIdPro());
            if (pro.isPresent()){
                result.add(new MessagerieForClient(message,pro.get()));
            }

        }
        return result;
    }

    @GetMapping("/pro/{idPro}")
    public List<MessagerieForPro> getMessageriesByIdPro(@PathVariable Long idPro) {
        List<MessagerieEntity> messageries = messagerieService.getMessageriesByIdPro(idPro);
        Optional<ClientEntity> client;
        List<MessagerieForPro> result = new ArrayList<>();
        for (MessagerieEntity message : messageries) {
            client = clientService.findById(message.getIdClient());
            if (client.isPresent()){
                result.add(new MessagerieForPro(message, client.get()));
            }

        }
        return result;
    }
    /*@GetMapping("/pro/{idPro}")
    public List<MessagerieEntity> getMessageriesByIdPro(@PathVariable Long idPro) {
        return messagerieService.getMessageriesByIdPro(idPro);
    }*/

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
