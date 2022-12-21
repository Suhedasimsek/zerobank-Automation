package com.zerobank.stepDefinition;


import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountSummaryStepDefs {
     AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
    @Then("User should see the following Accounts Types")
    public void user_should_see_the_following_accounts_types(List<String> expectedAccounts) {

        List<String> actualAccounts = BrowserUtils.getElementsText(accountSummaryPage.accountTypes_loc);
        System.out.println("actualAccounts.size() = " + actualAccounts.size());
        System.out.println("actualAccounts = " + actualAccounts);

        Assert.assertEquals(expectedAccounts, actualAccounts);

    }

    @Then("Credit Accounts table should have following columns")
    public void credit_accounts_table_should_have_following_columns(List<String> expectedColumns) {
        List<String> actualColumns = BrowserUtils.getElementsText(accountSummaryPage.creditAccountColumn_loc);

        Assert.assertEquals(expectedColumns, actualColumns);
    }

}