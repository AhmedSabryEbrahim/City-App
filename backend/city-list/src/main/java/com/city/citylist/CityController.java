package com.city.citylist;

import com.city.citylist.dto.CityDto;
import com.city.citylist.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("")
    public List<CityDto> getAllCities() {
        return this.cityService.getAllCities();
    }

    @GetMapping("/{cityName}")
    public List<CityDto> getCityById(@PathVariable("cityName") String cityName) {
        return this.cityService.getCityByName(cityName);
    }

    @PostMapping("/")
    public CityDto addCity(@RequestBody CityDto cityDto) {
        return this.cityService.saveCity(cityDto);
    }
}
