package starter.ui;

import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

public class MenuView {

    public static Target MENU_BUTTON = Target.the("menu_button")
            .located(By.xpath("//android.view.ViewGroup[@content-desc='test-Menu']/android.view.ViewGroup/android.widget.ImageView"));

    public static Target ABOUT = Target.the("About")
            .located(By.xpath(""));

    public static Target SWAG_LABS_SECTION = Target.the("Swag_Labs_section")
            .located(By.xpath(""));

    public static Target LOGOUT_BUTTON = Target.the("logout_button")
            .located(By.xpath(""));
}
