package configuration;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class TestConfig {

    private static final JsonSettingsFile TestConfig = new JsonSettingsFile("TestConfig.json");
    private static final JsonSettingsFile TestRailConfig = new JsonSettingsFile("TestRailConfig.json");

    public static Object getTestConfig(String jsonPath) {
        return TestConfig.getValue(jsonPath);
    }
    public static Object getTestRailConfig(String jsonPath) {
        return TestRailConfig.getValue(jsonPath);
    }


}
