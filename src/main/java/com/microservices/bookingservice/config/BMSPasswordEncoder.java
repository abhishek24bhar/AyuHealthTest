package com.microservices.bookingservice.config;/* 
Abhishek Bhargava created on 10/9/2021  
*/

import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Base64;

public class BMSPasswordEncoder implements PasswordEncoder {
    private static final PasswordEncoder INSTANCE = new BMSPasswordEncoder();

    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.toString().equals(new String(Base64.getDecoder().decode(encodedPassword)));
    }

    public static PasswordEncoder getInstance() {
        return INSTANCE;
    }

    private BMSPasswordEncoder() {
    }
}
