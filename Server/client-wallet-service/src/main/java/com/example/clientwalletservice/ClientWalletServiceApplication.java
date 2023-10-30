package com.example.clientwalletservice;

import com.example.clientwalletservice.entities.Client;
import com.example.clientwalletservice.entities.Wallet;
import com.example.clientwalletservice.repository.ClientRepo;
import com.example.clientwalletservice.repository.WalletRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Date;

@SpringBootApplication
@EnableDiscoveryClient
@RequiredArgsConstructor
public class ClientWalletServiceApplication implements CommandLineRunner {
    private final ClientRepo clientRepo;
    private final WalletRepo walletRepo;

    public static void main(String[] args) {
        SpringApplication.run(ClientWalletServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for(int i=0;i<5;i++){
            Wallet wallet = new Wallet(null,200.00,new Date(),"DH");
            Client client = new Client(null,"Ahmed"+i,"Ahmed"+i+"@enset.com",walletRepo.save(wallet));
            clientRepo.save(client);
        }
    }
}
