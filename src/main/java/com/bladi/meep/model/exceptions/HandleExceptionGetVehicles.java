package com.bladi.meep.model.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HandleExceptionGetVehicles extends RuntimeException {

    public HandleExceptionGetVehicles(Exception ex){
        super(ex.getMessage());
    }
}
