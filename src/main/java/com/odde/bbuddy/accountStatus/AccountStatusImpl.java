package com.odde.bbuddy.accountStatus;

import ca.digitalcave.moss.common.DateUtil;
import com.odde.bbuddy.budget.BudgetCategoryType;
import com.odde.bbuddy.budget.BudgetCategoryTypeMonthly;
import com.odde.bbuddy.budget.DataModelProblemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;

@Service
public class AccountStatusImpl {


    private AccountStatusRepo accountStatusRepo;

    @Autowired
    public AccountStatusImpl(AccountStatusRepo accountStatusRepo){
        this.accountStatusRepo=accountStatusRepo;
    }

    public Iterable<AccountStatus> getAccountStatus(){

        Iterable<AccountStatus> iterable  = accountStatusRepo.findAll();
        return iterable;
    }

    public void saveAccountStatus(AccountStatus accountStatus){
        accountStatusRepo.save(accountStatus);
    }

}

