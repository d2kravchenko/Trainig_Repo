import aquality.selenium.browser.AqualityServices;
import org.testng.annotations.Test;
import steps.RestApiTestSteps;

public class RestApiTest {


    @Test
    public void apiTest(){
        AqualityServices.getLogger().info("Starting RESTAssured API test");
        RestApiTestSteps.allPostsTest();
        RestApiTestSteps.existingPostTest();
        RestApiTestSteps.nonExistingPostTest();
        RestApiTestSteps.postPostTest();
        RestApiTestSteps.allUsersAndIndividualUserTest();
    }
}

