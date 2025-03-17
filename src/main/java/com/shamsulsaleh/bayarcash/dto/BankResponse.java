package com.shamsulsaleh.bayarcash.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BankResponse {

    @JsonProperty("bank_display_name")
    private String bankDisplayName;

    @JsonProperty("bank_name")
    private String bankName;

    @JsonProperty("bank_code")
    private String bankCode;

    @JsonProperty("bank_code_hashed")
    private String bankCodeHashed;

    @JsonProperty("bank_availability")
    private boolean bankAvailability;

}
