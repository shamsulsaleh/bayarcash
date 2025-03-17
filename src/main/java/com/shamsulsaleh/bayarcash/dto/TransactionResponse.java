package com.shamsulsaleh.bayarcash.dto;
import lombok.Data;

@Data
public class TransactionResponse {
    private String transactionId;    // Unique ID of the transaction
    private String status;           // Status of the transaction (e.g., "success", "failed")
    private Double amount;           // Amount of the transaction
    private String currency;         // Currency code (e.g., "MYR")
    private String createdAt;        // Timestamp when the transaction was created
    private String referenceId;      // Reference ID for the transaction
    // Add other fields as needed based on the API specification
}