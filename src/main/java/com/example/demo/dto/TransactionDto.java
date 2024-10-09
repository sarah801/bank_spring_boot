package com.example.demo.dto;


import com.example.demo.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
    private  String transactionType ;
    private  double amount ;
    private long  sourceAccountId ;
    private long  targetAccountId ;
}
