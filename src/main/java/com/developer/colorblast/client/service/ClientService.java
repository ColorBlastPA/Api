package com.developer.colorblast.client.service;

import com.developer.colorblast.client.dto.request.ClientRequest;
import com.developer.colorblast.client.dto.response.ClientResponse;
import com.developer.colorblast.client.entity.ClientEntity;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<ClientEntity> findAllClient();
    Optional<ClientEntity> findById(Long id);
    ClientEntity saveClient(ClientEntity clientEntity);
    ClientEntity updateClient(ClientEntity clientEntity);
    void deleteClient(Long id);

    ClientResponse saveClient(ClientRequest clientRequest);
    ClientResponse updateClient(ClientRequest clientRequest, Long id);


    Optional<ClientEntity> findByMailAndPassword(String mail, String password);

    boolean existsByEmail(String email);

    Optional<ClientEntity> findByMail(String email);
}
