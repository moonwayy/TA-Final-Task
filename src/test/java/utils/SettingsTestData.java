package utils;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import com.google.gson.Gson;
import lombok.experimental.UtilityClass;
import models.EnvData;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;

@UtilityClass
public class SettingsTestData {
    private static final Logger logger = LogManager.getLogger(SettingsTestData.class);

    public final String RESOURCES_PATH = "src/test/resources/";
    private final String ENVIRONMENT_PATH = RESOURCES_PATH + "environment/";
    private final ISettingsFile ENVIRONMENT_CONFIG = new JsonSettingsFile("env.json");
    private final Gson GSON = new Gson();

    public EnvData getEnvData() {
        String envConfigPath = "%s%s.json".formatted(ENVIRONMENT_PATH, getCurrentEnvironment());
        return deserializeJson(envConfigPath, EnvData.class);
    }

    private String getCurrentEnvironment() {
        return ENVIRONMENT_CONFIG.getValue("/env").toString();
    }

    private <T> T deserializeJson(String filePath, Class<T> tClass) {
        try {
            return GSON.fromJson(new FileReader(filePath), tClass);
        } catch (FileNotFoundException e) {
            logger.error(String.format("Settings file %s not found or incorrect. Error msg: %s", filePath, e.getMessage()));
            throw new RuntimeException(e);
        }
    }
}
