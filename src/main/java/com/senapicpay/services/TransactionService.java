package com.senapicpay.services;

import com.senapicpay.domain.transaction.Transaction;
import com.senapicpay.domain.user.User;
import com.senapicpay.dtos.TransactionDTO;
import com.senapicpay.ropositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionService {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public void createTransaction(TransactionDTO transaction) throws Exception {
        User sender = userService.findUserById(transaction.getSenderId());
        User receiver = userService.findUserById(transaction.getReceiverId());

        userService.validateTransaction(sender, transaction.Value());

        if (!authorizeTransaction(sender, transaction.Value())) {
            throw new Exception("Transação não autorizada");
        }

        BigDecimal transactionValue = transaction.Value();

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transactionValue);
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setTimestamp(LocalDateTime.now());

        BigDecimal senderNewBalance = sender.getBalance().subtract(transactionValue);
        BigDecimal receiverNewBalance = receiver.getBalance().add(transactionValue);

        sender.setBalance(senderNewBalance);
        receiver.setBalance(receiverNewBalance);

        repository.save(newTransaction);
        userService.saveUser(sender);
        userService.saveUser(receiver);
    }

    public boolean authorizeTransaction(User sender, BigDecimal value) {
        ResponseEntity<String> authorizationResponse = restTemplate.getForEntity("https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc", String.class);

        return authorizationResponse.getStatusCode() == HttpStatus.OK && "Autorizado".equalsIgnoreCase(authorizationResponse.getBody());
    }
}
