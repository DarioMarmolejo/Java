package com.servicio.ntt.exception.custom;

import java.util.Collections;
import java.util.List;

/**
 * Clase que representa la excepcion para cuando la peticion tiene parametros o headers incorrectos
 * que no pueden ser procesados.
 * 
 */
public class BadRequestException  extends RuntimeException{
    /**
   * Lista de campos incorrectos en la peticion.
   */
  private final List<String> badFields;

  /**
   * Constructor para inizializar la lista de campos incorrectos.
   * 
   * @param message mensaje de excepción arrojada por bad request.
   * @param badFields lista de campos que originaron la excepción.
   */
  public BadRequestException(String message, List<String> badFields) {
    super(message);
    this.badFields = Collections.unmodifiableList(badFields);
  }

  /**
   * Método para obtener la lista de campos.
   * 
   * @return List Lista de los campos.
   */
  public List<String> getBadFields() {
    return badFields;
  }
}
