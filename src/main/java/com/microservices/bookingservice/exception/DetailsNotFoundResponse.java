package com.microservices.bookingservice.exception;

import lombok.Data;

@Data
public class DetailsNotFoundResponse {
    String responseCode;
    String responseDesc;
}
