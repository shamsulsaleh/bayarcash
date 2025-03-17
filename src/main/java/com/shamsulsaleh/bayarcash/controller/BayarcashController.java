package com.shamsulsaleh.bayarcash.controller;

import com.shamsulsaleh.bayarcash.dto.BankResponse;
import com.shamsulsaleh.bayarcash.dto.CallbackRequest;
import com.shamsulsaleh.bayarcash.dto.PaymentIntentGetResponse;
import com.shamsulsaleh.bayarcash.dto.PaymentIntentPostRequest;
import com.shamsulsaleh.bayarcash.dto.PaymentIntentPostResponse;
import com.shamsulsaleh.bayarcash.dto.TransactionResponse;
import com.shamsulsaleh.bayarcash.service.BayarcashService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class BayarcashController {

    private final BayarcashService bayarcashService;

    @Autowired
    public BayarcashController(BayarcashService bayarcashService) {
        this.bayarcashService = bayarcashService;
    }

    @PostMapping("/payment-intent")
    public PaymentIntentPostResponse createPaymentIntent(@RequestBody PaymentIntentPostRequest request) {
        return bayarcashService.createPaymentIntent(request);
    }

    @GetMapping("/payment-intent/{id}")
    public PaymentIntentGetResponse getPaymentIntent(@PathVariable("id") String paymentIntentId) {
        return bayarcashService.getPaymentIntent(paymentIntentId);
    }

    @PostMapping("/callback")
    public void handleCallback(@RequestBody CallbackRequest request) {
        bayarcashService.handleCallback(request);
    }

    @GetMapping("/transaction/{id}")
    public TransactionResponse getTransaction(@PathVariable("id") String transactionId) {
        return bayarcashService.getTransaction(transactionId);
    }

    @GetMapping("/banks")
    public List<BankResponse> getBanks() {
        return bayarcashService.getBanks();
    }

    @GetMapping("/duitnow-banks")
    public List<BankResponse> getDuitnowBanks() {
        return bayarcashService.getDuitnowBanks();
    }
}