package com.odde.bbuddy.accountStatus;

import com.odde.bbuddy.accountStatus.controller.AccountStatusController;
import org.junit.Test;
import org.springframework.ui.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class AccountStatusImplTest {



    @Test
    public void accountStatus_exist_income(){
        // given iterator
        // when calculate
        // assert result
        ArrayList<AccountStatus> list = new ArrayList<AccountStatus>();
        AccountStatus accountStatus1= new AccountStatus();
        accountStatus1.setAmount_type("income");
        accountStatus1.setAmount("10");
        list.add(accountStatus1);

        AccountStatusRepo repo = mock(AccountStatusRepo.class);
        AccountStatusImpl accountStatusService = new AccountStatusImpl(repo);
        assertEquals(10,accountStatusService.getAccountIncome(list.iterator()));

    }


}
