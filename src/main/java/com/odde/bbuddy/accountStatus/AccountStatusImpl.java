package com.odde.bbuddy.accountStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountStatusImpl {


    private AccountStatusRepo accountStatusRepo;

    @Autowired
    public AccountStatusImpl(AccountStatusRepo accountStatusRepo){
        this.accountStatusRepo=accountStatusRepo;
    }

    public Map<String, Object> getAccountStatus(){

        Map<String,Object> map = new HashMap<>();

        Iterable<AccountStatus> iterable  = accountStatusRepo.findAll();
        int income = getAccountIncome(iterable.iterator());
        int outcome = getAccountOutcome(iterable.iterator());

        map.put("list",iterable);
        map.put("income",income);
        map.put("outcome",outcome);

        return map;
    }

    public int getAccountIncome(Iterator<AccountStatus> iterator){
        int income = 0;
        while (iterator.hasNext()){
            AccountStatus accountStatus = iterator.next();
            if ("income".equals(accountStatus.getAmount_type())){
                income = income + Integer.valueOf(accountStatus.getAmount());
            }
        }
        return income;
    }

    public int getAccountOutcome(Iterator<AccountStatus> iterator){
        int outcome = 0;
        while (iterator.hasNext()){
            AccountStatus accountStatus = iterator.next();
            if ("outcome".equals(accountStatus.getAmount_type())){
                outcome = outcome + Integer.valueOf(accountStatus.getAmount());
            }
        }
        return outcome;
    }

    public void saveAccountStatus(AccountStatus accountStatus){
        accountStatusRepo.save(accountStatus);
    }

}

