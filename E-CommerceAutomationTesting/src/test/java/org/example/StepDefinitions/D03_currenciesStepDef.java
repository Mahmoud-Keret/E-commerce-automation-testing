package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Pages.P03_homePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class D03_currenciesStepDef {
    P03_homePage currency = new P03_homePage();
    @Given("click on the currency drop menu")
    public void clickCurrency(){
currency.currency().click();
    }

    @And("choose euro")
    public void chooseEuro() {
        Select select = new Select(currency.currency());
        select.selectByVisibleText("Euro");
    }

    @Then("check that items price updated to euro")
    public void checkThatItemsPriceUpdatedToEuro() {
        for (int i=0 ; i<currency.prices().size();i++)
        {
            String price = currency.prices().get(i).getText();
            Assert.assertTrue(price.contains("€"));
        }
    }
}
