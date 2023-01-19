package com.servicio.ntt.exception.custom;

public class NoDataFoundException extends RuntimeException{
    
    private static final long serialVersionUID = 4018672705379902791L;

	public NoDataFoundException() {
		super();
	}

	public NoDataFoundException(String message) {
		super(message);
	}
}
