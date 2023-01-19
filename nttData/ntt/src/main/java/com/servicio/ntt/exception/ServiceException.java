package com.servicio.ntt.exception;

public class ServiceException extends java.lang.RuntimeException {

    private static final long serialVersionUID = 1L;

    public ServiceException() {
        super();
    }

    public ServiceException(java.lang.String message) {
    }

    public ServiceException(java.lang.Throwable cause) {
    }

    public ServiceException(java.lang.String message, java.lang.String errorCode) {
    }

    public ServiceException(java.lang.String message, java.lang.Throwable cause) {
    }

    public ServiceException(java.lang.String message, org.springframework.http.HttpStatus httpStatus) {
    }

    public ServiceException(java.lang.String message, java.lang.String errorCode,
            org.springframework.http.HttpStatus httpStatus) {
    }

    public ServiceException(java.lang.String message, java.lang.Throwable cause, java.lang.String errorCode) {
    }

    public ServiceException(java.lang.String message, java.lang.Throwable cause,
            org.springframework.http.HttpStatus httpStatus) {
    }

    public ServiceException(java.lang.String message, java.lang.Throwable cause, java.lang.String errorCode,
            org.springframework.http.HttpStatus httpStatus) {
    }

    public java.lang.String toString() {
        return null;
    }

    public void printStackTrace() {
    }

    public void printStackTrace(java.io.PrintStream ps) {
    }

    public void printStackTrace(java.io.PrintWriter pw) {
    }

    public java.lang.Throwable getCause() {
        return null;
    }

    public void setErrorCode(java.lang.String errorCode) {
    }

    public java.lang.String getErrorCode() {
        return null;
    }

    public org.springframework.http.HttpStatus getHttpStatus() {
        return null;
    }

    public void setHttpStatus(org.springframework.http.HttpStatus httpStatus) {
    }
}
