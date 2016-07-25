package com.odde.bbuddy.accountStatus.controller;

import com.odde.bbuddy.accountStatus.AccountStatus;
import com.odde.bbuddy.accountStatus.AccountStatusImpl;
import com.odde.bbuddy.budget.MonthlyBudgetPlanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class getAccountStatusController {

    @Autowired
    private AccountStatusImpl accountStatusSerivce;

    @RequestMapping("/get_accountStatus")
    public String getAccountStatus(Model model) {


        model.addAttribute("accountStatusList", accountStatusSerivce.getAccountStatus());

        return "AccountStatus";
    }

    @RequestMapping("/save_accountStatus")
    public String saveAccountStatus(@RequestParam("date")String date,
                                    @RequestParam("remark")String remark,
                                    @RequestParam("amount")String amount,
                                    @RequestParam("amount_type")String amount_type,Model model) {
        AccountStatus accountStatus = new AccountStatus();
        accountStatus.setDate(date);
        accountStatus.setRemark(remark);
        accountStatus.setAmount(amount);
        accountStatus.setAmount_type(amount_type);

        accountStatusSerivce.saveAccountStatus(accountStatus);

        return "redirect:/get_accountStatus";

    }

}
