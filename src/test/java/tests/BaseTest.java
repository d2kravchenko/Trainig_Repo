package tests;

import configuration.TestConfig;
import tests.steps.LoginSteps;
import utils.GenerateData;
import screenobjects.loginscreenobjects.LoginScreen;
import aquality.appium.mobile.application.AqualityServices;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

    protected static final String LOGIN_SERVER_NAME = (String) TestConfig.getTestConfig("/Credentials/Server");
    protected static final String LOGIN_EMAIL = (String) TestConfig.getTestConfig("/Credentials/Email");
    protected static final String LOGIN_PASSWORD = (String) TestConfig.getTestConfig("/Credentials/Password");
    protected static final int TEXT_EDITOR_MAXIMUM_OPEN_DURATION = (int) TestConfig.getTestData("/TEXT_EDITOR_MAXIMUM_OPEN_DURATION");
    protected static final String EXPECTED_FILE_NAME = (String) TestConfig.getTestData("/EXPECTED_FILE_NAME");
    protected static final String EXPECTED_FILE_TEXT = (String) TestConfig.getTestData("/EXPECTED_FILE_TEXT");
    protected static String GENERATED_TEXT_DOCUMENT_NAME = GenerateData.getRandomText(3, 10);
    protected static String GENERATED_TEXT_DOCUMENT_BODY = GenerateData.getRandomText(10, 20);

    @BeforeTest
    public void beforeTest(){
        LoginScreen loginScreen = new LoginScreen();
        if (loginScreen.isLoginScreenDisplayed()) {
            AqualityServices.getLogger().info("Pre-test condition: login");
            LoginSteps.login(LOGIN_SERVER_NAME, LOGIN_EMAIL, LOGIN_PASSWORD);
        }
    }

    @AfterTest
    public void afterTest(){
        AqualityServices.getApplication().getDriver().quit();
    }
}
