package webdemoblaze.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.annotations.findby.By;

public class SignUpElements {
    public static final Target USUARIO_REGISTRO = Target.the("Input de username").located(By.id("sign-username"));
    public static final Target CLAVE_REGISTRO = Target.the("Input de password").located(By.id("sign-password"));    
    public static final Target BOTON_REGISTRO = Target.the("Boton de signup").located(By.xpath("//button[contains(text(), 'Sign up')]"));
} 