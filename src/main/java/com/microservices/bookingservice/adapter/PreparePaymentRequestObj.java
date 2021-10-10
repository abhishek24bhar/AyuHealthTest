package com.microservices.bookingservice.adapter;/* 
Abhishek Bhargava created on 10/9/2021  
*/

import com.microservices.bookingservice.dto.request.PaymentRequestDto;
import com.microservices.bookingservice.utils.ServiceUtil;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;

import java.math.BigDecimal;

@UtilityClass
@Log4j2
public class PreparePaymentRequestObj {
    public PaymentRequestDto createPaymentRequestAdhoc(long bookingId, String amount, String currency) {
        log.debug("Inside create payment request method");
        PaymentRequestDto requestDto = new PaymentRequestDto();
        requestDto.setBookingId(bookingId);
        requestDto.setTransactionId(ServiceUtil.createUuid());
        requestDto.setAmount(amount);
        requestDto.setCurrency(currency);
        log.debug("Inside create payment request method. RequestDto : " + requestDto);
        //Card details can be added here
        requestDto.setProviderName("Google Pay");
        return requestDto;
    }
}
