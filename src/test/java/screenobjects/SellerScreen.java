package screenobjects;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import models.SellerModel;
import org.openqa.selenium.By;
import screenobjects.constants.Attribute;

public class SellerScreen extends Screen {
    public SellerScreen(){
        super(By.id("tvItemSellerID"), "Seller screen");
    }

    private final String XPATH_DYNAMIC_SELLER_NAME_LABEL = "//android.widget.TextView[@text = '%s']";
    private final String ID_SELLER_CITY_LABEL = "tvItemSellerCity";

   private final ILabel sellerCityLabel = AqualityServices.getElementFactory().getLabel(By.id(ID_SELLER_CITY_LABEL), "Seller City label");

    private ILabel getSellerNameLabel(String name){
        return AqualityServices.getElementFactory().getLabel(By.xpath(String.format(XPATH_DYNAMIC_SELLER_NAME_LABEL, name)), "Seller " + name);
    }

    public boolean isSellerDataCorrect(SellerModel expectedSeller){
        return sellerCityLabel.getAttribute(Attribute.TEXT.getValue()).equals(expectedSeller.getCity()) && getSellerNameLabel(expectedSeller.getName()).state().isExist();
    }

}
