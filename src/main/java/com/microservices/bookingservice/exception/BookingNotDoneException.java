package com.microservices.bookingservice.exception;/* 
Abhishek Bhargava created on 10/9/2021  
*/

import com.microservices.bookingservice.enums.ErrorCodeAndDescription;
import org.springframework.http.HttpStatus;

public class BookingNotDoneException extends RuntimeException {

        public static final HttpStatus HTTP_STATUS = HttpStatus.OK;

        public static final ErrorCodeAndDescription ERROR_CODE_AND_DESCRIPTION = ErrorCodeAndDescription.code_1006;

    public BookingNotDoneException(String message) {
        super(message);
    }

    public BookingNotDoneException() {

    }
    }

