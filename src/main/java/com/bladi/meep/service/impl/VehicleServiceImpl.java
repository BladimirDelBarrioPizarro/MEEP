package com.bladi.meep.service.impl;

import com.bladi.meep.boot.properties.Properties;
import com.bladi.meep.dao.VehicleDao;
import com.bladi.meep.model.dto.VehicleDTO;
import com.bladi.meep.model.entity.Vehicle;
import com.bladi.meep.model.mapper.VehicleMapper;
import com.bladi.meep.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<VehicleDTO> getVehicles() {
        String url = UriComponentsBuilder.fromUriString(properties.getPath())
                .queryParam("lowerwLeftLatLon", "38.711046,-9.160096")
                .queryParam("upperRightLatLon", "38.739429,-9.137115")
                .queryParam("companyZoneIds", "545,467,473")
                .toUriString();
        Vehicle[] objectData;
        try{
            log.info(" -- Calling vehicle service {}", new Date());
            objectData = restTemplate.getForObject(url,Vehicle[].class);
            List <Vehicle> vehicles = vehicleDao.saveAll(VehicleMapper.mapVehicleArrayToVehicleList(objectData));
            List<Vehicle> vehiclesBBDD = vehicleDao.findAll();
            List<Vehicle> all = setListVehicles(vehicles,vehiclesBBDD);
            return VehicleMapper.mapVehicleListToVehicleDTOList(all);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }

    }

    private List<Vehicle> setListVehicles(List<Vehicle> vehicles, List<Vehicle> vehiclesBBDD) {
        vehicles.addAll(vehiclesBBDD);
        return vehicles.stream().filter(item -> item.getRange() > 50 ).collect(Collectors.toList());
    }
}
