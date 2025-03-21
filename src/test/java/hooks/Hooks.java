package hooks;

import drivers.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import utils.SettingsTestData;

import static io.qameta.allure.Allure.step;

public class Hooks {
    private static final Logger logger = LogManager.getLogger(Hooks.class);

    @Before
    public void setUp() {
        logger.info("Setting up test environment...");
        step("Open a browser");
        DriverSingleton.getDriver().manage().window().maximize();
        DriverSingleton.getDriver().manage().deleteAllCookies();
        DriverSingleton.getDriver().navigate().to(SettingsTestData.getEnvData().getHost());
        logger.info("Test environment setup complete.");
    }

    @After
    public void tearDown() {
        logger.info("Closing browser after test execution...");
        step("Close a browser");
        DriverSingleton.quitDriver();
    }
}
