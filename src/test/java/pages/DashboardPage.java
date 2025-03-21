package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SettingsTestData;

import java.time.Duration;

public class DashboardPage extends AbstractPage {
    private final WebDriverWait wait;
    private final Logger logger = LogManager.getRootLogger();

    private final By appLogo = By.cssSelector("div.app_logo");


    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(SettingsTestData.getEnvData().getWait()));
    }

    public DashboardPage openPage()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(appLogo)).isDisplayed();
        logger.info("Login page opened");
        return this;
    }

    public String isTitlePresent() {
        return driver.findElement(appLogo).getText();
    }
}
