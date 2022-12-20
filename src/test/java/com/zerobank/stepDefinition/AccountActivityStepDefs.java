package com.zerobank.stepDefinition;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityStepDefs {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        @And("User should navigate to go {string}")
        public void userShouldNavigateToGo(String account) {
                accountActivityPage.navigateToAccount(account);
        }

        @When("User should see the {string} as default type")
        public void user_should_see_the_as_default_type(String expected) {
                WebElement dropDownElement= Driver.get().findElement(new By.ByCssSelector("#aa_accountId"));
                Select select = new Select(dropDownElement);
                String actual= select.getFirstSelectedOption().getText();
                System.out.println(actual);
                Assert.assertEquals(expected,actual);

        }

        @When("User should see the following Accounts")
        public void user_should_see_the_following_accounts(String account) {

                System.out.println(accountActivityPage.getSelectMenu());


        }
        @When("User should see the following options")
        public void user_should_see_the_following_options(List<String> expectedOptions) {
                List<String>actualOptions= BrowserUtils.getElementsText(accountActivityPage.rowHeader_loc);

                Assert.assertEquals(expectedOptions,actualOptions);
        }


}


