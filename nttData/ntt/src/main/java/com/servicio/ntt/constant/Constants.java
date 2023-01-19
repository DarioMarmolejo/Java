package com.servicio.ntt.constant;

/**
 * Clase de constantes generales dela aplicacion.
 */
public class Constants {

  private Constants() {
  }

  public static final java.lang.String LOG_BEG = "Inicio";

  public static final java.lang.String LOG_END = "Fin";

  public static final java.lang.String MESSAGE = "message";

  public static final java.lang.String EMPTY_STRING = "";

  /**
   * Constante que contiene el valor del base path.
   */
  public static final String BASE_PATH = "${api.uri.basePath}";

  /**
   * Constante que contiene el valor del base path.
   */
  public static final String API_VALUE = "${api.uri.opticalCharacterReader.value}";

  /**
   * 
   */
  public static final String API_TEXTRACT_SERVICE_XAPIKEY = "${constants.feign.textract.endPoint.scanTextract.keyApiKey}";

  /**
   * 
   */
  public static final String API_TEXTRACT_SERVICE_ENDPOINT_VALUE = "${constants.feign.textract.endPoint.scanTextract.value}";

  /**
   * 
   */
  public static final String API_TEXTRACT_SERVICE_VALUE = "${constants.feign.textract.value}";
  /**
   * 
   */
  public static final String API_TEXTRACT_SERVICE_URL = "${constants.feign.textract.url}";

  /**
   * Constante que representa el header Content-Type.
   */
  public static final String CONTENT_TYPE = "Content-Type";

  /**
   * Constante que representa el header x-api-key
   */
  public static final String HEADER_XAPIKEY = "x-api-key";

  /**
   * Constante que representa el header Content-Type.
   */
  public static final String UUID = "uuid";

  /**
   * Constante que indica si se imprimiran headers o no.
   */
  public static final String PRINT_HEADERS = "${api.headers.print}";

  /**
   * Constante que indica si se imprimiran headers o no.
   */
  public static final long DOCUMENT_MAX_LENGTH = 2000000L;

  /**
   * Constante que indica si se imprimiran headers o no.
   */
  public static final long DOCUMENT_MIN_LENGTH = 500L;

  /**
   * Constante que contiene la cadena OK.
   */
  public static final String OK = "OK";

  /**
   * Constante que representa la cadena JSON.
   */
  public static final String JSON_STRING = "JSON";

  /**
   * Constante que representa la cadena N.
   */
  public static final String N = "N";

  /**
   * Constante que representa la cadena Y.
   */
  public static final String Y = "Y";

  /**
   * Constante que representa el tipo "ERROR"
   */
  public static final String TYPE_ERROR = "ERROR";

  /**
   * Constante que representa el tipo "FATAL"
   */
  public static final String TYPE_FATAL = "FATAL";

  /**
   * Constante que representa el tipo "INVALID"
   */
  public static final String TYPE_INVALID = "INVALID";

  /**
   * Constante que representa el detail para ImageLengthOverflow.
   */
  public static final String MSG_IMAGE_LENGTH_OVERFLOW = "Imagen sobrepasa el tamaño límite permitido.";

  /**
   * Constante que representa el detail para Internal Server Error.
   */
  public static final String MSG_INTERNAL_SERVER_ERROR = "Se ha producido un error. Favor de intentarlo más Tarde.";

  /**
   * Constante que representa el detail para MD5 not match.
   */
  public static final String MSG_MD5_NOT_MATCH = "El MD5 no corresponde al de las imágenes.";

  /**
   * Constante que representa el detail para Bad Request.
   */
  public static final String MSG_BAD_REQUEST = "Encabezado, solicitud o parámetros inválidos.";

  /**
   * Constante que representa el detail para Request Timeout.
   */
  public static final String MSG_REQUEST_TIMEOUT = "Se superó el tiempo máximo de espera.";

  /**
   * Constante que representa el detail para Not Acceptable.
   */
  public static final String MSG_NOT_ACCEPTABLE = "Error imagen no legible.";

  /**
   * Constante que representa el detail para Bad Gateway.
   */
  public static final String MSG_BAD_GATWAY = "Respuesta no válida del servidor ascendente";

  /**
   * Constante que representa el tipo de error.
   */
  public static final String ERROR_TYPE = "type: {}";

  /**
   * Constante que representa el codigo de error.
   */
  public static final String ERROR_CODE = "code: {}";

  /**
   * Constante que representa el detalle del error.
   */
  public static final String ERROR_DETAILS = "details: {}";

  /**
   * Constante que representa la URI invocada.
   */
  public static final String ERROR_LOCATION = "location: {}";

  /**
   * Constante que representa informacion adicional del error.
   */
  public static final String ERROR_MORE_INFORMATION = "moreInfo: {}";

  /**
   * Constante usada como llave para el atributo uuid header.
   */
  public static final String UUID_MDC_LABEL = "mdc.uuid";

  /**
   * Constante para limprimir los headers de la peticion.
   */
  public static final String MSG_TO_LOG_HEADER = "[{} : {}]";

  /**
   * Constante para la llave req.t0 que almacenara el momento de inicio de la
   * peticion.
   */
  public static final String T0_REQ_ATTRIBUTE = "req.t0";

  /**
   * Constante para mostrar el inicio de la peticion.
   */
  public static final String START_REQUEST = "Inicia Llamado [{}]";

  /**
   * Constante para mostrar el tiempo de petición y respuesta.
   */
  public static final String TIME_ELAPSED_MESSAGE = "Time elapsed for request/response roundtrip [{}], {} ms";

  /**
   * Constante que repsenta la cadena {}.
   */
  public static final String MSG_CURLY_BRACKETS = "{}";

  /**
   * Constante que representa un mensaje de error cuando no trae cuerpo.
   */
  public static final String MSG_ERROR_RESPONSE_HAS_NO_BODY = "Failed to parse the playload: Response has no body.";

  /**
   * Constante que representa un mensaje de error cuando el body de error no
   * corresponde con el pre definido.
   */
  public static final String MSG_ERROR_FORMAT = "Failed to parse the playload. The format of the message does not "
      + "correspond with the predefined {}";

  /**
   * Constante del mensaje de estatus de la peticion.
   */
  public static final String MSG_STATUS = "status";

  /**
   * Constante del mensaje de la petición.
   */
  public static final String MSG_REQUEST = "request";

  /**
   * Constante del mensaje de la respuesta.
   */
  public static final String MSG_RESPONSE = "response";

  /**
   * Constante de los detalles de error del cliente feign.
   */
  public static final String ERROR_FEIGN_DETAILS = "Error feign details {}";

  /**
   * Constante que representa la cadena type.
   */
  public static final String ERROR_RESPONSE_TYPE = "type";

  /**
   * Constante que representa la cadena code.
   */
  public static final String ERROR_RESPONSE_CODE = "code";

  /**
   * Constante que representa la cadena details.
   */
  public static final String ERROR_RESPONSE_DETAILS = "details";

  /**
   * Constante que representa la cadena location.
   */
  public static final String ERROR_RESPONSE_LOCATION = "location";

  /**
   * Constante que representa la cadena moreInfo.
   */
  public static final String ERROR_RESPONSE_MORE_INFORMATION = "moreInfo";

  /**
   * Constante que representa la cadena timestamp.
   */
  public static final String ERROR_RESPONSE_TIMESTAMP = "timestamp";

  /**
   * Constante que representa el nombre de la excepcion DownstreamException.
   */
  public static final String DOWNSTREAMEXCEPTION = "DownstreamException";

  /**
   * Constante que representa el header Accept.
   */
  public static final String ACCEPT = "Accept";

  /**
   * Constante que representa el header Authorization.
   */
  public static final String AUTHORIZATION = "Authorization";

  /**
   * Constante que representa el header deviceId.
   */
  public static final String DEVICE_ID = "deviceId";

  /**
   * Constante que representa el header client_id.
   */
  public static final String CLIENT_ID = "client_id";

  /**
   * Constante que representa el header Accept-Language.
   */
  public static final String ACCEPT_LANGUAGE = "Accept-Language";

  /**
   * Constante que representa el header Host.
   */
  public static final String HOST = "Host";

  /**
   * Constante que representa el header User-Agent.
   */
  public static final String USER_AGENT = "User-Agent";

  /**
   * Constante que representa el header Content-Encoding.
   */
  public static final String CONTENT_ENCODING = "Content-Encoding";

  /**
   * Constante que representa el header Content-Language.
   */
  public static final String CONTENT_LANGUAGE = "Content-Language";

  /**
   * Constante que representa el header Content-Length.
   */
  public static final String CONTENT_LENGTH = "Content-Length";

  /**
   * Constante que representa el header Content-MD5.
   */
  public static final String CONTENT_MD5 = "Content-MD5";

  /**
   * Constante que representa el header Accept-Charset.
   */
  public static final String ACCEPT_CHARSET = "Accept-Charset";

  /**
   * Constante que representa el header Date.
   */
  public static final String DATE = "Date";

  /**
   * Constante que representa el header Accept-Encoding.
   */
  public static final String ACCEPT_ENCODING = "Accept-Encoding";

  /**
   * Constante que representa el header ChannelId.
   */
  public static final String CHANNEL_ID = "channel_id";

  /**
   * Constante utilizada para mostrar un mensaje acerca de una petición mal
   * formada.
   */
  public static final String BAD_REQUEST = "Bad Request";

  /**
   * Constante utilizada para mostrar un mensaje acerca de una petición no
   * autorizada.
   */
  public static final String UNAUTHORIZED = "Unauthorized";

  /**
   * Constante utilizada para mostrar un mensaje acerca de recurso que no pudo ser
   * encontrado.
   */
  public static final String RESOURCE_NOT_FOUND = "Resource not found";

  /**
   * Constante utilizada para mostrar un mensaje acerca de un Internal server
   * error.
   */
  public static final String INTERNAL_ERROR = "Internal server error";

  /**
   * Constante utilizada para mostrar el status code 200.
   */
  public static final int CODE_OK = 200;
  /**
   * Constante utilizada para mostrar el status code 400.
   */
  public static final int CODE_BAD_REQUEST = 400;
  /**
   * Constante utilizada para mostrar el status code 401.
   */
  public static final int CODE_UNAUTHORIZED = 401;
  /**
   * Constante utilizada para mostrar el status code 403.
   */
  public static final int CODE_ACCESS_NOT_CONFIGURED = 403;
  /**
   * Constante utilizada para mostrar el status code 404.
   */
  public static final int CODE_RESOURCE_NOT_FOUND = 404;
  /**
   * Constante utilizada para mostrar el status code 406.
   */
  public static final int CODE_NOT_ACCEPTABLE = 406;
  /**
   * Constante utilizada para mostrar el status code 408.
   */
  public static final int CODE_REQUEST_TIMEOUT = 408;
  /**
   * Constante utilizada para mostrar el status code 412.
   */
  public static final int CODE_PRECONDITION_FAILED = 412;
  /**
   * Constante utilizada para mostrar el status code 413.
   */
  public static final int CODE_PAYLOAD_TOO_LARGE = 413;
  /**
   * Constante utilizada para mostrar el status code 422.
   */
  public static final int CODE_BUSINESS_VALIDATION_FAILED = 422;
  /**
   * Constante utilizada para mostrar el status code 500.
   */
  public static final int CODE_INTERNAL_ERROR = 500;
  /**
   * Constante utilizada para mostrar el status code 502.
   */
  public static final int CODE_BAD_GATEWAY = 502;
  /**
   * Constante que representa el status HTTP por default.
   */
  public static final int DEFAULT_STATUS_HTTP = 0;

  public static final String TIEMPO_SUBIR_IMAGEN = "tiempoSubirImagen";

}
