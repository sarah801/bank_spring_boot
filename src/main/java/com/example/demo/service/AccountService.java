package com.example.demo.service;

import com.example.demo.dto.AccountDto;
import com.example.demo.model.Account;
import com.example.demo.model.User;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AccountService {
    private  final AccountRepository accountRepository;
    private final UserRepository userRepository;


    public AccountService(AccountRepository accountRepository , UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;

    }
 public  Account createAccount(AccountDto accountDto) {
      Optional<User> userOptional = userRepository.findById(accountDto.getUserId());
      if (!userOptional.isPresent()) {
          throw new RuntimeException("User not found with id: " + accountDto.getUserId());
      }

      Account account = new Account();
      account.setAccountNumber(accountDto.getAccountNumber());
      account.setBalance(accountDto.getBalance());
      account.setAccountType(accountDto.getAccountType());
      account.setUser(userOptional.get());


      return accountRepository.save(account);

  }
 public  Account getAccountDetails(Long accountId)
  {
      if(!accountRepository.findById(accountId).isPresent())
      {
          throw new RuntimeException("Account not found with id: " + accountId);
      }
      return accountRepository.findById(accountId).get();

  }
    public Account  updateAccountBalance(Long accountId, Double balance) {
    Account account = getAccountDetails(accountId);
    account.setBalance(accountId);
    accountRepository.save(account);
    return account;

  }

}
