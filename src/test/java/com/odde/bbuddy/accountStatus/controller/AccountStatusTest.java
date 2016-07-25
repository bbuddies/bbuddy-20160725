package com.odde.bbuddy.accountStatus.controller;

import com.odde.bbuddy.accountStatus.AccountStatus;
import com.odde.bbuddy.accountStatus.AccountStatusImpl;
import com.odde.bbuddy.budget.BudgetCategoryImpl;
import com.odde.bbuddy.budget.MonthlyBudget;
import com.odde.bbuddy.budget.MonthlyBudgetPlanner;
import com.odde.bbuddy.budget.MonthlyBudgetRepo;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class AccountStatusTest {

    AccountStatusImpl service=mock(AccountStatusImpl.class);
    Model model = mock(Model.class);
    AccountStatusController controller = new AccountStatusController(service);

    @Test
    public void save_account_status_assert(){
        AccountStatus accountStatus = new AccountStatus();
        accountStatus.setAmount("12.43");
        accountStatus.setAmount_type("1");
        accountStatus.setDate("2018-01-01");
        accountStatus.setRemark("122314");

        assertEquals("save_accountStatus",controller.saveAccountStatus(accountStatus.getDate(),accountStatus.getRemark(),accountStatus.getAmount(),accountStatus.getAmount_type(),model));

        accountStatus.setDate("2011-01-01");
        controller.saveAccountStatus(accountStatus.getDate(),accountStatus.getRemark(),accountStatus.getAmount(),accountStatus.getAmount_type(),model);
        verify(service).saveAccountStatus(accountStatus);
    }


}
