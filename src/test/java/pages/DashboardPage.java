package pages;

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

public class DashboardPage extends AbstractPage {
    private final WebDriverWait wait;
    private final Logger logger = LogManager.getLogger(DashboardPage.class);

    @FindBy(css = "div.app_logo")
    private WebElement appLogo;

    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(SettingsTestData.getEnvData().getWait()));
    }

    @Override
    public DashboardPage openPage() {
        wait.until(ExpectedConditions.visibilityOf(appLogo));
        logger.info("Dashboard page opened");
        return this;
    }

    public String getTitleText() {
        return appLogo.getText();
    }
}
