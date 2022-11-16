package co.bpop.hipotecario.qa.ui.screenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class NotPreapprovalPage {
    public static final Target NOTPREAPPROVAL_TITTLE = Target.the("Titulo de no aprobacion")
        .locatedBy("//h6");
    public static final Target END_BUTTON = Target.the("Boton de finalizar")
        .located(By.xpath("//button"));
}
