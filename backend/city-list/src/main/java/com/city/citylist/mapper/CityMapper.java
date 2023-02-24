package com.city.citylist.mapper;

import com.city.citylist.dto.CityDto;
import com.city.citylist.entity.CityEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityMapper {
    public List<CityDto> toCityDtoList(List<CityEntity> cityEntities) {
        return cityEntities.stream().map(cityEntity -> {
            return this.toCityDto(cityEntity);
        }).toList();
    }

    public CityDto toCityDto(CityEntity cityEntity) {
        return new CityDto(cityEntity.getId(), cityEntity.getCityName(), cityEntity.getLink());
    }

    public List<CityEntity> toCityEntityList(List<CityDto> cityDtos) {
        return cityDtos.stream().map(cityDto -> {
            return this.toCityEntity(cityDto);
        }).toList();
    }

    public CityEntity toCityEntity(CityDto cityDto) {
        return new CityEntity(cityDto.getId(), cityDto.getCityName(), cityDto.getLink());
    }
}