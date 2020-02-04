package com.bladi.meep.service.impl;

import com.bladi.meep.boot.properties.Properties;
import com.bladi.meep.dao.VehicleDao;
import com.bladi.meep.model.entity.Vehicle;
import com.bladi.meep.model.mapper.VehicleMapper;
import com.bladi.meep.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;
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

    @Scheduled(fixedDelay = 60000)
    @Override
    public List<Vehicle> getVehicles() {
        String url = UriComponentsBuilder.fromUriString(properties.getPath())
                .queryParam("lowerwLeftLatLon", "38.711046,-9.160096")
                .queryParam("upperRightLatLon", "38.739429,-9.137115")
                .queryParam("companyZoneIds", "545,467,473")
                .toUriString();
        Vehicle[] objectData;
        try{
            log.info(" -- Calling vehicle service {}", new Date());
            objectData = restTemplate.getForObject(url,Vehicle[].class);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
        return VehicleMapper.mapVehicleArrayToVehicleList(objectData);
    }
}
