package vn.spring.rest.rest_basic_crud.global_exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExcep {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> checkAllLoi(Exception ex){
        ErrorResponse err = new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(err);
    }
}
