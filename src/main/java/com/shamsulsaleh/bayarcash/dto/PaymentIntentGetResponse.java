package com.shamsulsaleh.bayarcash.dto;
import lombok.Data;
import java.util.List;

@Data
public class PaymentIntentGetResponse {

    private String type;                     // Type of the response (e.g., "payment_intent")
    private String id;                       // Unique ID of the payment intent (e.g., "pi_PGPP2G")
    private String status;                   // Status of the payment intent (e.g., "paid")
    private String lastAttempt;              // Timestamp of the last attempt (e.g., "2024-12-30 12:07:57")
    private String paidAt;                   // Timestamp when the payment was made (e.g., "2024-12-30 12:07:57")
    private String orderNumber;              // Order number associated with the payment (e.g., "ORD001")
    private String amount;                   // Amount of the payment (e.g., "10.50")
    private String currency;                 // Currency code (e.g., "MYR")
    private String payerName;                // Name of the payer (e.g., "Mohd Ali")
    private String payerEmail;               // Email of the payer (e.g., "mohd.ali@gmail.com")
    private String payerTelephoneNumber;     // Telephone number of the payer (e.g., "+60169166656")
    private List<Attempt> attempts;          // List of payment attempts

    @Data
    public static class Attempt {
        private String transactionId;               // Unique ID of the transaction (e.g., "trx_YdoXvn")
        private String createdAt;                   // Timestamp when the transaction was created (e.g., "2024-12-30 12:07:57")
        private String payerName;                   // Name of the payer (e.g., "Mohd Ali")
        private String payerEmail;                  // Email of the payer (e.g., "mohd.ali@gmail.com")
        private String payerTelephoneNumber;        // Telephone number of the payer (e.g., "+60169166656")
        private String orderNumber;                // Order number associated with the transaction (e.g., "ORD001")
        private String currency;                   // Currency code (e.g., "MYR")
        private String amount;                     // Amount of the transaction (e.g., "10.50")
        private String exchangeReferenceNumber;    // Exchange reference number (e.g., "1-735-272-902-315691")
        private String exchangeTransactionId;      // Exchange transaction ID (e.g., "2412271215020084")
        private String payerBankName;              // Name of the payer's bank (e.g., "SBI Bank A")
        private int status;                        // Status code of the transaction (e.g., 3)
        private String statusDescription;          // Description of the status (e.g., "Approved")
        private PaymentGateway paymentGateway;     // Payment gateway details

        @Data
        public static class PaymentGateway {
            private int id;                        // ID of the payment gateway (e.g., 1)
            private String name;                   // Name of the payment gateway (e.g., "FPX")
            private String code;                  // Code of the payment gateway (e.g., "FPX")
        }
    }
}