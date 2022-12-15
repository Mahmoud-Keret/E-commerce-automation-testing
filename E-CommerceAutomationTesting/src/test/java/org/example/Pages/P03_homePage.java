package org.example.Pages;

import org.example.StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_homePage {

    public WebElement currency(){return Hooks.driver.findElement(By.id("customerCurrency"));}
    public List<WebElement> prices(){return Hooks.driver.findElements(By.cssSelector("div[class=\"prices\"]"));}

    public WebElement searchText () { return Hooks.driver.findElement(By.id("small-searchterms"));}
    public WebElement searchButton() {return Hooks.driver.findElement(By.cssSelector("button[type=\"submit\"]"));}
    public String searchURL () {return Hooks.driver.getCurrentUrl();}
    public List<WebElement> searchByWordResults () {return Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"]"));}
    public WebElement searchedWord () {return Hooks.driver.findElement(By.id("q"));}
    public WebElement productTitle () {return  Hooks.driver.findElement(By.cssSelector("h2[class=\"product-title\"]"));}
    public WebElement getProductSku () {return Hooks.driver.findElement(By.cssSelector("div[class=\"sku\"]"));}
    public  List<WebElement> mainCategories() {return Hooks.driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"]>li"));}
    public WebElement subCategoriesSelect (String sub) {return Hooks.driver.findElement(By.linkText(sub));}
    public List<WebElement> selectedText (int selected) {return mainCategories().get(selected).findElements(By.cssSelector("ul[class=\"sublist first-level\"]>li"));}

    public WebElement pageTitle () {return Hooks.driver.findElement(By.cssSelector("div[class=\"page-title\"]"));}
    public WebElement mainCategoryPageTitle () {return Hooks.driver.findElement(By.cssSelector("div[class=\"page-title\"]"));}
    public WebElement firstSlider () {return Hooks.driver.findElement(By.cssSelector("a[class=\"nivo-control\"]"));}
    public WebElement secondSlider () {return Hooks.driver.findElement(By.cssSelector("a[class=\"nivo-control active\"]"));}
    public WebElement facebook () {return Hooks.driver.findElement(By.cssSelector("li[class=\"facebook\"]"));}
    public WebElement twitter () {return Hooks.driver.findElement(By.cssSelector("li[class=\"twitter\"]"));}
    public WebElement rss () {return Hooks.driver.findElement(By.cssSelector("li[class=\"rss\"]"));}
    public WebElement youtube () {return Hooks.driver.findElement(By.cssSelector("li[class=\"youtube\"]"));}
    public List<WebElement> addToWishlist() {return Hooks.driver.findElements(By.cssSelector("button[title=\"Add to wishlist\"]"));}
    public WebElement checkAddWishlist () {return Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));}
    public WebElement wishListTab () {return Hooks.driver.findElement(By.cssSelector("span[class=\"wishlist-label\"]"));}
    public WebElement wishListQty () {return Hooks.driver.findElement(By.cssSelector("input[class=\"qty-input\"]"));}
}
