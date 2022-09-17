package com.servicio.ntt.model.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditPersonResponse {
    
    private String codigoPersona;

    private String primerNombre;

    private String segundoNombre;

    private String primerApellido;

    private String segundoApellido;

    private Integer edad;

    private String estadoCivil;

    private String email;

    private Integer telefonoMovil;

    private Integer telefonoFijo;

    private boolean estatus;

    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaActualizacion;
}
