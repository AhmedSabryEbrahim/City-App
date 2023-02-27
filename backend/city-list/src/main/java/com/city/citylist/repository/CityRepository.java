package com.city.citylist.repository;

import com.city.citylist.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Integer> {
    List<CityEntity> findAll();
    CityEntity findByCityName(String cityName);

}
