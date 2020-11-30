import Configuration.TestConfig;
import Generators.GenerateData;
import JSONUtils.JSONConverter;
import Models.mPost;
import Models.mUser;
import aquality.selenium.browser.AqualityServices;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApITest {

   private final int existingPostId = (int) TestConfig.getTestData("/TestData/ExistingPost/id");
   private final int nonExistingPostId = (int) TestConfig.getTestData("/TestData/NonExistingPost/id");
   private final int existingUserId = (int) TestConfig.getTestData("/TestData/ExistingUser/id");
   private final String emptyJsonBody = "{}";
   private Response response;
   private final mPost expectedReceivedPost = JSONConverter.serializeJSONString(mPost.class, (String) TestConfig.getTestData("/ExpectedData/ExpectedNumberedPostExisting"));
    private final mPost postingPost = new mPost(
            1,
            GenerateData.getRandomText(10, 25), //random text 10-25 symbols
            GenerateData.getRandomText(10, 25)  //random text 10-25 symbols
    );
   private final mUser expectedUser = JSONConverter.serializeJSONString(mUser.class, (String) TestConfig.getTestData("/ExpectedData/ExpectedUser"));




    @Test
    public void apiTest(){
        AqualityServices.getLogger().info("Starting RestAPI test with RestAssured");

        AqualityServices.getLogger().info("Sending GET-request to receive all posts from " + EndPoints.posts);
        response = EndPoints.getAllPosts();
        AqualityServices.getLogger().info("Asserting that status code is 200 and format is JSON");
        response.then().statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON);
        AqualityServices.getLogger().info("Asserting that JSON list sorted by ID");
        Assert.assertTrue(Steps.isSortedNaturalById(response), "List is not sorted by id");

        AqualityServices.getLogger().info("Sending GET-request to receive #" + existingPostId + " post (existing)");
        response = EndPoints.getPost(existingPostId);
        AqualityServices.getLogger().info("Asserting that status code is 200");
        response.then().statusCode(HttpStatus.SC_OK);
        mPost receivedPost = response.as(mPost.class);
        AqualityServices.getLogger().info("Asserting that Posts UserID and Id is equal to expected, and Title and Body fields is not empty");
        Assert.assertEquals(receivedPost.getUserId(), expectedReceivedPost.getUserId(), "<UserId are not equal>");
        Assert.assertEquals(receivedPost.getId(), expectedReceivedPost.getId(), "<Id are not equal>");
        Assert.assertFalse(receivedPost.getTitle().isEmpty(), "<Title is empty>");
        Assert.assertFalse(receivedPost.getBody().isEmpty(), "<Body is empty>");

        AqualityServices.getLogger().info("Sending GET-request to receive #" + nonExistingPostId + " post (non existing)");
        response = EndPoints.getPost(nonExistingPostId);
        AqualityServices.getLogger().info("Asserting that status code is 404");
        response.then().statusCode(HttpStatus.SC_NOT_FOUND);
        AqualityServices.getLogger().info("Asserting that response body is empty \"{}\"");
        Assert.assertEquals(response.body().asString(), emptyJsonBody, "<Response body is not \"{}\". It is " + response.body().asString() + ">");

        AqualityServices.getLogger().info("Sending POST-request to " + EndPoints.posts);
        response = EndPoints.postPost(postingPost);
        AqualityServices.getLogger().info("Asserting that status code is 201");
        response.then().statusCode(HttpStatus.SC_CREATED);
        mPost returnedPost = response.as(mPost.class);
        AqualityServices.getLogger().info("Asserting that Returned Post Object is equal to Posted Post Object by UserID, title and body");
        Assert.assertEquals(postingPost.getTitle(), returnedPost.getTitle(), "<Titles are not equal>");
        Assert.assertEquals(postingPost.getBody(), returnedPost.getBody(), "<Bodies are not equal>");
        Assert.assertEquals(postingPost.getUserId(), returnedPost.getUserId(), "<User id's are not equal>");
        Assert.assertTrue(String.valueOf(returnedPost.getId()).length() > 0, "<Something wrong with id>");

        AqualityServices.getLogger().info("Sending GET-request to receive all users from " + EndPoints.users);
        response = EndPoints.getAllUsers();
        AqualityServices.getLogger().info("Asserting that status code is 200 and format is JSON");
        response.then().statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON);
        mUser[] users = response.as(mUser[].class);
        AqualityServices.getLogger().info("Find User by id=" + existingUserId + " from All Users");
        mUser user = Steps.findUserById(users, existingUserId);
        AqualityServices.getLogger().info("Asserting that founded User is equal to Expected User");
        Assert.assertEquals(user, expectedUser, "<Users are not equal>");

        AqualityServices.getLogger().info("Sending GET-request to receive #" + existingUserId + " User (existing)");
        response = EndPoints.getUser(existingUserId);
        AqualityServices.getLogger().info("Asserting that status code is 200");
        response.then().statusCode(HttpStatus.SC_OK);
        mUser individualUser = response.as(mUser.class);
        AqualityServices.getLogger().info("Asserting that User #"+existingUserId+" founded in " + EndPoints.users + " are equal to User received from " + EndPoints.userNumbered + existingUserId);
        Assert.assertEquals(user, individualUser, "<Users are not equal>");
    }
}

