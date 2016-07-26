package com.odde.bbuddy.accountStatus.controller;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

/**
 * Created by zouyongle on 16/7/26.
 */
public class test {

    public WebDriver driver=new FirefoxDriver();

    private String income;

    private  String outcome;

    @Given("^Data on Database and can be shown on website$")
    public void data_on_Database_and_can_be_shown_on_website() throws Throwable {
        driver.get("http://localhost:8080/get_accountStatus");

        income = driver.findElement(By.id("income")).getText();
        outcome = driver.findElement(By.id("outcome")).getText();


        //throw new PendingException();
    }

    @When("^Access list page$")
    public void access_list_page() throws Throwable {
        for (WebElement webElement:driver.findElements(By.tagName("tr"))) {
            System.out.println(webElement.findElement(By.id("amount")).getText());
        }


        //throw new PendingException();
    }

    @Then("^To catch data to count$")
    public void to_catch_data_to_count() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

}
