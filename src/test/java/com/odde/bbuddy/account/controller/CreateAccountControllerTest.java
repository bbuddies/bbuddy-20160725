package com.odde.bbuddy.account.controller;

import com.odde.bbuddy.account.AccountService;
import com.odde.bbuddy.account.domain.Account;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by taixiaomei on 7/27/16.
 */
public class CreateAccountControllerTest {

    @Test
    public void save_account_data_when_create_a_new_account(){
        AccountService service = mock(AccountService.class);
        CreateAccountController controller = new CreateAccountController(service);
        Account account = new Account("default_account",1000);

        controller.createAccount(account);

        verify(service).saveAccount(account);
    }
}
