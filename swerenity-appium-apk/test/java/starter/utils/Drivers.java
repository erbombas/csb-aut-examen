package starter.utils;

import io.appium.java_client.android.AndroidDriver;
import net.thucydides.core.webdriver.WebDriverFacade;

import static net.serenitybdd.core.Serenity.getDriver;

public class Drivers {

    private Drivers() {
    }

    public static AndroidDriver getAndroidDriver(){
        return ((AndroidDriver) ((WebDriverFacade) getDriver()).getProxiedDriver());
    }
}
