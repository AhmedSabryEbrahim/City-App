package com.city.citylist.service;

import com.city.citylist.dto.CityDto;
import com.city.citylist.entity.CityEntity;
import com.city.citylist.mapper.CityMapper;
import com.city.citylist.repository.CityRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
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

    private CityEntity getCityEntityByName(final String cityName) {
        if (StringUtils.isNotBlank(cityName)) {
            final CityEntity cityEntity = cityRepository.findByCityName(cityName);
            if (cityEntity != null) {
                return cityEntity;
            }
        }
        log.debug("Cannot find any city with this name {}.", cityName);
        throw new NoSuchElementException("Cannot find any city with this name "+ cityName);
    }

    public CityDto getCityByName(final String cityName) {
        final CityEntity cityEntity = this.getCityEntityByName(cityName);
        return this.cityMapper.toCityDto(cityEntity);
    }

    public CityDto updateCityInfo(final String cityName, CityDto cityDto) {
        final CityEntity cityEntity = this.getCityEntityByName(cityName);

        if (StringUtils.isNotBlank(cityDto.getCityName())) {
            cityEntity.setCityName(cityDto.getCityName());
        }

        if (StringUtils.isNotBlank(cityDto.getLink())) {
            cityEntity.setLink(cityDto.getLink());
        }

        CityEntity result = cityRepository.save(cityEntity);
        return this.cityMapper.toCityDto(result);
    }

    public CityDto saveCityInfo(CityDto cityDto) {
        final CityEntity cityEntity = this.cityMapper.toCityEntity(cityDto);

        CityEntity result = cityRepository.save(cityEntity);
        return this.cityMapper.toCityDto(result);
    }


}
