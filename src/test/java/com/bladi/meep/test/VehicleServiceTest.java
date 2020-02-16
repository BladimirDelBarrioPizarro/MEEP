package com.bladi.meep.test;

import com.bladi.meep.model.dto.VehicleDTO;
import com.bladi.meep.service.VehicleService;
import com.bladi.meep.test.dummy.VehicleDummy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceTest {

    private VehicleService vehicleService = mock(VehicleService.class);

    @Test
    void getVehicleTest(){
        List<VehicleDTO> vehicleDTOSDummy = VehicleDummy.vehicleDTOListDummy();
        when(vehicleService.getVehicles()).thenReturn(vehicleDTOSDummy);
        List<VehicleDTO> vehicleDTOSList =  vehicleService.getVehicles();
        assert (vehicleDTOSList.size()>0);
    }
}
