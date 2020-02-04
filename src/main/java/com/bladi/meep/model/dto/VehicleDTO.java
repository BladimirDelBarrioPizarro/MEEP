package com.bladi.meep.model.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder
public class VehicleDTO {
    private String id;
    private String name;
    private float x;
    private float y;
    private String licencePlate;
    private int range;
    private int batteryLevel;
    private int seats;
    private String model;
    private String resourceImageId;
    private float pricePerMinuteParking;
    private float pricePerMinuteDriving;
    private Boolean realTimeData;
    private String engineType;
    private String resourceType;
    private int companyZoneId;
}
