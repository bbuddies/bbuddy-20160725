package com.odde.bbuddy.accountStatus.controller;

import com.odde.bbuddy.accountStatus.AccountStatus;
import com.odde.bbuddy.accountStatus.AccountStatusImpl;
import org.junit.Test;
import org.springframework.ui.Model;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AccountStatusControllerTest {

    //GIVEN a later date input
    //WHEN  call controller using this invalid date
    //THEN  1. msg print 2. view name = create page 3. save is not called


    AccountStatusImpl service = mock(AccountStatusImpl.class);
    Model model = mock(Model.class);
    AccountStatusController controller = new AccountStatusController(service);

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

    @Test
    public void print_date_fail_msg_when_input_a_date_later_than_today(){
        // arrage
        AccountStatusController accountStatusController = new AccountStatusController(service);

        //action
        accountStatusController.saveAccountStatus("2016-08-01","asdf","asfas","asfsd",model);

        //assert
        verify(model).addAttribute("msg","Date must be no later than today!");

    }



}
