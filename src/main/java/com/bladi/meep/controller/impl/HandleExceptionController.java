package com.bladi.meep.controller.impl;

import com.bladi.meep.model.dto.HttpErrorDTO;
import com.bladi.meep.model.exceptions.HandleExceptionGetVehicles;
import com.bladi.meep.model.mapper.VehicleMapper;
import com.bladi.meep.model.messages.ErrorMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Slf4j
@ControllerAdvice
public class HandleExceptionController {

    public static HttpServletRequest getCurrentRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        Assert.state(requestAttributes != null, "Could not find current request via RequestContextHolder");
        Assert.isInstanceOf(ServletRequestAttributes.class, requestAttributes);
        HttpServletRequest servletRequest = ((ServletRequestAttributes) requestAttributes).getRequest();
        Assert.state(true, "Could not find current HttpServletRequest");
        return servletRequest;
    }


    @ExceptionHandler(HandleExceptionGetVehicles.class)
    public ResponseEntity<HttpErrorDTO> handleExceptionFindUserName(Exception ex) {
        log.error(" -- ERROR HEALTHELP: User not found {} {} {} ",getCurrentRequest().getMethod(),getCurrentRequest().getContextPath(),
                getCurrentRequest().getRequestURI());
        return VehicleMapper.buildHttpErrorDTO(ErrorMessages.ERROR_GET_VEHICLES.getCode(), HttpStatus.NOT_FOUND,
                getCurrentRequest().getServletPath(), ErrorMessages.ERROR_GET_VEHICLES.getMessage(),getCurrentRequest().getMethod(),new Date());
    }
}
