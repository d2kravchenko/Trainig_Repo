package utils;

import com.google.common.collect.Ordering;
import io.restassured.response.ValidatableResponse;

import java.util.List;

public class SortHelper {

    private static final String NODE_ID = "id";

    public static boolean isSortedNaturalById(ValidatableResponse vResponse){
        List<Integer> jsonResponse = vResponse.extract().response().jsonPath().getList(NODE_ID);
        return Ordering.natural().isOrdered(jsonResponse);
    }
}
