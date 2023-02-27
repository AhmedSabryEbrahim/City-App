package com.city.citylist;

import com.city.citylist.dto.CityDto;
import com.city.citylist.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/cities")
@CrossOrigin("*")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("")
    public ResponseEntity<List<CityDto>> getAllCities() {
        final List<CityDto> cityDtoList = this.cityService.getAllCities();
        return ResponseEntity.status(HttpStatus.OK).body(cityDtoList);
    }

    @GetMapping("/{cityName}")
    public ResponseEntity getCityById(@PathVariable("cityName") String cityName) {
        try {
            final CityDto cityDto = this.cityService.getCityByName(cityName);
            return ResponseEntity.status(HttpStatus.OK).body(cityDto);
        } catch (NoSuchElementException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity addCity(@RequestBody CityDto cityDto) {
        try {
            final CityDto result = this.cityService.saveCityInfo(cityDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (NoSuchElementException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @PutMapping("/{cityName}")
    public ResponseEntity saveCity(@PathVariable("cityName") String cityName, @RequestBody CityDto cityDto) {
        try {
            final CityDto result = this.cityService.updateCityInfo(cityName, cityDto);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (NoSuchElementException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }
}
