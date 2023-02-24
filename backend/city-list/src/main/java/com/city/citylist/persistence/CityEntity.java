package com.city.citylist.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
