package com.developer.colorblast.client.controller;


import com.developer.colorblast.client.dto.request.ClientRequest;
import com.developer.colorblast.client.dto.response.ClientResponse;
import com.developer.colorblast.client.entity.ClientEntity;
import com.developer.colorblast.client.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<ClientEntity> findAllClient() {
        return clientService.findAllClient();
    }

    @GetMapping("/{id}")
    public Optional<ClientEntity> findClientById(@PathVariable("id") Long id) {
        return clientService.findById(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginClient(@RequestBody Map<String, String> loginRequest) {
        String mail = loginRequest.get("mail");
        String password = loginRequest.get("password");

        Optional<ClientEntity> client = clientService.findByMailAndPassword(mail, password);
        if (client.isPresent()) {
            return ResponseEntity.ok(client.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ClientEntity saveClient(@RequestBody ClientEntity clientEntity) {
        return clientService.saveClient(clientEntity);
    }

    @PutMapping
    public ClientEntity updateClient(@RequestBody ClientEntity clientEntity) {
        //clientService.deleteClient(clientEntity.getId());
        return clientService.updateClient(clientEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable("id") Long id) {
        clientService.deleteClient(id);
    }


    @PostMapping("/res")
    public ClientResponse saveClientResponse(@RequestBody ClientRequest clientRequest) {
        return clientService.saveClient(clientRequest);
    }

    @PutMapping("/res/{id}")
    public ClientResponse updateClientResponse(@RequestBody ClientRequest clientRequest, @PathVariable("id") Long id) {
        return clientService.updateClient(clientRequest, id);
    }


    @PostMapping("/checkEmail")
    public ResponseEntity<?> checkEmailExists(@RequestBody Map<String, String> emailRequest) {
        String email = emailRequest.get("email");

        if (clientService.existsByEmail(email)) {
            return ResponseEntity.ok("Un compte avec cet e-mail existe déjà.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findByMail/{email}")
    public ResponseEntity<ClientEntity> findClientByMail(@PathVariable String email) {
        Optional<ClientEntity> client = clientService.findByMail(email);
        if (client.isPresent()) {
            return ResponseEntity.ok(client.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
