package webdemoblaze.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.annotations.findby.By;

public class CategoryElements {
    public static final Target CATEGORIA = Target.the("Categoria").located(By.xpath("//a[contains(text(), 'Phones')]"));
} 