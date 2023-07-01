package com.developer.colorblast.dto.mapper;

import com.developer.colorblast.dto.request.ClientRequest;
import com.developer.colorblast.dto.response.ClientResponse;
import com.developer.colorblast.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {
    ClientMapper MAPPER = Mappers.getMapper(ClientMapper.class);
    ClientEntity fromRequestToEntity(ClientRequest clientRequest);
    ClientResponse fromEntityToResponse(ClientEntity clientEntity);
}
