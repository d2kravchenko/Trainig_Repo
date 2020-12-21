package utils;

import aquality.selenium.browser.AqualityServices;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JSONConverter {

    public static <T> T serializeJSONString(Class c, String inline) {

        ObjectMapper objectMapper = new ObjectMapper();
        T obj;
        try { obj = (T) objectMapper.readValue(inline, c); }
        catch (IOException e) {
            AqualityServices.getLogger().warn(e.getMessage());
            return null;                  }
        return obj;
    }



}
