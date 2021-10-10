package com.microservices.bookingservice.enums;/* 
Abhishek Bhargava created on 10/9/2021  
*/

import org.springframework.http.HttpStatus;

import java.util.Arrays;

public enum  ErrorCodeAndDescription {
    code_0("0",HttpStatus.OK, "Success"),
    code_1000("1000", HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error"),
    code_1001("1001", HttpStatus.BAD_REQUEST, "Invalid request parameter"),
    code_1002("1002", HttpStatus.BAD_REQUEST, "Mandatory request parameter missing"),
    code_1003("1003", HttpStatus.BAD_REQUEST, "Invalid JSON"),
    code_1004("1004", HttpStatus.UNAUTHORIZED, "Unauthorised Request"),
    code_1005("1005", HttpStatus.NOT_FOUND, "Url Not Found"),
    code_1006("1006",HttpStatus.OK,"Booking Failed"),
    code_1007("1007",HttpStatus.OK,"Email ALready Used "),
    code_1008("1008",HttpStatus.OK,"Login Failed ");
    private String code;
    private HttpStatus httpResponseCode;
    private String description;

    private ErrorCodeAndDescription(String code, HttpStatus httpResponseCode, String description) {
        this.code = code;
        this.httpResponseCode = httpResponseCode;
        this.description = description;
    }

    private ErrorCodeAndDescription(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets http response code.
     *
     * @return the http response code
     */
    public HttpStatus getHttpResponseCode() {
        return httpResponseCode;
    }

    /**
     * Gets enum.
     *
     * @param httpStatus the http status
     * @return the enum
     */
    public static ErrorCodeAndDescription getEnum(HttpStatus httpStatus) {
        return Arrays.stream(values()).filter(
                value -> value.getHttpResponseCode().equals(httpStatus)).findFirst().
                orElse(code_1000);
    }

    /**
     * Gets enum.
     *
     * @param code the response code
     * @return the enum
     */
    public static ErrorCodeAndDescription getEnum(String code) {
        return Arrays.stream(values())
                .filter(value -> value.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Code"));
    }
}
