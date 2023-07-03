package com.developer.colorblast.client.dto.mapper;

import com.developer.colorblast.client.dto.response.ClientResponse;
import com.developer.colorblast.client.dto.request.ClientRequest;
import com.developer.colorblast.client.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {
    ClientMapper MAPPER = Mappers.getMapper(ClientMapper.class);
    ClientEntity fromRequestToEntity(ClientRequest clientRequest);
    ClientResponse fromEntityToResponse(ClientEntity clientEntity);
}
