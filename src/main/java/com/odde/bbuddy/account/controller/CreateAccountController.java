package com.odde.bbuddy.account.controller;

import com.odde.bbuddy.account.AccountService;
import com.odde.bbuddy.account.domain.Account;

/**
 * Created by taixiaomei on 7/27/16.
 */
public class CreateAccountController {
    private AccountService service;

    public CreateAccountController(AccountService service) {
        this.service = service;
    }

    public void createAccount(Account account) {
        service.saveAccount(account);
    }
}
