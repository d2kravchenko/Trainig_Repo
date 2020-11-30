import Configuration.*;
import Models.mPost;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class EndPoints {


    private static final String BaseUrl = (String) TestConfig.getConfig("/Url");
    public static final String posts = BaseUrl + "/posts";
    public static final String users = BaseUrl + "/users";
    public static final String postNumbered = BaseUrl + "/posts/";
    public static final String userNumbered = BaseUrl + "/users/";


    public static Response getAllPosts(){
        return when().get(EndPoints.posts).then().extract().response();
    }
    public static Response getAllUsers(){
        return when().get(EndPoints.users).then().extract().response();
    }

    public static Response getPost(int postId){
        return when().get(EndPoints.postNumbered+postId).then().extract().response();
    }
    public static Response getUser(int userId){
        return when().get(EndPoints.userNumbered + userId).then().extract().response();
    }

    public static Response postPost(mPost post){
       return given().contentType("application/json").body(post).when().post(posts).then().extract().response();
    }

}
