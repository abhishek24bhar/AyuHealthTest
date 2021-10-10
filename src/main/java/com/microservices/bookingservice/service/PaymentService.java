
/*

 */
package com.microservices.bookingservice.service;

import com.microservices.bookingservice.dto.request.PaymentRequestDto;
import com.microservices.bookingservice.dto.response.PaymentResponse;

public interface PaymentService {

    public PaymentResponse doPayment(PaymentRequestDto paymentRequestDto);
}
