package com.Emp.management.dto;

public class ApiDto {

    private String message;

    public ApiDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
