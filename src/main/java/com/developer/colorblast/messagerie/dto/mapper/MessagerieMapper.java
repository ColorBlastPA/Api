package com.developer.colorblast.messagerie.dto.mapper;

import com.developer.colorblast.messagerie.dto.request.MessagerieRequest;
import com.developer.colorblast.messagerie.dto.response.MessagerieResponse;
import com.developer.colorblast.messagerie.entity.MessagerieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MessagerieMapper {
    MessagerieMapper MAPPER = Mappers.getMapper(MessagerieMapper.class);

    MessagerieEntity fromRequestToEntity(MessagerieRequest messagerieRequest);
    MessagerieResponse fromEntityToResponse(MessagerieEntity messagerieEntity);
}
