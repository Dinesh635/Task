package com.Emp.management.Controllers.ExceptionHandling;

import com.Emp.management.Exceptions.EmployeeErrorDetails;
import com.Emp.management.Exceptions.EmployeeNotFoundException;
import com.Emp.management.Exceptions.EmployeeWrongDetailException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class EmployeeExceptionHanding {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(EmployeeNotFoundException.class)
    public EmployeeErrorDetails handleEmployeeNotFoundException(EmployeeNotFoundException exception)
    {
        EmployeeErrorDetails error=new EmployeeErrorDetails();
        error.setMessage(exception.getMessage());
        return error;
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmployeeWrongDetailException.class)
    public EmployeeErrorDetails handleWrongEmployeeDetailException(EmployeeWrongDetailException exception)
    {
        EmployeeErrorDetails error=new EmployeeErrorDetails();
        error.setMessage(exception.getMessage());
        return error;
    }
}
