package com.williamhill.vegas.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VegasPage extends BasePage {

    private WebDriverWait wait;

    @FindBy(className = "btn-search-magnifier")
    private WebElement searchButton;

    @FindBy(css = ".cHTTOm")
    private WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/section/div/div/div[1]/div/div/div/div[3]/div/button[2]")
    private WebElement moreButton;

    @FindBy(xpath = "//div[contains(text(), 'Play now')]")
    private WebElement playButton;

    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/div[3]/div/div/div[3]/section/div/div/div[1]/div/div/div/div[1]/div/img")
    private WebElement hoverOverTo;

    public VegasPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public VegasPage searchFor(String text) {
        searchButton.click();
        searchBox.sendKeys(text);
        return this;
    }

    public VegasPage clickMoreButton(WebDriver driver) {
        new Actions(driver)
                .moveToElement(hoverOverTo)
                .perform();
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(moreButton));
        moreButton.click();
        return this;
    }

    public VegasPage playGame() {
        playButton.click();
        return this;
    }
}
