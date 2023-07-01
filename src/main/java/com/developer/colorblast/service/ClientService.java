package com.developer.colorblast.service;

import com.developer.colorblast.dto.request.ClientRequest;
import com.developer.colorblast.dto.response.ClientResponse;
import com.developer.colorblast.entity.ClientEntity;

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


}
