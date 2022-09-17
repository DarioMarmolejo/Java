package com.servicio.ntt.model.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.servicio.ntt.constant.PersonConstants;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreatePersonRequest {
    
    
    @NotEmpty(message = "{" + PersonConstants.ERRCODE_FIRST_NAME_NULL + "}")
    private String primerNombre;

    @NotEmpty(message = "{" + PersonConstants.ERRCODE_LAST_NAME_NULL + "}")
    private String primerApellido;

    @Max(value =99, message = "{" + PersonConstants.ERRCODE_AGEMAX_NULL + "}")
    @Min(value =1, message =  "{"+ PersonConstants.ERRCODE_AGEMIN_NULL + "}")
    private Integer edad;

    @NotEmpty(message = "{" + PersonConstants.ERRCODE_CIVIL_NULL + "}")
    private String estadoCivil;

    @NotEmpty(message = "{" + PersonConstants.ERRCODE_EMAIL_NAME_NULL+ "}")
    private String email;

}
