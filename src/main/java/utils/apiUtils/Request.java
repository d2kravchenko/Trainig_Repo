package utils.apiUtils;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class Request {

    private static final ISettingsFile testConfig = new JsonSettingsFile("testConfig.json");
    private static final String BASE_URI = (String) testConfig.getValue("/Url");


   public static ValidatableResponse get(String endpoints){
                return given().baseUri(BASE_URI).get(endpoints).then();
    }

    public static ValidatableResponse post(String endpoint, Object object){
        return given().baseUri(BASE_URI).contentType(ContentType.JSON).body(object).post(endpoint).then();
    }

}
