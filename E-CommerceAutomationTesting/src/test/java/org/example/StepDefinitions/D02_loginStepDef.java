package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P02_login;
import org.testng.asserts.SoftAssert;


public class D02_loginStepDef {
    P02_login login = new P02_login();

    @Given("user go to login page")
    public void goToLoginPage()
    {
        login.loginLink().click();
    }

    @When("user login with valid {string} and {string}")
    public void userLoginValid( String arg1, String arg2) {
        login.loginEmail().sendKeys(arg1);
        login.loginPassword().sendKeys(arg2);
    }
    @When("user login with invalid {string} and {string}")
    public void userLoginInvalid( String arg1, String arg2) {
        login.loginEmail().sendKeys(arg1);
        login.loginPassword().sendKeys(arg2);
    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        login.loginButton().click();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        SoftAssert softAssert=new SoftAssert();
        String expectedURL = "https://demo.nopcommerce.com/";
        softAssert.assertEquals(expectedURL,login.getCurrentURL(),"URL is different");
        softAssert.assertTrue(login.myAccountButton().isDisplayed(),"My account button is not displayed");
        softAssert.assertTrue(login.logoutButton().isDisplayed(),"Logout button is not displayed");
        softAssert.assertAll();
    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        SoftAssert softAssert = new SoftAssert();
       String expectedMsg= "Login was unsuccessful.";
       String actualMsg = login.failMsg().getText();
       String expectedColor ="#e4434b";
       String Color = login.failMsg().getCssValue("color");
       String actualColor = org.openqa.selenium.support.Color.fromString(Color).asHex();
       softAssert.assertTrue(actualMsg.contains(expectedMsg),"Wrong msg");
       softAssert.assertEquals(expectedColor,actualColor,"Wrong color");
       softAssert.assertAll();

    }
}
