package hooks;

import drivers.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.SettingsTestData;

import static io.qameta.allure.Allure.step;

public class Hooks {
    @Before
    public void setUp() {
        step("open a browser");
        DriverSingleton.getDriver().manage().window().maximize();
        DriverSingleton.getDriver().manage().deleteAllCookies();
        DriverSingleton.getDriver().navigate().to(SettingsTestData.getEnvData().getHost());
    }

    @After
    public void tearDown() {
        step("close a browser");
        DriverSingleton.quitDriver();
    }
}
