package com.example.bm.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "agricultural_crop")
public class AgriculturalCrop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "cropName")
    String cropName;

    @Column(name = "waterAmount")
    Double waterAmount;
}

/*
Create Table Statement:

CREATE TABLE `agricultural_crop` (
  `id` int NOT NULL AUTO_INCREMENT,
  `crop_name` varchar(255) DEFAULT NULL,
  `water_amount` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
*/