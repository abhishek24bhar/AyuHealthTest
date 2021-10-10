package com.microservices.bookingservice.service.impl;/* 
Abhishek Bhargava created on 10/9/2021  
*/

import com.microservices.bookingservice.dto.request.PaymentRequestDto;
import com.microservices.bookingservice.dto.response.PaymentResponse;
import com.microservices.bookingservice.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public PaymentResponse doPayment(PaymentRequestDto paymentRequestDto) {
        PaymentResponse response = new PaymentResponse();
        if (paymentRequestDto != null) {

            response
        }
    }
}
