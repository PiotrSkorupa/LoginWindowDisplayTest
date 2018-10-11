package com.williamhill.vegas.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(className = "login-component__wrapper")
    private WebElement loginWindow;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isWindowDisplay(WebDriver driver) {
        try {
            if (loginWindow.isDisplayed()) {
                return true;
            }
        } catch (NoSuchElementException e) {
            System.out.println("Login window has not been displayed");
        }
        return false;
    }
}
