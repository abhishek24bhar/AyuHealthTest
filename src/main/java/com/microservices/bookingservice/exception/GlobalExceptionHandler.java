package com.microservices.bookingservice.exception;

import com.microservices.bookingservice.dto.response.CommonResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Log4j2
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = BookingNotDoneException.class)
    public ResponseEntity<Object> exception(BookingNotDoneException exception) {
        log.error("[Response] : Booking Not Done Exception: {}.", exception.getMessage());
        CommonResponse cnf = new CommonResponse();
        cnf.setResponseCode(BookingNotDoneException.ERROR_CODE_AND_DESCRIPTION.getCode());
        cnf.setResponseDesc(BookingNotDoneException.ERROR_CODE_AND_DESCRIPTION.getDescription());
        return new ResponseEntity<>(cnf, BookingNotDoneException.HTTP_STATUS);
    }
    
}
