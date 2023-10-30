package com.example.transactionservice.services;

import com.example.transactionservice.model.Client;
import com.example.transactionservice.model.Wallet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("client-wallet-service")
public interface ClientsWalletService {
    @GetMapping("client/")
    Client getAll();
    @GetMapping("client/{clientId}")
    Client getclientById(@PathVariable Long clientId);
    @GetMapping("wallet/")
    Wallet getAllwallet();
    @GetMapping("wallet/{walletId}")
    Wallet getwalletById(@PathVariable("walletId") Long walletId);
}
