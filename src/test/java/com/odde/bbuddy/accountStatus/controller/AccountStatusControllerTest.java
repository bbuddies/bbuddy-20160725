package com.odde.bbuddy.accountStatus.controller;

import com.odde.bbuddy.accountStatus.AccountStatus;
import com.odde.bbuddy.accountStatus.AccountStatusImpl;
import com.odde.bbuddy.budget.BudgetCategoryImpl;
import com.odde.bbuddy.budget.MonthlyBudget;
import com.odde.bbuddy.budget.MonthlyBudgetPlanner;
import com.odde.bbuddy.budget.MonthlyBudgetRepo;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class AccountStatusControllerTest {



    @Test
    public void print_date_fail_msg(){
        // arrage
        AccountStatusImpl service = mock(AccountStatusImpl.class);
        Model model = mock(Model.class);
        AccountStatusController accountStatusController = new AccountStatusController(service);

        //action
        accountStatusController.saveAccountStatus("2016-08-01","asdf","asfas","asfsd",model);

        //assert
        verify(model).addAttribute("msg","Date must be no later than today!");

    }



}
