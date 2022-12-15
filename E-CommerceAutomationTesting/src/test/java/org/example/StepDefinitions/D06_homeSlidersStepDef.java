package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Pages.P03_homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class D06_homeSlidersStepDef {
    P03_homePage homePage = new P03_homePage();
    String firstExpectedUrl="https://demo.nopcommerce.com/nokia-lumia-1020";
    String secondExpectedUrl="https://demo.nopcommerce.com/iphone-6";
    String firstActualUrl,secondActualUrl;

    @Given("click on the first slider")
    public void clickFirstSlider () {
        homePage.firstSlider().click();
    }
    @Given("click on the second slider")
    public void clickOnTheSecondSlider() {
        homePage.secondSlider().click();
    }

    @Then("wait until the first slider url contains the expected result")
    public void waitUntilTheFirstSliderUrlContainsTheExpectedResult() {
        WebDriverWait wait1 = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait1.until(WebDriver::getCurrentUrl).contains(firstExpectedUrl);
    }

    @Then("wait until the second slider url contains the expected result")
    public void waitUntilTheSecondSliderUrlContainsTheExpectedResult() {
        WebDriverWait wait2 = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait2.until(WebDriver::getCurrentUrl).contains(secondExpectedUrl);
    }

    @And("check if the first slider expected url is the same as actual url")
    public void checkIfTheFirstSliderExpectedUrlIsTheSameAsActualUrl() {
        firstActualUrl = Hooks.driver.getCurrentUrl();
        Assert.assertEquals(firstActualUrl,firstExpectedUrl);

    }

    @And("check if the second slider expected url is the same as actual url")
    public void checkIfTheSecondSliderExpectedUrlIsTheSameAsActualUrl() {
        secondActualUrl = Hooks.driver.getCurrentUrl();
        Assert.assertEquals(secondActualUrl,secondExpectedUrl);
    }
}
