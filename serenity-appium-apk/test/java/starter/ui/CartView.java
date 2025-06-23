package starter.ui;

import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;


public class CartView {

    public static Target PRODUCT_CART(String productName) {
        return Target.the("product_cart" + productName)
                .located(By.xpath("//android.view.ViewGroup[@content-desc='test-Item' and .//android.widget.TextView[@text='" + productName + "']]"));
    }

    public static Target PRODUCT_PRICE(String productName) {
        return Target.the("product_price" + productName)
                .located(By.xpath("//android.view.ViewGroup[@content-desc='test-Item' and .//android.widget.TextView[@text='" + productName + "']]//android.widget.TextView[contains(@text, '$')]"));
    }

    public static Target REMOVE_BUTTON(String productName) {
        return Target.the("remove_button " + productName)
                .located(By.xpath("//android.view.ViewGroup[@content-desc='test-Item' and .//*[@text='" + productName + "']]//android.widget.TextView[@text='REMOVE']"));
    }

    public static Target EMPTY_CART = Target.the("empty_cart")
            .located(By.xpath("//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.ImageView"));
}
