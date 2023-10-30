package com.example.clientwalletservice.controller;

import com.example.clientwalletservice.entities.Client;
import com.example.clientwalletservice.repository.ClientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientRepo clientRepo;
    @GetMapping("/")
    public ResponseEntity<List<Client>> getAll(){
        return ResponseEntity.ok(clientRepo.findAll());
    }
    @PostMapping("/")
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        return ResponseEntity.ok(clientRepo.save(client));
    }
}
