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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class AccountStatusController {


    private AccountStatusImpl accountStatusSerivce;

    @Autowired
    public AccountStatusController(AccountStatusImpl accountStatusSerivce) {
         this.accountStatusSerivce = accountStatusSerivce;
    }

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

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        try {
            date1 = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(date1.after(new Date())){
            model.addAttribute("msg","Date must be no later than today!");
            return "save_accountStatus";
        }

        AccountStatus accountStatus = new AccountStatus();
        accountStatus.setDate(date);
        accountStatus.setRemark(remark);
        accountStatus.setAmount(amount);
        accountStatus.setAmount_type(amount_type);

        accountStatusSerivce.saveAccountStatus(accountStatus);

        return "redirect:/get_accountStatus";

    }

}
