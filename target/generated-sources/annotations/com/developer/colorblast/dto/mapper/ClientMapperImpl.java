package com.developer.colorblast.dto.mapper;

import com.developer.colorblast.dto.request.ClientRequest;
import com.developer.colorblast.dto.response.ClientResponse;
import com.developer.colorblast.entity.ClientEntity;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-03T20:38:37+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Amazon.com Inc.)"
)
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientEntity fromRequestToEntity(ClientRequest clientRequest) {
        if ( clientRequest == null ) {
            return null;
        }

        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setLastname( clientRequest.getLastname() );
        clientEntity.setFirstname( clientRequest.getFirstname() );
        clientEntity.setMail( clientRequest.getMail() );
        clientEntity.setPassword( clientRequest.getPassword() );
        clientEntity.setCountry( clientRequest.getCountry() );
        clientEntity.setDepartment( clientRequest.getDepartment() );
        clientEntity.setPostal_code( clientRequest.getPostal_code() );
        clientEntity.setCity( clientRequest.getCity() );
        clientEntity.setAddress( clientRequest.getAddress() );
        clientEntity.setAdmin( clientRequest.getAdmin() );

        return clientEntity;
    }

    @Override
    public ClientResponse fromEntityToResponse(ClientEntity clientEntity) {
        if ( clientEntity == null ) {
            return null;
        }

        ClientResponse clientResponse = new ClientResponse();

        clientResponse.setId( clientEntity.getId() );
        clientResponse.setLastname( clientEntity.getLastname() );
        clientResponse.setFirstname( clientEntity.getFirstname() );
        clientResponse.setPassword( clientEntity.getPassword() );
        clientResponse.setCountry( clientEntity.getCountry() );
        clientResponse.setDepartment( clientEntity.getDepartment() );
        clientResponse.setPostal_code( clientEntity.getPostal_code() );
        clientResponse.setCity( clientEntity.getCity() );
        clientResponse.setAddress( clientEntity.getAddress() );
        if ( clientEntity.getAdmin() != null ) {
            clientResponse.setAdmin( clientEntity.getAdmin() );
        }
        clientResponse.setMail( clientEntity.getMail() );

        return clientResponse;
    }
}
