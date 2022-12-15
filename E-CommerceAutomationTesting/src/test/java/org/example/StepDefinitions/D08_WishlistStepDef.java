package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_homePage;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D08_WishlistStepDef {
    P03_homePage homePage = new P03_homePage();
    @Given("click on wishlist button ❤️ on this product \"HTC One M8 Android L 5.0 Lollipop")
    public void addToWishlist () {
        homePage.addToWishlist().get(2).click();

    }
    @When("check success message and background color")
    public void checkSuccessMessageAndBackgroundColor() {
        SoftAssert softAssert = new SoftAssert();
        String messageBackgroundColor = homePage.checkAddWishlist().getCssValue("background-color");
        String actualMessageWishList = homePage.checkAddWishlist().getText();
        String expectedMessageWishList = "The product has been added to your wishlist";
        String actualBackGroundColor = Color.fromString(messageBackgroundColor).asHex();
        softAssert.assertEquals(actualBackGroundColor,"#4bb07a");
        softAssert.assertEquals(actualMessageWishList,expectedMessageWishList);
        softAssert.assertAll();
    }

    @When("wait until message and background color disappear")
    public void waitUntilMessageAndBackgroundColorDisappear() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(homePage.checkAddWishlist()));
    }

    @Then("click on Wishlist Tab on the top of the page")
    public void clickOnTabOnTheTopOfThePage() {
        homePage.wishListTab().click();
    }

    @And("get Qty value and verify it's bigger than 0")
    public void getQtyValueAndVerifyItSBiggerThan() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        String Qty = homePage.wishListQty().getAttribute("value");
        softAssert.assertNotEquals(Qty,0);


    }
}
