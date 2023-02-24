package com.city.citylist.service;

import com.city.citylist.dto.CityDto;
import com.city.citylist.mapper.CityMapper;
import com.city.citylist.persistence.CityEntity;
import com.city.citylist.persistence.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    CityRepository cityRepository;
    @Autowired
    CityMapper cityMapper;

    public List<CityDto> getAllUsers() {
        final List<CityEntity> userEntities = cityRepository.findAll();
        final List<CityDto> cityDtos = this.cityMapper.cityListMapper(userEntities);
        return cityDtos;
    }
}
