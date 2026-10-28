package com.example.pages;

import com.example.config.ConfigReader;
import com.example.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver = DriverFactory.getDriver();
    private final WebDriverWait wait = new WebDriverWait(
            driver, Duration.ofSeconds(ConfigReader.getInt("explicit.wait.seconds")));

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By productsTitle = By.cssSelector(".title");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public void open() {
        driver.get(ConfigReader.get("base.url"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
    }

    public void login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput)).clear();
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isProductsPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productsTitle))
                .getText().equalsIgnoreCase("Products");
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }
}
