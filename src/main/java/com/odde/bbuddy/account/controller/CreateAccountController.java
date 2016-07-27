package com.odde.bbuddy.account.controller;

import com.odde.bbuddy.account.AccountService;
import com.odde.bbuddy.account.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by taixiaomei on 7/27/16.
 */
@Controller
@RequestMapping(value = "/accounts")
public class CreateAccountController {

    private AccountService service;

    @Autowired
    public CreateAccountController(AccountService service) {
        this.service = service;
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String createAccount(@ModelAttribute Account account) {
        service.saveAccount(account);
        return "create_account";
    }
}
