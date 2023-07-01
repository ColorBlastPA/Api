package com.developer.colorblast.controller;


import com.developer.colorblast.dto.request.ClientRequest;
import com.developer.colorblast.dto.response.ClientResponse;
import com.developer.colorblast.entity.ClientEntity;
import com.developer.colorblast.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
