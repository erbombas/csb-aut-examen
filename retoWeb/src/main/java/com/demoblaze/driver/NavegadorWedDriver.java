package com.demoblaze.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NavegadorWedDriver {

    private  static WebDriver driver;

    public static NavegadorWedDriver chromeHisBrowserWeb() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-infobars");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        return new NavegadorWedDriver();
    }

    public WebDriver on(String url) {
        if (driver == null) {
            throw new IllegalStateException("El WebDriver no ha sido inicializado correctamente.");
        }
        driver.get(url);
        return driver;
    }

}
