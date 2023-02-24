package com.city.citylist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cities", schema = "CITY_APP")
public class CityEntity {
    @Id
    private Integer id;
    private String cityName;
    private String link;
}
