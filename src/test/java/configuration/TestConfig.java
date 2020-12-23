package configuration;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class TestConfig {

    private static final JsonSettingsFile TestConfig = new JsonSettingsFile("testconfig.json");

    public static Object getTestConfig(String jsonPath) {
        return TestConfig.getValue(jsonPath);
    }
 }
