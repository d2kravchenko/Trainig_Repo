package utils.allureutils.listeners;

import utils.allureutils.AllureHelper;
import aquality.selenium.browser.AqualityServices;
import com.google.common.collect.ImmutableMap;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListener implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        AllureHelper.allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", AqualityServices.getBrowser().getBrowserName().toString())
                        .build());
        AllureHelper.copyAllureCategories();
    }
}


