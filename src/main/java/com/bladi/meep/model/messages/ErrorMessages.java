package com.bladi.meep.model.messages;

import lombok.Getter;

@Getter
public enum ErrorMessages {

    ERROR_GET_VEHICLES(201,"Error al obtener los vehículos de la zona especificada.");

    private Integer code;
    private String message;


    ErrorMessages(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
