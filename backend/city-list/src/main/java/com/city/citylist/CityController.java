package com.city.citylist;

import com.city.citylist.dto.CityDto;
import com.city.citylist.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("/cities")
    public List<CityDto> getAllCities() {
        return this.cityService.getAllUsers();
    }
}
