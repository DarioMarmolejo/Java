package com.servicio.ntt.exception;

import java.time.ZonedDateTime;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.servicio.ntt.constant.Constants;
import com.servicio.ntt.constant.SpecialCharacterConstants;

public class ErrorResponse {
    
  /**
   * Tipo de error.
   */
  private String type;
  /**
   * Código del error.
   */
  private String code;
  /**
   * Detalles del error.
   */
  private String details;
  /**
   * Ubicación del error.
   */
  private String location;
  /**
   * Información adicional del error.
   */
  private String moreInfo;
  /**
   * UUID header de la petición.
   */
  private String uuid;
  /**
   * Fecha y hora cuando ocurre el error.
   */
  private ZonedDateTime timestamp;

  /**
   * Método para obtener el tipo de error.
   * 
   * @return type
   */
  public String getType() {
    return type != null ? type : SpecialCharacterConstants.EMPTY_STRING;
  }

  /**
   * Método para obtener el código de error.
   * 
   * @return code
   */
  public String getCode() {
    return code != null ? code : SpecialCharacterConstants.EMPTY_STRING;
  }

  /**
   * Método para obtener el detalle del error.
   * 
   * @return details
   */
  public String getDetails() {
    return details != null ? details : SpecialCharacterConstants.EMPTY_STRING;
  }

  /**
   * Método para obtener la ubicación del error.
   * 
   * @return location
   */
  public String getLocation() {
    return location != null ? location : SpecialCharacterConstants.EMPTY_STRING;
  }

  /**
   * Método para obtener la información adicional del error.
   * 
   * @return more info
   */
  public String getMoreInfo() {
    return moreInfo != null ? moreInfo : SpecialCharacterConstants.EMPTY_STRING;
  }

  /**
   * Método para obtener el UUID.
   * 
   * @return uuid
   */
  public String getUuid() {
    return uuid != null ? uuid : SpecialCharacterConstants.EMPTY_STRING;
  }

  /**
   * Método para obtener fecha y hora del error en formato yyyy-MM-dd'T'HH:mm:ssZ.
   * 
   * @return timestamp
   */
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
  public ZonedDateTime getTimestamp() {
    return timestamp;
  }

  public ErrorResponse(){

  }

  public ErrorResponse(ICustomExceptions ex, HttpServletRequest req, ZonedDateTime timestamp){
    type = ex.getType();
    code = ex.getCode();
    details = ex.getDetails();
    location = req.getRequestURI();
    moreInfo = ex.getMoreInfo();
    uuid = req.getHeader(Constants.UUID);
    this.timestamp = timestamp;
  }
}
