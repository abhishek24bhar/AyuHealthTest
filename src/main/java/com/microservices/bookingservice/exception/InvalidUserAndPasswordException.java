package com.microservices.bookingservice.exception;

import org.springframework.http.HttpStatus;

public class InvalidUserAndPasswordException extends RuntimeException {
    public static final HttpStatus HTTP_STATUS = HttpStatus.UNAUTHORIZED;
    public static final String ERROR_CODE_AND_DESCRIPTION = "401";
    public static final String Message = "Invalid Username or Password";

}
