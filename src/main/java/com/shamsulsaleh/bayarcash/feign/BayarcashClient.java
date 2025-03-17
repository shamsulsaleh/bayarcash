package com.shamsulsaleh.bayarcash.feign;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.shamsulsaleh.bayarcash.dto.BankResponse;
import com.shamsulsaleh.bayarcash.dto.CallbackRequest;
import com.shamsulsaleh.bayarcash.dto.PaymentIntentGetResponse;
import com.shamsulsaleh.bayarcash.dto.PaymentIntentPostRequest;
import com.shamsulsaleh.bayarcash.dto.PaymentIntentPostResponse;
import com.shamsulsaleh.bayarcash.dto.TransactionResponse;

@FeignClient(name = "bayarcashClient", url = "${app.bayarcash.base-url}")
public interface BayarcashClient {

    @PostMapping("/payment-intents")
    PaymentIntentPostResponse createPaymentIntent(
        @RequestHeader("Authorization") String personalAccessToken,
        @RequestBody PaymentIntentPostRequest request
    );

    @GetMapping("/payment-intents/{paymentIntentId}")
    PaymentIntentGetResponse getPaymentIntent(
        @RequestHeader("Authorization") String personalAccessToken,
        @PathVariable String paymentIntentId
    );

    @PostMapping("/transaction/callback")
    void handleCallback(
        @RequestHeader("Authorization") String personalAccessToken,
        @RequestBody CallbackRequest request
    );

    @GetMapping("/transactions/{transactionId}")
    TransactionResponse getTransaction(
        @RequestHeader("Authorization") String personalAccessToken,
        @PathVariable String transactionId
    );

    @GetMapping("/banks")
    List<BankResponse> getBanks(
        @RequestHeader("Authorization") String personalAccessToken
    );
    
    @GetMapping("/duitnow/dobw/banks")
    List<BankResponse> getDuitnowBanks(
        @RequestHeader("Authorization") String personalAccessToken
    );
}