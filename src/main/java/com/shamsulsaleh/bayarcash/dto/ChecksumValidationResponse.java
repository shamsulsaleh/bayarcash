package com.shamsulsaleh.bayarcash.dto;
import lombok.Data;

@Data
public class ChecksumValidationResponse {
    private boolean isValid;         // Whether the checksum is valid
    private String message;          // Additional message (e.g., "Checksum is valid")
    // Add other fields as needed based on the API specification
}