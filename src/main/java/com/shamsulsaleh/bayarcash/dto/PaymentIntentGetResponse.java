package com.shamsulsaleh.bayarcash.dto;
import lombok.Data;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class PaymentIntentGetResponse {

    @JsonProperty("type")
    private String type;                     // Type of the response (e.g., "payment_intent")
    
    @JsonProperty("id")
    private String id;                       // Unique ID of the payment intent (e.g., "pi_PGPP2G")
    
    @JsonProperty("status")
    private String status;                   // Status of the payment intent (e.g., "paid")
    
    @JsonProperty("last_attempt")
    private String lastAttempt;              // Timestamp of the last attempt (e.g., "2024-12-30 12:07:57")
    
    @JsonProperty("paid_at")
    private String paidAt;                   // Timestamp when the payment was made (e.g., "2024-12-30 12:07:57")
    
    @JsonProperty("order_number")
    private String orderNumber;              // Order number associated with the payment (e.g., "ORD001")
    
    @JsonProperty("amount")
    private String amount;                   // Amount of the payment (e.g., "10.50")
    
    @JsonProperty("currency")
    private String currency;                 // Currency code (e.g., "MYR")
    
    @JsonProperty("payer_name")
    private String payerName;                // Name of the payer (e.g., "Mohd Ali")
    
    @JsonProperty("payer_email")
    private String payerEmail;               // Email of the payer (e.g., "mohd.ali@gmail.com")
    
    @JsonProperty("payer_telephone_number")
    private String payerTelephoneNumber;     // Telephone number of the payer (e.g., "+60169166656")
    
    @JsonProperty("attempts")
    private List<Attempt> attempts;          // List of payment attempts

    @Data
    public static class Attempt {

        @JsonProperty("transaction_id")
        private String transactionId;               // Unique ID of the transaction (e.g., "trx_YdoXvn")
        
        @JsonProperty("created_at")
        private String createdAt;                   // Timestamp when the transaction was created (e.g., "2024-12-30 12:07:57")
        
        @JsonProperty("payer_name")
        private String payerName;                   // Name of the payer (e.g., "Mohd Ali")
        
        @JsonProperty("payer_email")
        private String payerEmail;                  // Email of the payer (e.g., "mohd.ali@gmail.com")
        
        @JsonProperty("payer_telephone_number")
        private String payerTelephoneNumber;        // Telephone number of the payer (e.g., "+60169166656")
        
        @JsonProperty("order_number")
        private String orderNumber;                // Order number associated with the transaction (e.g., "ORD001")
        
        @JsonProperty("currency")   
        private String currency;                   // Currency code (e.g., "MYR")
        
        @JsonProperty("amount")
        private String amount;                     // Amount of the transaction (e.g., "10.50")
        
        @JsonProperty("exchange_reference_number")
        private String exchangeReferenceNumber;    // Exchange reference number (e.g., "1-735-272-902-315691")
        
        @JsonProperty("exchange_transaction_id")
        private String exchangeTransactionId;      // Exchange transaction ID (e.g., "2412271215020084")
        
        @JsonProperty("payer_bank_name")
        private String payerBankName;              // Name of the payer's bank (e.g., "SBI Bank A")
        
        @JsonProperty("status")
        private int status;                        // Status code of the transaction (e.g., 3)
        
        @JsonProperty("status_description")
        private String statusDescription;          // Description of the status (e.g., "Approved")
        
        @JsonProperty("payment_gateway")
        private PaymentGateway paymentGateway;     // Payment gateway details

        @Data
        public static class PaymentGateway {

            @JsonProperty("id")
            private int id;                        // ID of the payment gateway (e.g., 1)
            
            @JsonProperty("name")
            private String name;                   // Name of the payment gateway (e.g., "FPX")
            
            @JsonProperty("code")
            private String code;                  // Code of the payment gateway (e.g., "FPX")
        }
    }
}