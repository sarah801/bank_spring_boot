package com.example.demo.controllers;


import com.example.demo.dto.TransactionDto;
import com.example.demo.model.Transaction;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    TransactionService transactionService;
    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @PostMapping("/transfer")
    public ResponseEntity<Transaction> transfer(@RequestBody TransactionDto transactionDto) {
      Transaction transaction = transactionService.transfer(transactionDto);
      return ResponseEntity.ok(transaction);
    }
    @PostMapping("/deposit")
    public ResponseEntity<Transaction> Deposit(@RequestBody TransactionDto transactionDto) {
        Transaction transaction = transactionService.deposit(transactionDto);
        return ResponseEntity.ok(transaction);
    }
    @PostMapping("/withdraw")
    public ResponseEntity<Transaction> withdraw(@RequestBody TransactionDto transactionDto) {
        Transaction transaction = transactionService.withdraw(transactionDto);
        return ResponseEntity.ok(transaction);
    }
    @GetMapping("{accountId}")
    public ResponseEntity<List<Transaction>> getAllTransactionsForAccount(@PathVariable Long accountId) {

      List<Transaction> transactions = transactionService.getAllTransactionsForAccount(accountId);
      return ResponseEntity.ok(transactions) ;
    }
    @GetMapping("/date-range")
    public ResponseEntity<List<Transaction>> getTransactionsByDateRange(
            @RequestParam String startdate,
            @RequestParam String endDate) {
        try {
            List<Transaction> transactions = transactionService.getTransactionsByDateRange(startdate, endDate);
            return ResponseEntity.ok(transactions);
        } catch (ParseException e) {
            // Handle the exception and return a bad request response
            return ResponseEntity.badRequest().body(null); // You can also return an error message if needed
        }
    }

}
