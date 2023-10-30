package com.example.transactionservice.entities;

import com.example.transactionservice.enums.Status;
import com.example.transactionservice.model.Wallet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Long sourceWalletId;
    private Long destinationWalletId;
    @Transient
    private Wallet sWallet;
    @Transient
    private Wallet dWallet;
    private Double montant;
    private Status status;
}
