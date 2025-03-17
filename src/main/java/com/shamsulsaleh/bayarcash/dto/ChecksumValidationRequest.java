package com.shamsulsaleh.bayarcash.dto;
import lombok.Data;

@Data
public class ChecksumValidationRequest {
    private String data;             // Data to validate (e.g., transaction details)
    private String checksum;         // Checksum value to validate against
    // Add other fields as needed based on the API specification
}