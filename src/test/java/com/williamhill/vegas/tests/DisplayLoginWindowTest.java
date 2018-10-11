package com.williamhill.vegas.tests;

import com.williamhill.vegas.pages.LoginPage;
import com.williamhill.vegas.pages.VegasPage;
import com.williamhill.vegas.utils.PropertyReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

public class DisplayLoginWindowTest {

    private String gameName = "Mayfair Roulette";
    private WebDriver driver;
    private VegasPage vegasPage;
    private LoginPage loginPage;
    private PropertyReader propertyReader;
    public String browser;

    @Before
    public void setUp() {
        propertyReader = new PropertyReader();
        System.setProperty("webdriver.chrome.driver", propertyReader.readProperty("driverPath"));

        ChromeOptions options = new ChromeOptions();
        browser = propertyReader.readProperty("chromeUserAgent");
        options.addArguments(browser);

        driver = new ChromeDriver(options);
        driver.get(propertyReader.readProperty("baseURL"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void shouldDisplayLoginWindow() {
        loginPage = new LoginPage(driver);
        vegasPage = new VegasPage(driver);
        vegasPage.searchFor(gameName)
                .clickMoreButton(driver)
                .playGame(driver);
        assertTrue(loginPage.isWindowDisplay(driver));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
