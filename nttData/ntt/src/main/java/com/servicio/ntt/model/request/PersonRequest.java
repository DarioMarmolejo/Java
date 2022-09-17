package com.servicio.ntt.model.request;

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
public class PersonRequest {
    
    @NotEmpty(message = "{" + PersonConstants.ERRCODE_CODE_PERSON_NULL + "}")
    private String codigoPersona;
}
