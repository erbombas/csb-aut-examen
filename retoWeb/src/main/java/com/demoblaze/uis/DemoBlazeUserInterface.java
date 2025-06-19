package com.demoblaze.uis;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class DemoBlazeUserInterface {
    public static final Target BTN_SIGN_UP = Target.the("Botón de Registro").located(By.xpath("//a[@id='signin2']"));
    public static final Target BTN_LOG_IN = Target.the("Botón de Login").located(By.xpath("//a[@id='login2']"));
    public static final Target TXT_USERNAME = Target.the("Campo texto de usuario").located(By.xpath("//input[@id='sign-username']"));
    public static final Target TXT_PASSWORD = Target.the("Campo texto de contraseña").located(By.xpath("//input[@id='sign-password']"));
    public static final Target BTN_REGISTRO = Target.the("Boton de Registro").located(By.xpath("//button[@onclick='register()']"));
    public static final Target TXT_LOGIN_USERNAME = Target.the("Boton de Registro").located(By.xpath("//input[@id='loginusername']"));
    public static final Target TXT_LOGIN_PASSWORD = Target.the("Boton de Registro").located(By.xpath("//input[@id='loginpassword']"));
    public static final Target BTN_LOGIN = Target.the("Boton de Registro").located(By.xpath("//button[@onclick='logIn()']"));
    public static final Target TXT_NAME_USERNAME = Target.the("Boton de Registro").located(By.xpath("//a[@id='nameofuser']"));
    public static final Target BTN_CATEGORY = Target.the("Boton de Registro").locatedBy("//a[contains(text(),'{0}')]");
    public static final Target BTN_PRODUCT = Target.the("Boton de Registro").locatedBy("//a[contains(text(),'{0}')]");
    public static final Target TXT_TITLE_DESCRIPCION = Target.the("Boton de Registro").locatedBy("//strong");
    public static final Target BTN_ADD_CART = Target.the("Boton de Registro").locatedBy("//a[@onclick='addToCart(1)']");
    public static final Target BTN_CART = Target.the("Boton de Registro").locatedBy("//a[@id='cartur']");
    public static final Target TXT_PRODUCT_CART = Target.the("Boton de Registro").locatedBy("//td[contains(text(),'{0}')]");
    public static final Target BTN_DELETE_PRODUCT = Target.the("Boton de Registro").locatedBy("//td[contains(text(),'{0}')]//following-sibling::td//a");


}
