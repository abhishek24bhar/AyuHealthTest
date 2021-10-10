package com.microservices.bookingservice.exception.errors;

import com.microservices.bookingservice.enums.ErrorCodeAndDescription;
import org.springframework.http.HttpStatus;

public class EmailAlreadyUsedException extends RuntimeException {

    public static final HttpStatus HTTP_STATUS = HttpStatus.OK;
    public static final ErrorCodeAndDescription ERROR_CODE_AND_DESCRIPTION = ErrorCodeAndDescription.code_1007;


}
