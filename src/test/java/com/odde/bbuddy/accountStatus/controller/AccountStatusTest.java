package com.odde.bbuddy.accountStatus.controller;

import com.odde.bbuddy.accountStatus.AccountStatus;
import com.odde.bbuddy.accountStatus.AccountStatusImpl;
import com.odde.bbuddy.accountStatus.SystemTime;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.ui.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class AccountStatusTest {

    AccountStatusImpl service=mock(AccountStatusImpl.class);
    Model model = mock(Model.class);
    SystemTime systemTime = mock(SystemTime.class);
    AccountStatusController controller = new AccountStatusController(service, systemTime);

    @Test
    public void save_account_status_assert() throws ParseException {
        when(systemTime.getNow()).thenReturn(new SimpleDateFormat("yyyy-MM-dd").parse("2016-05-25"));
        AccountStatus accountStatus = new AccountStatus();
        accountStatus.setAmount("12.43");
        accountStatus.setAmount_type("1");
        accountStatus.setDate("2018-01-01");
        accountStatus.setRemark("122314");

        assertEquals("save_accountStatus",controller.saveAccountStatus(accountStatus.getDate(),accountStatus.getRemark(),accountStatus.getAmount(),accountStatus.getAmount_type(),model));

        accountStatus.setDate("2011-01-01");
        controller.saveAccountStatus(accountStatus.getDate(),accountStatus.getRemark(),accountStatus.getAmount(),accountStatus.getAmount_type(),model);
        ArgumentCaptor<AccountStatus> arguments = ArgumentCaptor.forClass(AccountStatus.class);
        verify(service).saveAccountStatus(arguments.capture());
        assertEquals(accountStatus.getDate(), arguments.getValue().getDate());
    }


}
