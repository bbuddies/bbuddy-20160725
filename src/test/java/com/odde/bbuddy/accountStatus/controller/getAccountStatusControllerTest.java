package com.odde.bbuddy.accountStatus.controller;

import com.odde.bbuddy.accountStatus.AccountStatus;
import com.odde.bbuddy.accountStatus.AccountStatusImpl;
import org.junit.Test;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class getAccountStatusControllerTest {
    AccountStatusImpl service = mock(AccountStatusImpl.class);
    Model model = mock(Model.class);
    getAccountStatusController controller = new getAccountStatusController(service);
    @Test
    public void getAccountStatus_use_AccountStatus_view(){
        assertEquals("AccountStatus", controller.getAccountStatus(model));
    }

    @Test
    public void getAccountStatus_display_account_status_from_service() {
        ArrayList<AccountStatus> accountStatusList = new ArrayList<>();
        when(service.getAccountStatus()).thenReturn(accountStatusList);

        controller.getAccountStatus(model);

        verify(model).addAttribute("accountStatusList", accountStatusList);
    }
}
