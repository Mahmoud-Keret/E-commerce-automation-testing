package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_homePage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class D05_hoverCategoriesStepDef {
    P03_homePage homePage = new P03_homePage();
    String actualPageTitle;
    String subCategoryName;
    String selectedMainCategory;
    String subCategoryNameLink;
    int min=0,max=0,selected,subSelected;


    @Given("Hover on main category and click on sub category")
    public void hoverOnMainAndClickOnRandom()
    {
        Actions actions = new Actions(Hooks.driver);

        selected = (int) Math.floor(Math.random()*(max-min+1)+min);
        subSelected = (int) Math.floor(Math.random()*(max-min+1)+min);
        actions.moveToElement(homePage.mainCategories().get(selected)).perform();
        selectedMainCategory = homePage.mainCategories().get(selected).getText().toLowerCase().trim();
        subCategoryName = homePage.selectedText(selected).get(subSelected).getText().toLowerCase().trim();
        subCategoryNameLink = homePage.selectedText(selected).get(subSelected).getText();
        homePage.subCategoriesSelect(subCategoryNameLink).click();
    }

    @When("get text of page title")
    public void getTextOfPageTitle() {
       actualPageTitle = homePage.pageTitle().getText().toLowerCase().trim();
    }

    @Then("check the selected category has the same title")
    public void checkTheSelectedCategoryHasTheSameTitle() {
        System.out.println("Actual "+actualPageTitle);
        System.out.println("Expected "+subCategoryName);
        Assert.assertTrue(actualPageTitle.contains(subCategoryName));
    }
    @And("doing advanced assert using if")
    public void doingAdvancedAssertUsingIf() {
        if (selectedMainCategory.contains(actualPageTitle))
        {
            Assert.assertTrue(actualPageTitle.contains(subCategoryName),"Selected Category contain the selected sub category");
        }else if(selectedMainCategory.contains(actualPageTitle)==false)
        {
            homePage.mainCategories().get(selected).click();
            String selectedMainCategory = homePage.mainCategories().get(selected).getText().toLowerCase().trim();
            String selectedMainCategoryPageTitle = homePage.mainCategoryPageTitle().getText().toLowerCase().trim();
            Assert.assertTrue(selectedMainCategory.contains(selectedMainCategoryPageTitle),"Click on main category itself and check title");
        }
    }
}
