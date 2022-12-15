package org.example.Pages;

import org.example.StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_login {
    public WebElement loginLink()
    {
        return Hooks.driver.findElement(By.cssSelector("a[class=\"ico-login\"]"));
    }
    public WebElement loginEmail(){return Hooks.driver.findElement(By.id("Email"));}
    public WebElement loginPassword(){return Hooks.driver.findElement(By.id("Password"));}
    public WebElement loginButton (){return Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]"));}
    public WebElement myAccountButton(){return Hooks.driver.findElement(By.cssSelector("a[class=\"ico-account\"]"));}
    public WebElement logoutButton(){return Hooks.driver.findElement(By.cssSelector("a[class=\"ico-logout\"]"));}
    public WebElement failMsg(){return Hooks.driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]"));}
    public String getCurrentURL () {return Hooks.driver.getCurrentUrl();}

}
