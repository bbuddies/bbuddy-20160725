package com.odde.bbuddy.account;

import com.odde.bbuddy.Application;
import com.odde.bbuddy.account.domain.Account;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.swing.*;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@IntegrationTest
public class CreateAccountSteps {

    @Autowired
    private AccountRepo accountRepo;

    WebDriver driver = new FirefoxDriver();

    @Given("^there is no same account$")
    public void there_is_no_same_account() throws Throwable {

    }

    @When("^create a valid account with account_name \"([^\"]*)\" balance (\\d+)$")
    public void create_a_valid_account_with_account_name_balance(String accountName, int balance) throws Throwable {

        driver.get("localhost:8080/create_account");
        WebElement accountNameTxt = driver.findElement(By.id("accountName"));
        accountNameTxt.sendKeys(accountName);
        WebElement balanceTxt = driver.findElement(By.id("balance"));
        balanceTxt.sendKeys(String.valueOf(balance));
        balanceTxt.submit();
    }

    @Then("^the account information will be saved as name \"([^\"]*)\" balance (\\d+)$")
    public void the_account_information_will_be_saved_as_name_balance(String accountName, int balance) throws Throwable {

        long count = accountRepo.count();
        Account account = accountRepo.findAll().iterator().next();
        assertEquals(1,count);
        assertEquals(accountName,account.getAccountName());
        assertEquals(balance,account.getBalance());
        driver.quit();
    }

    @After
    public void after(){
        accountRepo.deleteAll();
    }

}
