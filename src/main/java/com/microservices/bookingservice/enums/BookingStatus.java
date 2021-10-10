package com.microservices.bookingservice.enums;/* ehbabah created on 10/1/2021  */

public enum BookingStatus {
    CANCELLED(0),
    CONFIRMED(1),
    REQUESTED(2),
    PENDING(3),
    CHECKEDIN(4);


    private BookingStatus(int bookstatus){

    }
}
