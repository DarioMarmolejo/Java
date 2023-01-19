package com.servicio.ntt.exception.custom;

import java.time.ZonedDateTime;

import com.servicio.ntt.constant.Constants;
import com.servicio.ntt.constant.SpecialCharacterConstants;
import com.servicio.ntt.exception.ICustomExceptions;

import lombok.Getter;

@Getter
public class BadParametersException extends RuntimeException implements ICustomExceptions {

    /**
     * UID autogenerado para el versionado de la clase.
     */
    private static final long serialVersionUID = 8925303792177335247L;

    /**
     * Http Status que se asignara.
     */
    private final int status;

    /**
     * Tipo de error.
     */
    private final String type;

    /**
     * Codigo que se definio para el error especifico.
     */
    private final String code;

    /**
     * Detalles del error.
     */
    private final String details;

    /**
     * Informacion adicional para casos especificos.
     */
    private final String moreInfo;

    /**
     * Fecha y hora en que ocurrio el error..
     */
    private final ZonedDateTime timestamp;

    /**
     * Constructor que inicializa los valores por defecto.
     */
    public BadParametersException() {

        super();

        this.status = Constants.CODE_BAD_REQUEST;
        this.type = Constants.TYPE_INVALID;
        this.code = "400";
        this.details = Constants.MSG_BAD_REQUEST;
        this.moreInfo = SpecialCharacterConstants.EMPTY_STRING;
        this.timestamp = ZonedDateTime.now();

    }

    public BadParametersException(String details) {

        super();

        this.status = Constants.CODE_BAD_REQUEST;
        this.type = Constants.TYPE_INVALID;
        this.code = "400";
        this.details = details;
        this.moreInfo = SpecialCharacterConstants.EMPTY_STRING;
        this.timestamp = ZonedDateTime.now();

    }

}
