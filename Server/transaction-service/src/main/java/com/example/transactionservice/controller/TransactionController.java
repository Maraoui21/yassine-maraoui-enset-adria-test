package com.example.transactionservice.controller;
import com.example.transactionservice.entities.Transaction;
import com.example.transactionservice.model.Wallet;
import com.example.transactionservice.repository.TransactionRepo;
import com.example.transactionservice.services.ClientsWalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionRepo transactionRepo;
    private final ClientsWalletService walletService;

    @GetMapping("/")
    public ResponseEntity<List<Transaction>> getAll() {
        List<Transaction> transactions = transactionRepo.findAll();
        transactions.forEach(t -> {
            Wallet sWallet = walletService.getwalletById(t.getSourceWalletId());
            Wallet dWallet = walletService.getwalletById(t.getDestinationWalletId());
            t.setDWallet(dWallet);
            t.setSWallet(sWallet);
        });
        return ResponseEntity.ok(transactions);
    }

    @PostMapping("/")
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {
        return ResponseEntity.ok(transactionRepo.save(transaction));
    }
}
