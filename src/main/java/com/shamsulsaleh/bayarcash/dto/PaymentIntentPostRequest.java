package com.shamsulsaleh.bayarcash.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PaymentIntentPostRequest {

	@JsonProperty("payment_channel")
    private int paymentChannel;             // Payment channel ID (e.g., 5)
	
	@JsonProperty("portal_key")
    private String portalKey;               // Portal key provided by Bayarcash
	
	@JsonProperty("order_number")
    private String orderNumber;             // Unique order number for the payment
	
	@JsonProperty("amount")
    private String amount;                  // Amount of the payment
	
	@JsonProperty("payer_name")
    private String payerName;               // Name of the payer
	
	@JsonProperty("payer_email")
    private String payerEmail;              // Email of the payer
	
	@JsonProperty("payer_telephone_number")
    private String payerTelephoneNumber;      // Telephone number of the payer
	
	@JsonProperty("payer_bank_code")
    private String payerBankCode;           // Bank code of the payer's bank
	
	@JsonProperty("payer_bank_name")
    private String payerBankName;           // Name of the payer's bank
	
	@JsonProperty("metadata")
    private String metadata;                // Additional metadata (optional)
	
	@JsonProperty("return_url")
    private String returnUrl;               // URL to redirect after payment completion
	
	@JsonProperty("callback_url")
	private String callbackUrl;
	 
    @JsonProperty("platform_id")
	private String platformId;              // Platform ID (optional)
	
    @JsonProperty("checksum")
    private String checksum;                // Checksum for request validation

}