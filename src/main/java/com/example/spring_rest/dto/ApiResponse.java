package com.example.spring_rest.dto;

import com.example.spring_rest.Interfaces.ApiResponses;

public class ApiResponse implements ApiResponses {
    private final Boolean success = false;
    private final int statusCode;
    private final String message;

    public ApiResponse(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public Boolean isSuccess() { return success; }
    public int getStatusCode() { return statusCode; }
    public String getMessage() { return message; }
}
