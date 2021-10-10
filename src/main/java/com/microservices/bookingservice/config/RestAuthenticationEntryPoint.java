package com.microservices.bookingservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.bookingservice.exception.DetailsNotFoundResponse;
import com.microservices.bookingservice.exception.InvalidUserAndPasswordException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class RestAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void commence(final HttpServletRequest request,
                         final HttpServletResponse response,
                         final AuthenticationException authException) throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        DetailsNotFoundResponse cnf = new DetailsNotFoundResponse();
        cnf.setResponseCode(InvalidUserAndPasswordException.ERROR_CODE_AND_DESCRIPTION);
        cnf.setResponseDesc(InvalidUserAndPasswordException.Message);
        PrintWriter out = response.getWriter();
        out.print(jsonMapper.writeValueAsString(cnf));

    }

}