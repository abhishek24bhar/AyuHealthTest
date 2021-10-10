package com.microservices.bookingservice.dto.response;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;

@Log4j2
public class CommonResponse {
    private String responseCode;
    private String responseDesc;
    public CommonResponse(String responseCode, String responseDesc) {
        this.responseCode = responseCode;
        this.responseDesc = responseDesc;
        log.info(this.toString());
    }
    public CommonResponse() {

    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDesc() {
        return responseDesc;
    }

    public void setResponseDesc(String responseDesc) {
        this.responseDesc = responseDesc;
    }

    @Override
    public String toString() {
        return "ARCommonResponse{" +
                "responseCode='" + responseCode + '\'' +
                ", responseDesc='" + responseDesc + '\'' +
                '}';
    }
}
