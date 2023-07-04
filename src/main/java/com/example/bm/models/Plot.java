package com.example.bm.models;

import com.example.bm.enums.Status;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "plot")
public class Plot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @ManyToOne(targetEntity = AgriculturalCrop.class)
    AgriculturalCrop crop;

    @Column(name = "cultivatedArea")
    Double cultivatedArea;

    @Column(name = "isIrrigated")
    Boolean isIrrigated;

    @Column(name = "sensorStatus")
    Status sensorStatus;

    @Transient
    Integer retryCount = 0;
}

/*
Create Table Statement:

CREATE TABLE `plot` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cultivated_area` double DEFAULT NULL,
  `is_irrigated` bit(1) DEFAULT NULL,
  `crop_id` int DEFAULT NULL,
  `sensor_status` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2e89c50nt4nfyxtgaq3ejfnin` (`crop_id`),
  CONSTRAINT `FK2e89c50nt4nfyxtgaq3ejfnin` FOREIGN KEY (`crop_id`) REFERENCES `agricultural_crop` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
*/