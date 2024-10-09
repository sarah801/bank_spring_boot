package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private long accountNumber;
    private double balance;
    private String accountType;
    private Long userId; // Assuming the User class has a Long ID

}
