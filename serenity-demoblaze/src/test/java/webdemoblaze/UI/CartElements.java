package webdemoblaze.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.annotations.findby.By;

public class CartElements {
    public static final Target AGREGAR_CARRITO = Target.the("Boton de add to cart").located(By.xpath("//a[contains(text(), 'Add to cart')]"));
    public static final Target VENTANA = Target.the("Modal").located(By.xpath("//div[contains(text(), 'Product added')]"));
    public static final Target CARRITO = Target.the("Carrito de compras").located(By.cssSelector("#navbarExample > ul > li:nth-child(4) > a"));
    public static final Target PRODUCTO_CARRITO = Target.the("Producto en el carrito").located(By.xpath("//*[@id=\"tbodyid\"]/tr"));
    public static final Target ELIMINAR = Target.the("Boton de delete").located(By.xpath("//a[contains(text(), 'Delete')]"));
} 