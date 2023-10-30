package com.example.transactionservice.services;

import com.example.transactionservice.model.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("client-wallet-service")
public interface ClientsService {
    @GetMapping("client/")
    Client getAll();
    @GetMapping("client/{clientId}")
    Client getById(@PathVariable Long clientId);
}
