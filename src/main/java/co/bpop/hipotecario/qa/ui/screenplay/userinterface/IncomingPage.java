package co.bpop.hipotecario.qa.ui.screenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class IncomingPage {
    public static final Target DROPDOWN_LIST_CLICK = Target.the("A que se dedica - Tipo Contrato - Convenio")
        .locatedBy("(//span[@class='dropdown-module_name__VyJ9q'])[{0}]"); //1, 2, 3
    public static final Target ACTIVITY_LIST = Target.the("Actividad principal y tipo contrato")
        .locatedBy("//div[@class='dropdown-module_expanded-content__EK1-k']//child::span[contains(text(),'{0}')]");
    public static final Target CONTRACT_CONV_LIST = Target.the("Listas de convenio")
        .locatedBy("//div[@class='dropdown-module_expanded-section__zbZr3']//child::span[contains(text(),'{0}')]");
    public static final Target INCOMING_MONTH_TEXT = Target.the("Ingresos mensuales")
        .located(By.id("income-amount"));
    public static final Target AFILIATE_CHECKBOX = Target.the("Afiliacion porvenir")
        .locatedBy("(//span[@class='radio-button-module_control-wrapper__3cwuc']/child::span)[{0}]"); //1No-2Si
    public static final Target CASAYA_CHECKBOX = Target.the("Combo Casayá")
            .locatedBy("(//span[@class='radio-button-module_control-wrapper__3cwuc']/child::span)[{0}]"); //1No-2Si
    public static final Target CONTINUE_BUTTON = Target.the("Continuar")
        .located(By.tagName("button"));

    private IncomingPage(){}
}
