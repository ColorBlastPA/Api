package com.developer.colorblast.pro.dto.mapper;

import com.developer.colorblast.pro.dto.request.ProfessionnelRequest;
import com.developer.colorblast.pro.dto.response.ProfessionnelResponse;
import com.developer.colorblast.pro.entity.ProfessionnelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfessionnelMapper {
    ProfessionnelMapper MAPPER = Mappers.getMapper(ProfessionnelMapper.class);
    ProfessionnelEntity fromRequestToEntity(ProfessionnelRequest professionnelRequest);
    ProfessionnelResponse fromEntityToResponse(ProfessionnelEntity professionnelEntity);
}
