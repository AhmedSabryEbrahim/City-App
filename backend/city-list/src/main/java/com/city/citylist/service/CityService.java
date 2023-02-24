package com.city.citylist.service;

import com.city.citylist.dto.CityDto;
import com.city.citylist.mapper.CityMapper;
import com.city.citylist.entity.CityEntity;
import com.city.citylist.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    CityRepository cityRepository;
    @Autowired
    CityMapper cityMapper;

    public List<CityDto> getAllCities() {
        final List<CityEntity> userEntities = cityRepository.findAll();
        final List<CityDto> cityDtos = this.cityMapper.toCityDtoList(userEntities);
        return cityDtos;
    }

    public List<CityDto> getCityByName(String cityName) {
        final List<CityEntity> cityEntity = cityRepository.findByCityName(cityName);
        return this.cityMapper.toCityDtoList(cityEntity);
    }

    public CityDto saveCity(CityDto cityDto) {
        final CityEntity cityEntity = this.cityMapper.toCityEntity(cityDto);
        return this.cityMapper.toCityDto(cityRepository.saveCity(cityEntity));
    }
}
