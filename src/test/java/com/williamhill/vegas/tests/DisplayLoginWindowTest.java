package com.williamhill.vegas.tests;

import com.williamhill.vegas.pages.VegasPage;
import com.williamhill.vegas.utils.PropertyReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

public class DisplayLoginWindowTest {

    private String gameName = "Mayfair Roulette";
    private WebDriver driver;
    private VegasPage vegasPage;
    private PropertyReader propertyReader;

    @Before
    public void setUp() {
        propertyReader = new PropertyReader();
        System.setProperty("webdriver.chrome.driver", propertyReader.readProperty("driverPath"));
        driver = new ChromeDriver();
        driver.get(propertyReader.readProperty("baseURL"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void shouldDisplayLoginWindow() {
        vegasPage = new VegasPage(driver);
        vegasPage.searchFor(gameName)
                .clickMoreButton(driver)
                .playGame();
        assertTrue(driver.findElement(By.className("login-component__wrapper")).isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
