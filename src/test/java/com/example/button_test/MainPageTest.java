package com.example.button_test;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;


    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Кнопка Visible After 5 Seconds стала видимой")
    public void visibleButton() {

        driver.get("https://demoqa.com/dynamic-properties");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#visibleAfter")));

        assertTrue(driver.findElement(By.cssSelector("#visibleAfter")).isDisplayed(), "Кнопка не отображается");
    }

}
