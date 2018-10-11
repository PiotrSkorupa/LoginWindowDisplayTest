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

    @FindBy(xpath = "//div[contains(text(), 'More')]")
    private WebElement moreButton;

    @FindBy(xpath = "//div[contains(text(), 'Play')]")
    private WebElement playButton;

    @FindBy(xpath = "//img[@class='tile-cover__image']")
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
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(hoverOverTo));
        new Actions(driver)
                .moveToElement(hoverOverTo)
                .perform();
        wait.until(ExpectedConditions.visibilityOf(moreButton));
        moreButton.click();
        return this;
    }

    public VegasPage playGame(WebDriver driver) {
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(playButton));
        playButton.click();
        return this;
    }
}
