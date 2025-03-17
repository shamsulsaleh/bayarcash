package com.shamsulsaleh.bayarcash.dto;
import lombok.Data;

@Data
public class PaymentIntentPostResponse {

    private String type; // only available on v3
    private String id; // only available on v3
    private String payerName;
    private String payerEmail;
    private String payerTelephoneNumber;
    private String orderNumber;
    private String amount;
    private String url;
}