package webdemoblaze.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.annotations.findby.By;

public class ProductElements {
    public static final Target PRODUCTO = Target.the("Producto").located(By.xpath("//a[contains(text(), 'Samsung galaxy s6')]"));
    public static final Target ETIQUETA = Target.the("Label").located(By.xpath("//*[@id=\"more-information\"]/strong"));
} 