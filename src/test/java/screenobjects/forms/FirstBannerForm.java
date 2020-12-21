package screenobjects.forms;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import models.ItemModel;
import org.openqa.selenium.By;
import screenobjects.constants.Attribute;

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

    public ItemModel parseFirstItemData(){
        ItemModel firstItem = new ItemModel();
        firstItem.setBrand(itemBrandLabel.getAttribute(Attribute.TEXT.getValue()));
        firstItem.setOldPrice(oldPriceLabel.getAttribute(Attribute.TEXT.getValue()));
        firstItem.setNewPrice(newPriceLabel.getAttribute(Attribute.TEXT.getValue()));
        firstItem.setDiscount(discountPercentLabel.getAttribute(Attribute.TEXT.getValue()));
        return firstItem;
    }

    public void selectItem(){
        baseLabel.click();
    }
}
