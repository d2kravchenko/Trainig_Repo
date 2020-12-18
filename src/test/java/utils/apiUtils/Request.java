package utils.apiUtils;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class Request {

    private static final ISettingsFile testConfig = new JsonSettingsFile("testConfig.json");
    private static final String BASE_URI = (String) testConfig.getValue("/Url");


    /* ***********************
    Args order: Endpoint, id.
    *************************/
    public static ValidatableResponse get(String... args){
        String endpoint;
        String id;

        switch (args.length) {
            case 1:
                endpoint = args[0];
                return given().baseUri(BASE_URI).get(endpoint).then();
            case 2:
                endpoint = args[0];
                id = args[1];
                return given().baseUri(BASE_URI).pathParam("id", id).get(endpoint + "/{id}").then();
            default:
                throw new IllegalStateException("Unexpected argument count: " + args.length);
        }
    }

    public static ValidatableResponse post(String endpoint, Object object){
        return given().baseUri(BASE_URI).contentType(ContentType.JSON).body(object).post(endpoint).then();
    }

}
