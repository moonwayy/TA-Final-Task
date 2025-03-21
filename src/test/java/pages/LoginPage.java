package pages;

import constants.Username;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SettingsTestData;

import java.time.Duration;

public class LoginPage extends AbstractPage {
    private final WebDriverWait wait;
    private final Logger logger = LogManager.getLogger(LoginPage.class);

    @FindBy(css = "input#user-name")
    private WebElement usernameInput;

    @FindBy(css = "input#password")
    private WebElement passwordInput;

    @FindBy(css = "input#login-button")
    private WebElement loginButton;

    @FindBy(css = "h3[data-test='error']")
    private WebElement errorMessage;

    @FindBy(css = "div.login_logo")
    private WebElement loginLogo;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(SettingsTestData.getEnvData().getWait()));
    }

    @Override
    public LoginPage openPage() {
        wait.until(ExpectedConditions.visibilityOf(loginLogo));
        logger.info("Login page opened");
        return this;
    }

    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterValidUsername() {
        usernameInput.sendKeys(Username.USERNAME.getValue());
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clearInputs() {
        usernameInput.clear();
        passwordInput.clear();
    }

    public void clearPasswordField() {
        passwordInput.clear();
    }

    public void clickLogin() {
        loginButton.click();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }
}
