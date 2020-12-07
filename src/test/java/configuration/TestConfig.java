package configuration;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class TestConfig {

    private static final JsonSettingsFile TestConfig = new JsonSettingsFile("TestConfig.json");
    private static final JsonSettingsFile TestData = new JsonSettingsFile("TestData.json");

    public static Object getTestConfig(String jsonPath) {
        return TestConfig.getValue(jsonPath);
    }
    public static Object getTestData(String jsonPath) { return TestData.getValue(jsonPath); }
}
