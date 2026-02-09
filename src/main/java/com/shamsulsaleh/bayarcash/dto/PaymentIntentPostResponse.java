package com.shamsulsaleh.bayarcash.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PaymentIntentPostResponse {

    private String type; // only available on v3
    private String id; // only available on v3
    @JsonProperty("payer_name")
    private String payerName;

    @JsonProperty("payer_email")
    private String payerEmail;

    @JsonProperty("payer_telephone_number")
    private String payerTelephoneNumber;

    @JsonProperty("order_number")
    private String orderNumber;

    private String amount;
    private String url;
}