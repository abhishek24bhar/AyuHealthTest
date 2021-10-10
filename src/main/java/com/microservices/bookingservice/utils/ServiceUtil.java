package com.microservices.bookingservice.utils;

import java.util.UUID;

public class ServiceUtil {
    public static String createUuid() {
        return String.valueOf(UUID.randomUUID()).replace("-", "").substring(0, 16);
    }
}
