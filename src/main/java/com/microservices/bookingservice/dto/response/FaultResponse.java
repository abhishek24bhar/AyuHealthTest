package com.microservices.bookingservice.dto.response;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.security.core.Transient;

@Data
@Transient
public class FaultResponse {
    @JsonIgnore(value = false)
    boolean fault;
    @JsonProperty("error_code")
    String errorCode ;
    @JsonProperty("error_message")
    String errorMessage;
    @JsonProperty("providererrorcode")
    String providerErrorCode;
    @JsonProperty("providererrormessage")
    String providerErrorMessage;

    String exceptionClass;
    String exceptionMessage;

}
