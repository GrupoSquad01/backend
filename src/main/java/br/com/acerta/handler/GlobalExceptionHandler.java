package br.com.acerta.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.acerta.service.EntityException;
import br.com.acerta.service.ServiceException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ServiceException.class)
    public ResponseEntity<String> handleServiceException(ServiceException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
	
	@ExceptionHandler(EntityException.class)
    public ResponseEntity<String> handleEntityException(EntityException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ex.getMessage());
    }
	
}
