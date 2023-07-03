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

}
