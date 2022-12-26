package com.zerobank.stepDefinition;

import com.zerobank.pages.PaymentPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.util.Map;

public class PaymentStepDefs {
    PaymentPage paymentPage = new PaymentPage();

    @And("User should input the pay requirements")
    public void userShouldInputThePayRequirements() {
        Select select = new Select(paymentPage.payee_loc);
        select.selectByVisibleText("Apple");

        Select select2 = new Select(paymentPage.accountInput_loc);
        select2.selectByVisibleText("Loan");
        paymentPage.amountInput_loc.sendKeys("200");
        paymentPage.dateInput.sendKeys("2022-12-10");
        paymentPage.descriptionInput.sendKeys("payment");
        paymentPage.payBtn.click();


    }

    @Then("{string} message should be displayed on page")
    public void messageShouldBeDisplayedOnPage(String expectedMessage) {
        BrowserUtils.waitFor(2);
        String actualMessage = paymentPage.messageText.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
    @And("User should not complete pay operation by using invalid {string}, {string},{string}")
    public void userShouldNotCompletePayOperationByUsingInvalid(String amount, String date, String description) {
        Select select=new Select(paymentPage.payee_loc);
        select.selectByVisibleText("Bank of America");

        Select select1=new Select(paymentPage.accountInput_loc);
        select1.selectByVisibleText("Loan");

        paymentPage.amountInput_loc.sendKeys(amount);
        paymentPage.dateInput.sendKeys(date);
        paymentPage.descriptionInput.sendKeys(description);

        paymentPage.payBtn.click();
    }

    @Then("{string} message should not be displayed on page")
    public void messageShouldNotBeDisplayedOnPage(String expectedMessage) {
        String actualMessage=paymentPage.messageText.getText();
        boolean match=false;
        if (actualMessage!=expectedMessage){
            match=true;
        }
        Assert.assertTrue(match);

    }


    @Given("Add New Payee tab")
    public void add_new_payee_tab() {

        paymentPage.addNewPaye_loc.click();


    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> userInfo) {
        paymentPage.addWithParameters(userInfo.get("Payee Name"), userInfo.get("Payee Address"), userInfo.get("Account"), userInfo.get("Payee details"));
    }


    @Then("message {string} should be displayed")
    public void messageShouldBeDisplayed(String expectedMessage) {
       //String actualMessage = paymentPage.alertMessage_loc.getText();
       //Assert.assertEquals(expectedMessage, actualMessage);

        //System.out.println(Driver.get().getPageSource());// alertContent.html("") içinde de yazılı

        if (expectedMessage.contains("success")) {
            Assert.assertTrue("Allert Box is not displayed", paymentPage.messageText.isDisplayed());
            String actualMessage = paymentPage.messageText.getText();
            System.out.println("actualMessage = " + actualMessage);
            Assert.assertEquals("message do not match", expectedMessage, actualMessage);

        } else {
            if (paymentPage.amountInput_loc.getAttribute("value").isEmpty()) {
                String actualMessage = paymentPage.amountInput_loc.getAttribute("validationMessage");
                System.out.println("actualMessage = " + actualMessage);
                Assert.assertEquals("alert do not match", expectedMessage, actualMessage);
            } else {
                String actualMessage = paymentPage.dateInput.getAttribute("validationMessage");
                System.out.println("actualMessage = " + actualMessage);
                Assert.assertEquals("alert do not match", expectedMessage, actualMessage);
            }

        }

    }

}


