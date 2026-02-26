package com.workintech.zoo.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ZooGlobalExceptionHandler {

    @ExceptionHandler(ZooException.class)
    public ResponseEntity<ZooErrorResponse> handleZooException(ZooException ex) {
        HttpStatus status = ex.getHttpStatus() != null ? ex.getHttpStatus() : HttpStatus.BAD_REQUEST;
        ZooErrorResponse errorResponse = new ZooErrorResponse(
                status.value(),
                ex.getMessage(),
                System.currentTimeMillis()
        );
        log.error("ZooException caught", ex);
        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ZooErrorResponse> handleGenericException(Exception ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ZooErrorResponse errorResponse = new ZooErrorResponse(
                status.value(),
                ex.getMessage(),
                System.currentTimeMillis()
        );
        log.error("Generic exception caught", ex);
        return new ResponseEntity<>(errorResponse, status);
    }
}

