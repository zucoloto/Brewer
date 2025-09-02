package br.com.zuco.model.service.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {

}
