package vn.spring.rest.rest_basic_crud.global_exception;

public class StudentException extends RuntimeException{
    public StudentException(String message) {
        super(message);
    }
}
