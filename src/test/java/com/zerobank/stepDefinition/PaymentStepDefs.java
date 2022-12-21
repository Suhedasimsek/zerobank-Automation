package com.zerobank.stepDefinition;

import com.zerobank.pages.PaymentPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class PaymentStepDefs {
    PaymentPage paymentPage=new PaymentPage();
    @Given("Add New Payee tab")
    public void add_new_payee_tab() {

        paymentPage.addNewPaye_loc.click();




    }
    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> userInfo) {
        paymentPage.addWithParameters(userInfo.get("Payee Name"), userInfo.get("Payee Address"), userInfo.get("Account"), userInfo.get("Payee details"));
    }


    @Then("message {string} should be displayed")
    public void messageShouldBeDisplayed(String expectedMessage) {
        String actualMessage= paymentPage.alertMessage_loc.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }
}
