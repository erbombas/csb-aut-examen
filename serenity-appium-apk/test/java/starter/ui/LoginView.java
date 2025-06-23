package starter.ui;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class LoginView {

    public static Target TITLE = Target.the("title")
            .located(By.xpath("//android.widget.ScrollView[@content-desc='test-Login']/android.view.ViewGroup/android.widget.ImageView[1]"));

    public static  Target USERNAME = Target.the("username")
            .located(AppiumBy.accessibilityId("test-Username"));

    public static Target PASSWORD = Target.the("pasword")
            .located(AppiumBy.accessibilityId("test-Password"));

    public static Target BUTTON = Target.the("login button")
            .located(By.xpath("//android.widget.TextView[@text='LOGIN']"));
}