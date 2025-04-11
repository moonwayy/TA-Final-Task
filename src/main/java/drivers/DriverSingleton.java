package drivers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private static final Logger logger = LoggerFactory.getLogger(DriverSingleton.class);

    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            logger.info("Initializing new WebDriver instance...");
            driverThreadLocal.set(createDriver());
        }
        return driverThreadLocal.get();
    }

    private static WebDriver createDriver() {
        String browser = System.getProperty("browser", "firefox").toLowerCase();
        logger.info("Selected browser: {}", browser);
        switch (browser) {
            case "chrome":
                return new ChromeDriver();
            case "edge":
                return new EdgeDriver();
            default:
                return new FirefoxDriver();
        }
    }

    public static void quitDriver() {
        if (driverThreadLocal.get() != null) {
            logger.info("Closing WebDriver...");
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}
