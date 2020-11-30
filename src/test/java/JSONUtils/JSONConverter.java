package JSONUtils;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.logging.Logger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


public class JSONConverter {

    private static final Logger logger = AqualityServices.getLogger();

    public static <T> T serializeJSONString(Class c, String inline) {

        ObjectMapper objectMapper = new ObjectMapper();
        T obj;
        try { obj = (T) objectMapper.readValue(inline, c); }
        catch (IOException e) {
            logger.warn(e.getMessage());
            return null;                  }
        return obj;
    }



}
