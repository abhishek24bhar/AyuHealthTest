package com.microservices.bookingservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaymentResponse extends FaultResponse {

        /**
         * From CIS service responsecode, responsemessage and receipt coming in small cases
         */
    public PaymentResponse(){

        }


        private String id;

        private String responsecode;
        private String responsemessage;
        @JsonProperty("receipt")
        private String receiptid;



    public PaymentResponse(String id, String responsecode, String responsemessage, String receiptid) {
            this.id=id;
            this.responsecode=responsecode;
            this.responsemessage=responsemessage;
            this.receiptid=receiptid;
        }


        public String toStringLogger() {
            return "PaymentResponse{" +
                    "id='" + id + '\'' +
                    ", responsecode='" + responsecode + '\'' +
                    ", responsemessage='" + responsemessage + '\'' +
                    ", receiptid='" + receiptid + '\'' +
                    ", errorCode='" + getErrorCode() + '\'' +
                    ", errorMessage='" + getErrorMessage() + '\'' +
                    ", providerErrorCode='" + getProviderErrorCode() + '\'' +
                    ", providerErrorMessage='" + getProviderErrorMessage() + '\'' +
                    ", exception='" + getExceptionClass() + '\'' +
                    ", exceptionMessage='" + getExceptionMessage() + '\'' +
                    "} " ;
        }
}
