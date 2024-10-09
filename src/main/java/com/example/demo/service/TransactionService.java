package com.example.demo.service;

import com.example.demo.dto.TransactionDto;
import com.example.demo.model.Account;
import com.example.demo.model.Transaction;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TransactionService {
     AccountRepository accountRepository;
     TransactionRepository transactionRepository;


    public Transaction transfer (TransactionDto transactionDto)
    {
         Account sourceAccount =  accountRepository.findByAccountId(transactionDto.getSourceAccountId()) ;
         Account targetAccount =  accountRepository.findByAccountId(transactionDto.getTargetAccountId()) ;
         if(transactionDto.getTransactionType().equals("TRANSFER") && sourceAccount.getBalance() >= transactionDto.getAmount())
         {
             if(sourceAccount.getUser().equals(targetAccount.getUser()))
             {
                  sourceAccount.setBalance(sourceAccount.getBalance() -transactionDto.getAmount());
                  targetAccount.setBalance(targetAccount.getBalance() + transactionDto.getAmount());
                  Transaction transaction = Transaction.builder()
                          .transactionType("TRANSFER")
                          .sourceAccount(sourceAccount)
                          .targetAccount(targetAccount).build();
                  transactionRepository.save(transaction);
                  return transaction ;

             }



         }
         return null ;
    }
public Transaction deposit (TransactionDto transactionDto)
{
     Account targetccount =  accountRepository.findByAccountId(transactionDto.getTargetAccountId()) ;
     targetccount.setBalance(targetccount.getBalance() + transactionDto.getAmount());
     if(transactionDto.getTransactionType().equals("DEPOSIT"))
     {
          Transaction transaction = Transaction.builder()
                  .transactionType("DEPOSIT")
                  .targetAccount(targetccount)
                  .build() ;
         transactionRepository.save(transaction);
         return transaction ;
     }
return null ;

}
public Transaction withdraw (TransactionDto transactionDto)
{
     Account sourceAccount =  accountRepository.findByAccountId(transactionDto.getSourceAccountId()) ;
     sourceAccount.setBalance(sourceAccount.getBalance() -transactionDto.getAmount());
     if (transactionDto.getTransactionType().equals("WITHDRAW") &&  transactionDto.getAmount() >= sourceAccount.getBalance())
     {

          Transaction transaction = Transaction.builder()
                  .transactionType("WITH DRAW ")
                  .sourceAccount(sourceAccount)
                  .build();
          transactionRepository.save(transaction);
          return transaction ;
     }
     return null ;
}
public List<Transaction> getAllTransactionsForAccount(long id )
{
    return transactionRepository.findAllBySourceAccountIOrTransactionId(id) ;
}

    public List<Transaction> getTransactionsByDateRange(String startDate, String endDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Adjust the date format as necessary
        Date start = dateFormat.parse(startDate);
        Date end = dateFormat.parse(endDate);

        return transactionRepository.findByDateRange(start, end);
    }
}
