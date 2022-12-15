package org.example.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_homePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D04_searchStepDef {
    P03_homePage homePage = new P03_homePage();
    String arg1;

    @Given("enter product name in search field {string}")
    public void enterProductNameInSearchField(String arg0) {
        homePage.searchText().sendKeys(arg0);
    }

    @Given("enter product Sku in search field {string}")
    public void enterProductSkuInSearchField(String arg1) {
        this.arg1=arg1;
        homePage.searchText().sendKeys(arg1);
    }
    @When("click on search button")
    public void clickSearch()
    {
        homePage.searchButton().click();
    }

    @Then("check the URL product name search result")
    public void checkTheProductNameSearchResult() {
        SoftAssert softAssert = new SoftAssert();
        String expectedURL = "https://demo.nopcommerce.com/search?q=";
        String actualURL = homePage.searchURL();
        softAssert.assertTrue(actualURL.contains(expectedURL));
        int numOfSearchItems = homePage.searchByWordResults().size();
        for (int i=0 ; i<numOfSearchItems ; i++)
        {
            String searchWord = homePage.searchByWordResults().get(i).getText().toLowerCase();
            softAssert.assertTrue(searchWord.contains(homePage.searchedWord().getText()),"search word isn't existed");
            softAssert.assertAll();
        }
    }

    @Then("check the product sku search result")
    public void checkTheProductSkuSearchResult() throws InterruptedException {
        homePage.productTitle().click();
        Thread.sleep(3000);
        String actualSku = homePage.getProductSku().getText();
        Assert.assertTrue(actualSku.contains(arg1),"Confirm of sku search");
    }
}

