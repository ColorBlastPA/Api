package com.developer.colorblast.client.service.impl;

import com.developer.colorblast.client.dto.mapper.ClientMapper;
import com.developer.colorblast.client.dto.request.ClientRequest;
import com.developer.colorblast.client.dto.response.ClientResponse;
import com.developer.colorblast.client.entity.ClientEntity;
import com.developer.colorblast.client.repository.ClientRepository;
import com.developer.colorblast.client.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientEntity> findAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<ClientEntity> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public ClientEntity saveClient(ClientEntity clientEntity) {
        return clientRepository.save(clientEntity);
    }

    @Override
    public ClientEntity updateClient(ClientEntity clientEntity) {
        return clientRepository.save(clientEntity);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }


    @Override
    public ClientResponse saveClient(ClientRequest clientRequest) {
        ClientEntity clientEntity = ClientMapper.MAPPER.fromRequestToEntity(clientRequest);
        clientRepository.save(clientEntity);
        return ClientMapper.MAPPER.fromEntityToResponse(clientEntity);
    }

    @Override
    public ClientResponse updateClient(ClientRequest clientRequest, Long id) {

        Optional<ClientEntity> checkExistingClient = findById(id);
        if (! checkExistingClient.isPresent())
            throw new RuntimeException("Employee Id "+ id + " Not Found!");

        ClientEntity clientEntity = ClientMapper.MAPPER.fromRequestToEntity(clientRequest);
        clientEntity.setId(id);
        clientRepository.save(clientEntity);
        return ClientMapper.MAPPER.fromEntityToResponse(clientEntity);
    }

    @Override
    public Optional<ClientEntity> findByMailAndPassword(String mail, String password) {
        return clientRepository.findByMailAndPassword(mail, password);
    }

}
