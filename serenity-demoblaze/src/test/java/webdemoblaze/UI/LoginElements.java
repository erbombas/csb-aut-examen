package webdemoblaze.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.annotations.findby.By;

public class LoginElements {
    public static final Target USUARIO_INGRESO = Target.the("Input de username").located(By.id("loginusername"));
    public static final Target CLAVE_INGRESO = Target.the("Input de password").located(By.id("loginpassword"));                  
    public static final Target BOTON_INGRESO = Target.the("Boton de login").located(By.xpath("//button[contains(text(), 'Log in')]"));
} 