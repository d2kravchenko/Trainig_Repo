package Configuration;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class TestConfig {

    private static final JsonSettingsFile jsonConfig = new JsonSettingsFile("Config.json");
    private static final JsonSettingsFile jsonTestData = new JsonSettingsFile("TestData.json");

    public static Object getConfig(String jsonPath) {
        return jsonConfig.getValue(jsonPath);
    }
    public static Object getTestData(String jsonPath) {
        return jsonTestData.getValue(jsonPath);
    }


}
