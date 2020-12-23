package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class TimerForm extends Form {

    public TimerForm() {
        super(By.xpath("//div[@class = 'timer timer--white timer--center']"), "Timer Form");
    }

    private final ILabel TimerLabel = AqualityServices.getElementFactory().getLabel(this.getLocator(), "Timer Label");

    public String getTimerValue() {
        return TimerLabel.getText();
    }
}




