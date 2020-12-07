import configuration.TestConfig;
import utils.GenerateData;
import screenObjects.loginScreenObjects.LoginScreen;
import aquality.appium.mobile.application.AqualityServices;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

    protected final String LOGIN_SERVER_NAME = (String) TestConfig.getTestConfig("/Credentials/Server");
    protected final String LOGIN_EMAIL = (String) TestConfig.getTestConfig("/Credentials/Email");
    protected final String LOGIN_PASSWORD = (String) TestConfig.getTestConfig("/Credentials/Password");
    protected final int TEXT_EDITOR_MAXIMUM_OPEN_DURATION = (int) TestConfig.getTestData("/TEXT_EDITOR_MAXIMUM_OPEN_DURATION");
    protected final String EXPECTED_FILE_NAME = (String) TestConfig.getTestData("/EXPECTED_FILE_NAME");
    protected final String EXPECTED_FILE_TEXT = (String) TestConfig.getTestData("/EXPECTED_FILE_TEXT");
    protected String GENERATED_TEXT_DOCUMENT_NAME = GenerateData.getRandomText(3, 10);
    protected String GENERATED_TEXT_DOCUMENT_BODY = GenerateData.getRandomText(10, 20);

    @BeforeTest
    public void beforeTest(){
        GENERATED_TEXT_DOCUMENT_NAME = GenerateData.getRandomText(3, 10);   //Renew random generated file name to different tests
        GENERATED_TEXT_DOCUMENT_BODY = GenerateData.getRandomText(10, 20);  //Renew random generated file body to different tests
        LoginScreen loginScreen = new LoginScreen();
        if (loginScreen.isLoginScreenDisplayed()) {
            AqualityServices.getLogger().info("Pre-test condition: login");
            Steps.login(LOGIN_SERVER_NAME, LOGIN_EMAIL, LOGIN_PASSWORD);
        }
    }

    @AfterTest
    public void afterTest(){
        AqualityServices.getApplication().getDriver().quit();
    }
}
