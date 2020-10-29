package com.lordgasmic.bff.configuration.errorhandling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class LordgasmicExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Exception> catchAll(Exception exception) {
        log.error("LGC-: There was a general error", exception);
        return ResponseEntity.status(220)
                .body(exception);
    }
}
