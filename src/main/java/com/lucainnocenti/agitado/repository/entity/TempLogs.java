package com.lucainnocenti.agitado.repository.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Entity
@Data
@NoArgsConstructor
public class TempLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtempLogs;

    private int zoneId;
    private String zoneDesc;
    ZonedDateTime eventDate;
    private String tempLogscol;
    private boolean heatingActive;
    private double temperature;
    private double umidity;
    private double extTemperature;
    private double extSolarIntensity;


}
