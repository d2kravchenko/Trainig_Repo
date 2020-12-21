package screenobjects;

import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import models.ItemModel;
import models.SellerModel;
import org.openqa.selenium.By;
import screenobjects.constants.Attribute;
import utils.StringHelper;

public class ItemScreen extends Screen {
    public ItemScreen(){
        super(By.id("rlBasicInfo"), "Item screen");
    }
    private final String ID_ITEM_BRAND_LABEL = "tvItemBrand";
    private final String ID_NEW_PRICE_LABEL = "tvAdditionalPrice";
    private final String ID_OLD_PRICE_LABEL = "tvAdditionalOriginal";
    private final String ID_DISCOUNT_PERCENT_LABEL = "tvAdditionalDiscount";
    private final String ID_SELLER_NAME_LABEL = "tvItemSellerName";
    private final String ID_SELLER_CITY_LABEL = "tvItemSellerCity";

    private final ILabel itemBrandLabel = AqualityServices.getElementFactory().getLabel(By.id(ID_ITEM_BRAND_LABEL), "Item name label");
    private final ILabel newPriceLabel = AqualityServices.getElementFactory().getLabel(By.id(ID_NEW_PRICE_LABEL), "New price label");
    private final ILabel oldPriceLabel = AqualityServices.getElementFactory().getLabel(By.id(ID_OLD_PRICE_LABEL), "Old price label");
    private final ILabel discountPercentLabel = AqualityServices.getElementFactory().getLabel(By.id(ID_DISCOUNT_PERCENT_LABEL), "Discount % label");
    private final ILabel sellerNameLabel = AqualityServices.getElementFactory().getLabel(By.id(ID_SELLER_NAME_LABEL), "Seller Name label");
    private final ILabel sellerCityLabel = AqualityServices.getElementFactory().getLabel(By.id(ID_SELLER_CITY_LABEL), "Seller City label");

    public ItemModel parseItemData(){
        ItemModel item = new ItemModel();
        item.setBrand(itemBrandLabel.getAttribute(Attribute.TEXT.getValue()));
        discountPercentLabel.getTouchActions().scrollToElement(SwipeDirection.DOWN);
        String newPrice = newPriceLabel.getAttribute(Attribute.TEXT.getValue());    // String is like "Price: 9999 USD"
        item.setNewPrice(StringHelper.removeAllBeforeDigits(newPrice)); // Remove any chars before digits
        item.setOldPrice(oldPriceLabel.getAttribute(Attribute.TEXT.getValue()));
        item.setDiscount(discountPercentLabel.getAttribute(Attribute.TEXT.getValue()));
        return item;
    }
    public SellerModel parseSellerData(){
        sellerNameLabel.getTouchActions().scrollToElement(SwipeDirection.UP);
        SellerModel seller = new SellerModel();
        seller.setName(sellerNameLabel.getAttribute(Attribute.TEXT.getValue()));
        seller.setCity(sellerCityLabel.getAttribute(Attribute.TEXT.getValue()));
        return seller;
    }

    public void selectSeller(){
        sellerNameLabel.getTouchActions().scrollToElement(SwipeDirection.UP);
        sellerNameLabel.click();
    }


}
