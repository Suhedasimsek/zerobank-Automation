package com.zerobank.stepDefinition;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
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
        AccountActivityPage accountActivityPage = new AccountActivityPage();

        @When("User should see the {string} as default type")
        public void user_should_see_the_as_default_type(String expectedOption) {

                Select select = new Select(accountActivityPage.dropDownElement_loc);
                String actualoption = select.getFirstSelectedOption().getText();

                Assert.assertEquals(expectedOption, actualoption);
        }

        @When("User should see the following Accounts")
        public void user_should_see_the_following_accounts(List<String> expectedaccountTypes) {

                Select select = new Select(accountActivityPage.dropDownElement_loc);
                List<WebElement> options = select.getOptions();
                List<String> actualaccountTypes = BrowserUtils.getElementsText(options);
                Assert.assertEquals(expectedaccountTypes, actualaccountTypes);

                /*boolean match=false;

                for(WebElement option: options){
                        System.out.println("option.getText() = " + option.getText());

                        for(int i=0;i<expectedaccountTypes.size();i++){
                                if(option.getText().equals(expectedaccountTypes.get(i))){

                                        match=true;
                                }
                        }
                        Assert.assertTrue(match);
                }
                //****Assert için güzel bir yöntem


                */

        }

        @When("User should see the following options")
        public void user_should_see_the_following_options(List<String> expectedOptions) {
                List<String> actualOptions = BrowserUtils.getElementsText(accountActivityPage.rowHeader_loc);

                Assert.assertEquals(expectedOptions, actualOptions);
        }

}

