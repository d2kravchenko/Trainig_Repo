package utils;

import com.google.common.collect.Ordering;
import io.restassured.response.ValidatableResponse;

import java.util.List;

public class SortHelper {

    public static boolean isSortedNaturalById(ValidatableResponse vResponse){
        List<Integer> jsonResponse = vResponse.extract().response().jsonPath().getList("id");
        return Ordering.natural().isOrdered(jsonResponse);
    }
}
