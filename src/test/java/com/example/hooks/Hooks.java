package com.example.hooks;

import com.example.driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    
    @Before
    public void beforeScenario() {
        DriverFactory.startDriver();
    }

    @After
    public void afterScenario(Scenario scenario) {
        try {
            WebDriver driver = DriverFactory.getDriver();
            if (scenario.isFailed() && driver instanceof TakesScreenshot screenshotDriver) {
                byte[] screenshot = screenshotDriver.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        } finally {
            DriverFactory.quitDriver();
        }
    }
}
