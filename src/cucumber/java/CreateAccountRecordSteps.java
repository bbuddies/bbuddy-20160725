import com.odde.bbuddy.accountStatus.AccountStatus;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by taixiaomei on 7/26/16.
 */
public class CreateAccountRecordSteps {

    WebDriver driver = new FirefoxDriver();


    @Given("^there does not exist same record currently$")
    public void there_does_not_exist_same_record_currently() throws Throwable {
        //no code needed
    }


    @When("^create a valid record with date \"([^\"]*)\" remark \"([^\"]*)\" amount \"([^\"]*)\" amount_type \"([^\"]*)\"$")
    public void create_a_valid_record_with_date_remark_amount_amount_type(String date, String remark, String amount, String amountType) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        driver.get("http://localhost:8090/create_accountStatus");
        WebElement dateText = driver.findElement(By.name("date"));
        dateText.sendKeys(date);
        WebElement remarkText = driver.findElement(By.name("remark"));
        remarkText.sendKeys(remark);
        WebElement amountText = driver.findElement(By.name("amount"));
        amountText.sendKeys(amount);
        WebElement amountTypeText = driver.findElement(By.name("amount_type"));
        amountTypeText.sendKeys(amountType);
        amountText.submit();


    }

    @Then("^create succeed$")
    public void create_succeed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals("http://localhost:8090/get_accountStatus",driver.getCurrentUrl());
        driver.quit();

    }


}
