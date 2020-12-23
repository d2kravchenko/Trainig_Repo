package tests;

import configuration.TestConfig;
import aquality.selenium.browser.AqualityServices;
import org.testng.annotations.*;



public class BaseTest {

    protected static final String HOMEPAGE = TestConfig.getTestConfig("/Url/Homepage").toString();

    @BeforeTest
    public static void setUp(){
        AqualityServices.getBrowser().maximize();
    }

    @AfterTest
    public static void closeBrowser()  {
        AqualityServices.getBrowser().quit();
    }


}
