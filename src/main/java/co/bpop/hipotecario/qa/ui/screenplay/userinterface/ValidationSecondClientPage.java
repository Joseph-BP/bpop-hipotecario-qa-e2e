package co.bpop.hipotecario.qa.ui.screenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ValidationSecondClientPage {
    public static final Target SECOND_CLIENT_CHECKBOX = Target.the("Suma ingresos con otra persona")
        .locatedBy("(//div[@class='radios']/label)[{0}]");
    public static final Target RELATION_FIRST_CLIENTE_CLICK = Target.the("Parentesco o afinidad con primer cliente")
        .locatedBy("(//div[@id='dropdown-element']/div)[1]");
    public static final Target RELATION_FIRST_CLIENT_LIST = Target.the("Lista de parentescos a seleccionar")
        .locatedBy("//span[contains(text(),'{0}')]");
    public static final Target CONTINUE_BUTTON = Target.the("Continuar")
        .located(By.tagName("button"));

    private ValidationSecondClientPage(){}
}
