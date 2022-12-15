package org.example.Pages;

import org.example.StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P01_register {
    public WebElement registerLink()
    {
        return Hooks.driver.findElement(By.cssSelector("a[class=\"ico-register\"]"));
    }
    public WebElement gender()
    {
        return Hooks.driver.findElement(By.id("gender-male"));
    }
    public WebElement firstName()
    {
        return Hooks.driver.findElement(By.id("FirstName"));
    }
    public WebElement lastName()
    {
        return Hooks.driver.findElement(By.id("LastName"));
    }
    public WebElement birthDay(){ return Hooks.driver.findElement(By.cssSelector("select[name=\"DateOfBirthDay\"]"));}
    public WebElement birthMonth(){ return Hooks.driver.findElement(By.cssSelector("select[name=\"DateOfBirthMonth\"]"));}
    public WebElement birthYear(){ return Hooks.driver.findElement(By.cssSelector("select[name=\"DateOfBirthYear\"]"));}
    public WebElement email(){return Hooks.driver.findElement(By.id("Email"));}
    public WebElement password(){return Hooks.driver.findElement(By.id("Password"));}
    public WebElement confirmPassword(){return Hooks.driver.findElement(By.id("ConfirmPassword"));}
    public WebElement registerButton(){return Hooks.driver.findElement(By.id("register-button"));}
    public WebElement registerResult(){return Hooks.driver.findElement(By.cssSelector("div[class=\"result\"]"));}
}
