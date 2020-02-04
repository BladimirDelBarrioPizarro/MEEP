package com.bladi.meep.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private String id;
        @Column(name = "name")
        private String name;
        @Column(name = "x")
        private float x;
        @Column(name = "y")
        private float y;
        @Column(name = "licencePlate")
        private String licencePlate;
        @Column(name = "range")
        private int range;
        @Column(name = "batteryLevel")
        private int batteryLevel;
        @Column(name = "seats")
        private int seats;
        @Column(name = "model")
        private String model;
        @Column(name = "resourceImageId")
        private String resourceImageId;
        @Column(name = "pricePerMinuteParking")
        private float pricePerMinuteParking;
        @Column(name = "pricePerMinuteDriving")
        private float pricePerMinuteDriving;
        @Column(name = "realTimeData")
        private Boolean realTimeData;
        @Column(name = "engineType")
        private String engineType;
        @Column(name = "resourceType")
        private String resourceType;
        @Column(name = "companyZoneId")
        private int companyZoneId;
}
