package com.shamsulsaleh.bayarcash.dto;

import lombok.Data;

@Data
public class BankResponse {
    private String bankDisplayName;
    private String bankName;
    private String bankCode;
    private String bankCodeHashed;
    private boolean bankAvailability;

}
