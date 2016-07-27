package com.odde.bbuddy.account;

import com.odde.bbuddy.account.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by taixiaomei on 7/27/16.
 */
@Service
public class AccountService {
    private AccountRepo accountRepo;

    @Autowired
    public AccountService(AccountRepo accountRepo) {

        this.accountRepo = accountRepo;
    }

    public void saveAccount(Account account) {
        accountRepo.save(account);
    }
}
