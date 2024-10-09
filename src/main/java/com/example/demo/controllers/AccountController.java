package com.example.demo.controllers;

import com.example.demo.dto.AccountDto;
import com.example.demo.model.Account;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

private  final AccountService accountService;
@Autowired
public AccountController(AccountService accountService) {
    this.accountService = accountService;
}
@PostMapping
    public ResponseEntity<Account>  createAccount(@RequestBody AccountDto accountDto) {
  Account account = accountService.createAccount(accountDto) ;
  return ResponseEntity.ok(account) ;
}
@GetMapping("/{id}")
    public ResponseEntity<Account> getAccDetails (@PathVariable long id )
{
    Account updated = accountService.getAccountDetails(id);
    return ResponseEntity.ok(updated) ;

}
@PutMapping("/{id}/balance")
 public ResponseEntity<Account> updateBalance(@PathVariable long id, @RequestBody AccountDto accountDto)
{
    Account updatedbalance = accountService.updateAccountBalance(id , accountDto.getBalance()) ;
    return ResponseEntity.ok(updatedbalance) ;

}



}
