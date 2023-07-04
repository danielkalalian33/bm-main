package com.example.bm.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "irrigation")
public class Irrigation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "waterAmount")
    Double waterAmount;

    @Column(name = "timeSlotStart")
    LocalDateTime timeSlotStart;

    @Column(name = "timeSlotEnd")
    LocalDateTime timeSlotEnd;

    @ManyToOne(targetEntity = Plot.class)
    Plot plot;
}

/*
Create Table Statement:

CREATE TABLE `irrigation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `time_slot_end` datetime DEFAULT NULL,
  `time_slot_start` datetime DEFAULT NULL,
  `water_amount` double DEFAULT NULL,
  `plot_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtjl7ip8dlpud4k7hga9l0mtr1` (`plot_id`),
  CONSTRAINT `FKtjl7ip8dlpud4k7hga9l0mtr1` FOREIGN KEY (`plot_id`) REFERENCES `plot` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
*/