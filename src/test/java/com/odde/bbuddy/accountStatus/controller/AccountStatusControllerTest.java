package com.odde.bbuddy.accountStatus.controller;

import com.odde.bbuddy.accountStatus.AccountStatus;
import com.odde.bbuddy.accountStatus.AccountStatusImpl;
import com.odde.bbuddy.accountStatus.SystemTime;
import org.junit.Test;
import org.springframework.ui.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AccountStatusControllerTest {


    AccountStatusImpl service = mock(AccountStatusImpl.class);
    Model model = mock(Model.class);
    SystemTime systemTime = mock(SystemTime.class);
    AccountStatusController controller = new AccountStatusController(service, systemTime);
    private String today = "2016-05-25";
    private String later_than_today = "2016-08-01";

    @Test
    public void getAccountStatus_use_AccountStatus_view(){
        assertEquals("AccountStatus", controller.getAccountStatus(model));
    }

    @Test
    public void getAccountStatus_display_account_status_from_service() {
        ArrayList<AccountStatus> accountStatusList = new ArrayList<>();
        //when(service.getAccountStatus()).thenReturn(accountStatusList);

        controller.getAccountStatus(model);

        verify(model).addAttribute("accountStatusList", accountStatusList);
    }

    @Test
    public void print_date_fail_msg_when_input_a_date_later_than_today() throws ParseException {
        // arrage
        SystemTime systemTime = mock(SystemTime.class);
        when(systemTime.getNow()).thenReturn(new SimpleDateFormat("yyyy-MM-dd").parse(today));
        AccountStatusController accountStatusController = new AccountStatusController(service, systemTime);

        //action
        accountStatusController.saveAccountStatus(later_than_today,"remark","asfas","asfsd",model);

        //assert
        verify(model).addAttribute("msg","Date must be no later than today!");

    }



}
