package com.lucainnocenti.agitado.repository.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor
public class HeatingState {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double price;

    private String brand;


}
