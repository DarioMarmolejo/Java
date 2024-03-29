package com.servicio.ntt.constant;

public class PersonConstants {
    
    private PersonConstants () {}

    public static final String ERRCODE_CODE_PERSON_NULL = "err.message.code.person.null";

    public static final String ERRCODE_FIRST_NAME_NULL = "err.message.name.null";
    public static final String ERRCODE_SECOND_NAME_NULL = "err.message.second.name.null";

    public static final String ERRCODE_LAST_NAME_NULL = "err.message.lastname.null";

    public static final String ERRCODE_EMAIL_NAME_NULL= "err.message.email.null";

    public static final String ERRCODE_CIVIL_NULL = "err.message.civil.null";

    public static final String ERRCODE_AGEMIN_NULL = "err.message.agemin.null";
    public static final String ERRCODE_AGEMAX_NULL = "err.message.agemax.null";
    
    public static final String ERRCODE_FORMAT_DATE_INVALID = "err.message.format.invalid";
    public static final String ERRCODE_FIELD_NULL = "err.message.field.null";

    public static final String MENSAJE_EMAIL_NO_VALIDO = "validacion.email.invalido";
    public static final String MENSAJE_CAMPO_NULO = "validacion.campo.nulo";

    
    public static final String SORT_ASC = "ASC";
	public static final String SORT_DESC = "DESC";

    public static final String CAMPO_CODIGO_PERSONA	= "codigoPersona";
	public static final String CAMPO_PRIMER_NOMBRE = "primerNombre";
	public static final String CAMPO_SEGUNDO_NOMBRE	= "segundoNombre";
    public static final String CAMPO_PRIMER_APELLIDO = "primerApellido";
	public static final String CAMPO_SEGUNDO_APELLIDO= "segundoApellido";
	public static final String CAMPO_EMAIL 	= "email";
	public static final String CAMPO_ESTATUS = "estatus";
    public static final String CAMPO_TELEFONO_FIJO = "telefonoFijo";
	public static final String CAMPO_TELEFONO_MOVIL = "telefonoMovil";
	public static final String CAMPO_ESTADO_CIVIL = "estadoCivil";
	public static final String CAMPO_FECHA_CREACION = "fechaCreacion";
    public static final String CAMPO_FECHA_ACTUALIZACION = "fechaActualizacion";

    public static final String MESSAGE_CODIGO_PERSONA	= "El campo codigoPersona esta vacio o es invalido";
	public static final String MESSAGE_PRIMER_NOMBRE = "El campo primerNombre esta vacio o es invalido";
	public static final String MESSAGE_SEGUNDO_NOMBRE	= "El campo segundoNombre esta vacio o es invalido";
    public static final String MESSAGE_PRIMER_APELLIDO = "El campo primerApellido esta vacio o es invalido";
	public static final String MESSAGE_SEGUNDO_APELLIDO= "El campo segundoApellido esta vacio o es invalido";
	public static final String MESSAGE_EMAIL 	= "El campo email esta vacio o es invalido";
	public static final String MESSAGE_ESTATUS = "El campo estatus esta vacio o es invalido";
    public static final String MESSAGE_TELEFONO_FIJO = "El campo telefonoFijo esta vacio o es invalido";
	public static final String MESSAGE_TELEFONO_MOVIL = "El campo telefonoMovil esta vacio o es invalido";
	public static final String MESSAGE_ESTADO_CIVIL = "El campo estadoCivil esta vacio o es invalido";
	public static final String MESSAGE_FECHA_CREACION = "El campo fechaCreacion esta vacio o es invalido";
    public static final String MESSAGE_FECHA_ACTUALIZACION = "El campo fechaActualizacion esta vacio o es invalido";

    public static final String PARAMETRO_CODIGO_PERSONA_ERROR	=  "El parametro "+"codigoPersona"+" es invalido";
	public static final String PARAMETRO_PRIMER_NOMBRE_ERROR = "El parametro "+"primerNombre"+" es invalido";
	public static final String PARAMETRO_SEGUNDO_NOMBRE_ERROR	= "El parametro "+"segundoNombre"+" es invalido";
    public static final String PARAMETRO_PRIMER_APELLIDO_ERROR = "El parametro "+"primerApellido"+" es invalido";
	public static final String PARAMETRO_SEGUNDO_APELLIDO_ERROR = "El parametro "+"segundoApellido"+" es invalido";
	public static final String PARAMETRO_EMAIL_ERROR 	= "El parametro "+"email"+" es invalido";
	public static final String PARAMETRO_ESTATUS_ERROR = "El parametro "+"estatus"+" es invalido, utilice soltero,casado,viudo o concubinato";
    public static final String PARAMETRO_TELEFONO_FIJO_ERROR = "El parametro "+"telefonoFijo"+" es invalido";
	public static final String PARAMETRO_TELEFONO_MOVIL_ERROR = "El parametro "+"telefonoMovil"+" es invalido";
	public static final String PARAMETRO_ESTADO_CIVIL_ERROR = "El parametro "+"estadoCivil"+" es invalido";
	public static final String PARAMETRO_FECHA_CREACION_ERROR = "El parametro "+"fechaCreacion"+" es invalido";
    public static final String PARAMETRO_FECHA_ACTUALIZACION_ERROR = "El parametro "+"fechaActualizacion"+" es invalido";

    public static final String PARAMETRO_ORDEN_ERROR = "El parametro "+"orden"+" es invalido";
    public static final String PARAMETRO_COLUMNA_ERROR = "El parametro "+"columna"+" es invalido";

    public static final String VALUE_TRUE = "true";
    public static final String VALUE_FALSE = "false";


	public static final String BAD_REQUEST = "Los datos son incorrectos.";
	public static final String BAD_REQUEST_EXCEPTION = "Ocurrió un error al procesar su solicitud.";
	public static final String BAD_REQUEST_EXCEPTION_VALIDATE = "Faltan datos para procesar su solicitud.";
}
