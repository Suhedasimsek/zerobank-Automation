package com.zerobank.stepDefinition;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDef {
    LoginPage loginPage = new LoginPage();

    @Given("User should be on the login page")
    public void user_should_be_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("User should input username {string} and password {string}")
    public void user_should_input_username_and_password(String username, String password) {
        loginPage.signButton_loc.click();
        loginPage.userName_loc.sendKeys(username);
        loginPage.password_loc.sendKeys(password);
        loginPage.loginButton_loc.click();
        Driver.get().get("http://zero.webappsecurity.com/bank/account-summary.html");
    }
    @And("User should navigate to {string}")
    public void userShouldNavigateTo(String account) {
        loginPage.navigateToAccount(account);
    }

    @Then("{string} page should be displayed")
    public void page_should_be_displayed(String expectedTitle) {
        String actualTitle = Driver.get().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @When("User should input usenameInfo {string} and passwordInfo {string}")
    public void userShouldInputUsenameInfoAndPasswordInfo(String str1, String str2) {
        Driver.get().get(ConfigurationReader.get("url"));
        loginPage.signButton_loc.click();
        loginPage.userName_loc.sendKeys(str1);
        loginPage.password_loc.sendKeys(str2);
        loginPage.loginButton_loc.click();
    }

    @Then("Error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String expectedMessage) {
        String actualMessage = loginPage.errorMessage_loc.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
