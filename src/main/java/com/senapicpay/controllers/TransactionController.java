package com.senapicpay.controllers;

import com.senapicpay.domain.transaction.Transaction;
import com.senapicpay.dtos.TransactionDTO;
import com.senapicpay.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transactionDTO) {
        try {
            Transaction newTransaction = transactionService.createTransaction(transactionDTO);
            return new ResponseEntity<>(newTransaction, HttpStatus.CREATED); // Usar CREATED para uma criação bem-sucedida
        } catch (Exception e) {
            // Aqui você pode tratar diferentes tipos de exceção de maneira mais específica
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // BAD_REQUEST para simplificar, ajuste conforme necessário
        }
    }
}
