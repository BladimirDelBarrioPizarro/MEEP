package com.bladi.meep.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HttpErrorDTO {private Integer code;
    private String statusText;
    private String url;
    private String message;
    private String method;
    private String date;

}
