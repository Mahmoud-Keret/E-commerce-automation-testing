package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P01_register;
import org.openqa.selenium.Keys;
import org.testng.asserts.SoftAssert;


public class D01_registerStepDef {
    P01_register register = new P01_register();

    @Given("user go to register page")
    public void userGoToRegisterPage() {

        register.registerLink().click();
    }

    @When("user select gender type")
    public void userSelectGenderType() {
        register.gender().click();
    }

    @And("user enter first name {string} and last name {string}")
    public void userEnterFirstNameAndLastName(String arg0, String arg1) {
        register.firstName().sendKeys(arg0);
        register.lastName().sendKeys(arg1);
    }

    @And("user enter date of birth")
    public void userEnterDateOfBirth() {
        register.birthDay().sendKeys("30",Keys.ENTER);
        register.birthMonth().sendKeys("April",Keys.ENTER);
        register.birthYear().sendKeys("1988",Keys.ENTER);
    }

    @And("user enter email {string} field")
    public void userEnterEmailField(String arg0) {
        register.email().sendKeys(arg0);
    }

    @And("user fills Password fields {string} {string}")
    public void userFillsPasswordFields(String arg0, String arg1) {
        register.password().sendKeys(arg0);
        register.confirmPassword().sendKeys(arg1);
    }

    @And("user clicks on register button")
    public void userClicksOnRegisterButton() {
        register.registerButton().click();
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        String expectedResult = "Your registration completed";
        String actualResult = register.registerResult().getText();
        String actualMsgColor = register.registerResult().getCssValue("color");
        String expectedMsgColor = "rgba(76, 177, 124, 1)";
        softAssert.assertTrue(actualResult.contains(expectedResult));
        softAssert.assertEquals(expectedMsgColor,actualMsgColor);
        softAssert.assertAll();

    }
}
