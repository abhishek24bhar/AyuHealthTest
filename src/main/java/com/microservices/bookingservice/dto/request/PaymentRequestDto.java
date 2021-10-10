package com.microservices.bookingservice.dto.request;/* 
Abhishek Bhargava created on 10/9/2021  
*/

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class PaymentRequestDto implements Serializable {
    private long bookingId;
    private String transactionId;
    private String amount;
    private String currency;
    private String providerName;
    private String responseType;

    private Map<String,String> optionalParams;


    public String toStringLogger() {
        String detail1= "PaymentRequest{" +
                "bookingId='" + bookingId  +
                ", transactionId='" + transactionId +
                ", amount='" + amount +
                ", currency='" + currency +
                ", providerName='" + providerName +
                ", optionalParams=" + optionalParams +
                '}';

        return detail1;
    }
}
