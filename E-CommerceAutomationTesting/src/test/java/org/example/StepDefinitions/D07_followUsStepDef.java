package org.example.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.Pages.P03_homePage;
import org.testng.Assert;

import java.util.ArrayList;

public class D07_followUsStepDef {
    P03_homePage homePage = new P03_homePage();
    @Given("user opens facebook link")
    public void userOpenFaceBook ()  {
        homePage.facebook().click();
    }

    @Given("user opens twitter link")
    public void userOpensTwitterLink()  {
        homePage.twitter().click();
    }

    @Given("user opens rss link")
    public void userOpensRssLink()  {
        homePage.rss().click();
    }

    @Given("user opens youtube link")
    public void userOpensYoutubeLink() {
        homePage.youtube().click();
    }

    @When("{string} is opened in new tab")
    public void isOpenedInNewTab(String arg0) throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
             if(tabs.size()==2){Hooks.driver.switchTo().window(tabs.get(1));}
             else {Hooks.driver.switchTo().window(tabs.get(0));}
        Thread.sleep(5000);
        String actualUrl = Hooks.driver.getCurrentUrl();
        Hooks.driver.close();
        Assert.assertEquals(actualUrl,arg0);
    }

}
