package utils;

import aquality.appium.mobile.application.AqualityServices;
import com.google.common.collect.ImmutableMap;

public class ScriptHelper {
    public static void acceptFormWithScript(){
        AqualityServices.getApplication().getDriver().executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
    }
}
