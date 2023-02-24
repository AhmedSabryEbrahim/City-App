package com.city.citylist.mapper;

import com.city.citylist.dto.CityDto;
import com.city.citylist.persistence.CityEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {
    List<CityDto> cityListMapper(List<CityEntity> cityEntities);


    CityDto cityDtoMapper(CityEntity cityEntity);
}