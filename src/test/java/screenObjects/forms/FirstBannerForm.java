package screenObjects.forms;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import models.MItem;
import org.openqa.selenium.By;
import screenObjects.ATTRIBUTE;

public class FirstBannerForm extends Screen {
    public FirstBannerForm(){
        super(By.id("rlBanner"), "First Banner with discount");
    }

    private final String ID_OLD_PRICE_LABEL = "tvSumm";
    private final String ID_NEW_PRICE_LABEL = "tvPrice";
    private final String ID_DISCOUNT_PERCENT_LABEL = "tvDiscount";
    private final String ID_ITEM_BRAND_LABEL = "tvBrand";

    private final ILabel baseLabel = AqualityServices.getElementFactory().getLabel(this.getLocator(), "Base Label");
    private final ILabel oldPriceLabel = baseLabel.findChildElement(By.id(ID_OLD_PRICE_LABEL), "Old price label", ILabel.class);
    private final ILabel newPriceLabel = baseLabel.findChildElement(By.id(ID_NEW_PRICE_LABEL), "New price label", ILabel.class);
    private final ILabel discountPercentLabel = baseLabel.findChildElement(By.id(ID_DISCOUNT_PERCENT_LABEL), "Discount % label", ILabel.class);
    private final ILabel itemBrandLabel = baseLabel.findChildElement(By.id(ID_ITEM_BRAND_LABEL), "Item name label", ILabel.class);

    public MItem parseFirstItemData(){
        MItem firstItem = new MItem();
        firstItem.setBrand(itemBrandLabel.getAttribute(ATTRIBUTE.TEXT));
        firstItem.setOldPrice(oldPriceLabel.getAttribute(ATTRIBUTE.TEXT));
        firstItem.setNewPrice(newPriceLabel.getAttribute(ATTRIBUTE.TEXT));
        firstItem.setDiscount(discountPercentLabel.getAttribute(ATTRIBUTE.TEXT));
        return firstItem;
    }

    public void selectItem(){
        baseLabel.click();
    }
}
