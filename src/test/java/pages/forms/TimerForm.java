package pages.forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class TimerForm extends Form {

    public TimerForm() {
        super(By.xpath("//div[@class = 'timer timer--white timer--center']"), "Timer Form");
    }

    private static final String XPATH_TIMER_LABEL = "//div[@class = 'timer timer--white timer--center']";
    private static final ILabel TimerLabel = AqualityServices.getElementFactory().getLabel(By.xpath(XPATH_TIMER_LABEL), "Timer Label");

    public static String getTimerValue() {
        return TimerLabel.getText();
    }
}




