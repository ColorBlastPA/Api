package com.developer.colorblast.favoris.dto.mapper;

import com.developer.colorblast.favoris.dto.request.FavorisRequest;
import com.developer.colorblast.favoris.dto.response.FavorisResponse;
import com.developer.colorblast.favoris.entity.FavorisEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FavorisMapper {
    FavorisMapper MAPPER = Mappers.getMapper(FavorisMapper.class);
    FavorisEntity fromRequestToEntity(FavorisRequest favorisRequest);
    FavorisResponse fromEntityToResponse(FavorisEntity favorisEntity);
}

