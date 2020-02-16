package com.bladi.meep.test;

import com.bladi.meep.dao.VehicleDao;
import com.bladi.meep.model.entity.Vehicle;
import com.bladi.meep.test.dummy.VehicleDummy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VehicleDaoTest {

    private VehicleDao vehicleDao = mock(VehicleDao.class);

    @Test
    void getVehicleTest(){
        List<Vehicle> vehicleList = VehicleDummy.vehicleListDummy();
        when(vehicleDao.findAll()).thenReturn(vehicleList);
        List<Vehicle> vehicles = vehicleDao.findAll();
        assert (vehicles.size() > 0);
    }
}
