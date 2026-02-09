package com.shamsulsaleh.bayarcash.service;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Service;

import com.shamsulsaleh.bayarcash.dto.BankResponse;
import com.shamsulsaleh.bayarcash.dto.CallbackRequest;
import com.shamsulsaleh.bayarcash.dto.PaymentIntentGetResponse;
import com.shamsulsaleh.bayarcash.dto.PaymentIntentPostRequest;
import com.shamsulsaleh.bayarcash.dto.PaymentIntentPostResponse;
import com.shamsulsaleh.bayarcash.dto.TransactionResponse;
import com.shamsulsaleh.bayarcash.feign.BayarcashClient;

@Service
public class BayarcashService {

    private Logger logger = LoggerFactory.getLogger(BayarcashService.class);

    @Value("${app.bayarcash.personal-access-token}")
    private String personalAccessToken;

    @Value("${app.bayarcash.portal-key}")
    private String portalKey;

    @Value("${app.bayarcash.secret-key}")
    private String secretKey;

    private final BayarcashClient bayarcashClient;

    public BayarcashService(BayarcashClient bayarcashClient) {
        this.bayarcashClient = bayarcashClient;
    }

    public PaymentIntentPostResponse createPaymentIntent(PaymentIntentPostRequest request) {
        request.setPortalKey(portalKey);
        request.setChecksum(generateChecksum(request)); // Implement checksum generation logic
        return bayarcashClient.createPaymentIntent("Bearer " + personalAccessToken, request);
    }

    public PaymentIntentGetResponse getPaymentIntent(String paymentIntentId) {
        return bayarcashClient.getPaymentIntent("Bearer " + personalAccessToken, paymentIntentId);
    }

    public void handleCallback(CallbackRequest request) {
        bayarcashClient.handleCallback("Bearer " + personalAccessToken, request);
    }

    public TransactionResponse getTransaction(String transactionId) {
        return bayarcashClient.getTransaction("Bearer " + personalAccessToken, transactionId);
    }

    public List<BankResponse> getBanks() {
        return bayarcashClient.getBanks("Bearer " + personalAccessToken);
    }

    public List<BankResponse> getDuitnowBanks() {
        return bayarcashClient.getDuitnowBanks("Bearer " + personalAccessToken);
    }

    /**
     * https://api.webimpian.support/bayarcash/checksum/checksum-validation
     * 
     * @param request
     * @return
     */
    private String prepareDataForChecksum(PaymentIntentPostRequest request) {
        // Concatenate fields in a specific order (adjust based on Bayarcash's
        // requirements)
        // add into object (key,value), sort by key and implode with "|"
        Map<String, Object> data = new HashMap<>();
        data.put("payment_channel", request.getPaymentChannel());
        // data.put("portal_key", request.getPortalKey());
        data.put("order_number", request.getOrderNumber());
        data.put("amount", request.getAmount());
        data.put("payer_name", request.getPayerName());
        data.put("payer_email", request.getPayerEmail());
        // data.put("payer_telephone_number", request.getPayerTelephoneNumber());
        // data.put("return_url", request.getReturnUrl());
        // data.put("callback_url", request.getCallbackUrl());

        // Sort the data by key
        Map<String, Object> sortedData = new TreeMap<>(data);

        // Concatenate the sorted data
        StringBuilder concatenatedData = new StringBuilder();
        for (Map.Entry<String, Object> entry : sortedData.entrySet()) {
            // implode value with "|" delimiter
            String val = String.valueOf(entry.getValue());
            concatenatedData.append(val.trim()).append("|");

            // implode key and value with "|" delimiter
            // concatenatedData.append(entry.getKey()).append("|").append(entry.getValue()).append("|");
        }
        // Remove the trailing delimiter
        concatenatedData.deleteCharAt(concatenatedData.length() - 1);
        logger.info("concatenatedData: " + concatenatedData.toString());
        return concatenatedData.toString();

        // return request.getPaymentChannel() + "|" +
        // request.getOrderNumber() + "|" +
        // request.getAmount() + "|" +
        // request.getPayerName() + "|" +
        // request.getPayerEmail();
    }

    /**
     * https://api.webimpian.support/bayarcash/checksum/checksum-validation
     * 
     * @param request
     * @return
     */
    private String generateChecksum(PaymentIntentPostRequest request) {
        String data = prepareDataForChecksum(request);
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");

            // Create a SecretKeySpec from the secret key
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");

            // Initialize the Mac with the secret key
            sha256_HMAC.init(secretKeySpec);

            // Compute the HMAC
            byte[] hmacBytes = sha256_HMAC.doFinal(data.getBytes(StandardCharsets.UTF_8));

            // Convert the HMAC bytes to a hexadecimal string
            return new String(Hex.encode(hmacBytes));
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException("Failed to generate checksum", e);
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate checksum", e);
        }
    }

}