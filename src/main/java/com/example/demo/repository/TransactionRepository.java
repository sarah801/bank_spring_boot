package com.example.demo.repository;

import com.example.demo.model.Account;
import com.example.demo.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Transaction findBysourceAccount(Account sourceAccount);
    Transaction findBytargetAccount (Account targetAccount );
    List<Transaction> findAllBySourceAccountIOrTransactionId(long id) ;
    List<Transaction> findByDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
