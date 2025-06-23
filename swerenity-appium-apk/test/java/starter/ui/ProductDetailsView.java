package starter.ui;

import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;


public class ProductDetailsView {

    public static Target ADD_TO_CART = Target.the("add_to_car")
            .located(By.xpath("//android.view.ViewGroup[@content-desc='test-ADD TO CART']"));

}
