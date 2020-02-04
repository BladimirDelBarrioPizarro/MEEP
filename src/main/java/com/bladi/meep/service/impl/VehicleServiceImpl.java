package com.bladi.meep.service.impl;

import com.bladi.meep.boot.properties.Properties;
import com.bladi.meep.dao.VehicleDao;
import com.bladi.meep.model.entity.Vehicle;
import com.bladi.meep.model.mapper.VehicleMapper;
import com.bladi.meep.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Slf4j
public class VehicleServiceImpl implements VehicleService {

    private VehicleDao vehicleDao;
    private RestTemplate restTemplate;
    private Properties properties;

    public VehicleServiceImpl(VehicleDao vehicleDao, Properties properties, RestTemplate restTemplate) {
        this.vehicleDao = vehicleDao;
        this.properties = properties;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Vehicle> getVehicles(String lowerwLeftLatLon, String upperRightLatLon, String companyZoneIds) {
        String url = UriComponentsBuilder.fromUriString(properties.getPath())
                .queryParam("lowerwLeftLatLon", lowerwLeftLatLon)
                .queryParam("upperRightLatLon", upperRightLatLon)
                .queryParam("companyZoneIds", companyZoneIds)
                .toUriString();
        Vehicle[] objectData;
        try{
            log.info(" -- Calling vehicle service");
            objectData = restTemplate.getForObject(url,Vehicle[].class);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
        return VehicleMapper.mapVehicleArrayToVehicleList(objectData);
    }
}
