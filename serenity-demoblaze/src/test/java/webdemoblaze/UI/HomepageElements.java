package webdemoblaze.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.annotations.findby.By;

public class HomepageElements {
    public static final Target MENU_REGISTRO = Target.the("Sign Up menu").located(By.id("signin2"));
    public static final Target MENU_INGRESO = Target.the("Log In menu").located(By.id("login2"));
    public static final Target MENU_SALIR = Target.the("Log Out menu").located(By.id("logout2"));
    public static final Target NOMBRE_USUARIO = Target.the("Nombre de usuario").located(By.xpath("//a[contains(text(), 'Welcome')]"));
    public static final Target CARRUSEL = Target.the("slider carousel").located(By.id("carouselExampleIndicators"));
    public static final Target MARCA = Target.the("Logo del sitio").located(By.xpath("//a[@class='navbar-brand']"));
} 