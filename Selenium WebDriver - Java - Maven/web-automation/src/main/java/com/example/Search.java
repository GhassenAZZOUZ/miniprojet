package com.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class Search {

    private WebDriver driver;

    @Given("^I open the website \"(.*)\"$")
    public void iOpenTheWebsite(String url) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ghast\\Desktop\\IntelliJ\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }

    @When("^I click on the \"(.*)\" link$")
    public void iClickOnTheLink(String linkText) {
        WebElement link = driver.findElement(By.linkText(linkText));
        link.click();
    }

    @Then("^I should see the \"(.*)\" section$")
    public void iShouldSeeTheSection(String sectionText) {
        WebElement section = driver.findElement(By.xpath("//h1[text()='" + sectionText + "']"));
        assertTrue(section.isDisplayed());
    }

    @When("^I enter \"(.*)\" in the search box and submit$")
    public void iEnterInTheSearchBoxAndSubmit(String searchKeyword) {
        WebElement searchBox = driver.findElement(By.name("searchMeta"));
        searchBox.sendKeys(searchKeyword);
        searchBox.submit();
    }

    @Then("^I should see the text \"(.*)\"$")
    public void iShouldSeeTheText(String expectedText) {
        WebElement searchResult = driver.findElement(By.xpath("//a[text()='" + expectedText + "']"));
        assertTrue(searchResult.isDisplayed());
    }

    @Then("^I close the browser$")
    public void iCloseTheBrowser() {
        driver.quit();
    }
}
