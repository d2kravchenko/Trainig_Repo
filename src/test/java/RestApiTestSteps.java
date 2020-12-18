import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.PostModel;
import models.UserModel;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.Assert;
import utils.GenerateData;
import utils.JSONConverter;
import utils.SearchHelper;
import utils.SortHelper;
import utils.apiUtils.Request;

public class RestApiTestSteps {

    private static final ISettingsFile testData = new JsonSettingsFile("testData.json");
    private static final int EXISTING_POST_ID = (int) testData.getValue("/TestData/ExistingPost");
    private static final int NON_EXISTING_POST_ID = (int) testData.getValue("/TestData/NonExistingPost");
    private static final int EXISTING_USER_ID = (int) testData.getValue("/TestData/ExistingUser");
    private static final String EMPTY_JSON_BODY = "{}";
    private static final PostModel EXPECTED_RECEIVED_POST = JSONConverter.serializeJSONString(PostModel.class, testData.getValue("/ExpectedData/ExpectedNumberedPostExisting").toString());
    private static final UserModel EXPECTED_USER = JSONConverter.serializeJSONString(UserModel.class, testData.getValue("/ExpectedData/ExpectedUser").toString());
    private static final PostModel POSTING_POST = new PostModel(
            1,
            GenerateData.getRandomText(10, 25), //random text 10-25 symbols
            GenerateData.getRandomText(10, 25)  //random text 10-25 symbols
    );


    public static void allPostsTest(){

        AqualityServices.getLogger().info("Sending GET-request to receive all posts from %s", Endpoints.POSTS);
        AqualityServices.getLogger().info("Checking that status code is %d, format is JSON and list sorted natural by id", HttpStatus.SC_OK);
        ValidatableResponse vResponse = Request.get(Endpoints.POSTS.getValue())
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON);
        Assert.assertTrue(SortHelper.isSortedNaturalById(vResponse), "The list is not sorted correctly");
    }

    public static void existingPostTest(){
        AqualityServices.getLogger().info("Sending GET-request to receive #%d post (existing)", EXISTING_POST_ID);
        AqualityServices.getLogger().info("Checking that status code is %d, userId = %d, id = %d, title and body is not blank", HttpStatus.SC_OK, EXPECTED_RECEIVED_POST.getUserId(), EXPECTED_RECEIVED_POST.getId());
        Request.get(Endpoints.POSTS.format(String.valueOf(EXISTING_POST_ID)))
                .statusCode(HttpStatus.SC_OK).and()
                .body("userId", Matchers.is(EXPECTED_RECEIVED_POST.getUserId()))
                .body("id", Matchers.is(EXPECTED_RECEIVED_POST.getId()))
                .body("title", Matchers.not(Matchers.blankString()))
                .body("body", Matchers.not(Matchers.blankString()));
    }

    public static void nonExistingPostTest(){
        AqualityServices.getLogger().info("Sending GET-request to receive #%d post (non existing)", NON_EXISTING_POST_ID);
        AqualityServices.getLogger().info("Checking that status code is %d and JSON body is blank", HttpStatus.SC_NOT_FOUND);
        Request.get(Endpoints.POSTS.format(String.valueOf(NON_EXISTING_POST_ID)))
                .statusCode(HttpStatus.SC_NOT_FOUND).body(Matchers.is(EMPTY_JSON_BODY));
    }

    public static void postPostTest(){
        AqualityServices.getLogger().info("Sending POST-request to %s", Endpoints.POSTS);
        AqualityServices.getLogger().info("Checking that status code is %d, title, body and userId matches what we passed in the request, id is present in the response.", HttpStatus.SC_CREATED);
        Request.post(Endpoints.POSTS.getValue(), POSTING_POST)
                .statusCode(HttpStatus.SC_CREATED)
                .body("userId", Matchers.is(POSTING_POST.getUserId()))
                .body("id", Matchers.not(Matchers.blankOrNullString()))
                .body("title", Matchers.is(POSTING_POST.getTitle()))
                .body("body", Matchers.is(POSTING_POST.getBody()));
    }

    public static void allUsersAndIndividualUserTest(){
        AqualityServices.getLogger().info("Sending GET-request to receive all USERS from %s", Endpoints.users);
        AqualityServices.getLogger().info("Checking that status code is %d, format is JSON, title, body and userId matches what we passed in the request, id is present in the response.", HttpStatus.SC_OK);
        ValidatableResponse vResponse = Request.get(Endpoints.users.getValue())
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON);
        UserModel[] users = vResponse.extract().as(UserModel[].class);
        UserModel userFoundedFromAllUsers = SearchHelper.findUserById(users, EXISTING_USER_ID);
        Assert.assertEquals(userFoundedFromAllUsers, EXPECTED_USER, "<Users are not equal>");

        // step 6 is linked to step 5
        AqualityServices.getLogger().info("Sending GET-request to receive #%d User (existing)", EXISTING_USER_ID);
        AqualityServices.getLogger().info("Checking that status code is %d and User data matches the data obtained previously.", HttpStatus.SC_OK);
        vResponse = Request.get(Endpoints.users.format(String.valueOf(EXISTING_USER_ID)))
                .statusCode(HttpStatus.SC_OK);
        UserModel userFoundedDirectly = vResponse.extract().as(UserModel.class);
        Assert.assertEquals(userFoundedDirectly, userFoundedFromAllUsers, "<Users are not equal>");
    }
}
