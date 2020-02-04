package com.bladi.meep.boot.config;

import com.bladi.meep.boot.properties.Properties;
import com.bladi.meep.controller.VehicleController;
import com.bladi.meep.controller.impl.VehicleControllerImpl;
import com.bladi.meep.dao.VehicleDao;
import com.bladi.meep.service.VehicleService;
import com.bladi.meep.service.impl.VehicleServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApiConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Properties properties(){
        return new Properties();
    }

    @Bean
    public VehicleService vehicleService(VehicleDao vehicleDao,Properties properties,RestTemplate restTemplate){
        return new VehicleServiceImpl(vehicleDao,properties,restTemplate);
    }


    @Bean
    public VehicleController vehicleController(VehicleService vehicleService){
        return new VehicleControllerImpl(vehicleService);
    }



}
