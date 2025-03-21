package pages;

import constants.Username;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SettingsTestData;

import java.time.Duration;

public class LoginPage extends AbstractPage {
    private final WebDriverWait wait;
    private final Logger logger = LogManager.getRootLogger();

    private final By usernameInput = By.cssSelector("input#user-name");
    private final By passwordInput = By.cssSelector("input#password");
    private final By loginButton = By.cssSelector("input#login-button");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");
    private final By loginLogo = By.cssSelector("div.login_logo");


    public LoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(SettingsTestData.getEnvData().getWait()));
    }

    @Override
    public LoginPage openPage()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginLogo));
        logger.info("Login page opened");
        return this;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterValidUsername() {
        driver.findElement(usernameInput).sendKeys(Username.USERNAME.getValue());
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clearInputs() {
        driver.findElement(usernameInput).clear();
        driver.findElement(passwordInput).clear();
    }

    public void clearPasswordField() {
        driver.findElement(passwordInput).clear();
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return driver.findElement(errorMessage).getText();
    }
}
