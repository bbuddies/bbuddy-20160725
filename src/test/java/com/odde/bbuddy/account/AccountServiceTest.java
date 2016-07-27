package com.odde.bbuddy.account;

import com.odde.bbuddy.account.domain.Account;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by taixiaomei on 7/27/16.
 */
public class AccountServiceTest {

    @Test
    public void create_account_to_db(){
        AccountRepo accountRepo = mock(AccountRepo.class);
        AccountService accountService = new AccountService(accountRepo);
        Account account = new Account("default_account",1000);

        accountService.saveAccount(account);

        verify(accountRepo).save(account);
    }


}
