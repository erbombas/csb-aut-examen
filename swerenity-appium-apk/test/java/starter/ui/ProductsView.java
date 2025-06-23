package starter.ui;

import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;


public class ProductsView {

    public static Target PRODUCT_LIST = Target.the("product_list")
            .located(By.xpath("//android.widget.ScrollView[@content-desc='test-PRODUCTS']/android.view.ViewGroup/android.view.ViewGroup[1]"));

    public static Target PRODUCT(String productName) {
        return Target.the("product " + productName)
                .located(By.xpath("//android.view.ViewGroup[@content-desc='test-Item' and .//android.widget.TextView[@text='" + productName + "']]"));
    }


    public static Target CART = Target.the("cart")
            .located(By.xpath("(//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.ImageView]"));
}
