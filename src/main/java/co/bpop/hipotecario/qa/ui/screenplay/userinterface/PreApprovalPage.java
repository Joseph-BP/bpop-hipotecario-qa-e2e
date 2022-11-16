package co.bpop.hipotecario.qa.ui.screenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PreApprovalPage {
    public static final Target TITTLE_PREAPROBACION = Target.the("Titulo final")
        .locatedBy("(//p[@class='font-greetings'])[2]");
    public static final Target LABEL_PREAPPROVED_VALUE = Target.the("Label valor preaprobado")
            .locatedBy("//p[@class='font-underline-subtle']");
    public static final Target LABEL_CREDIT_OPTION = Target.the("Label opción de crédito")
            .locatedBy("//p[@class='font-normal-label']");
    public static final Target LABEL_APPROXIMATE_MONTHLY_PAYMENT = Target.the("Label cuota mensual aproximada")
            .locatedBy("(//p[@class='font-normal-label'])[8]");



    /*public static final Target Mail_TXT = Target.the("Campo texto correo final")
        .located(By.id("email"));
    public static final Target MAIL2_TXT = Target.the("Campo texto correo verificacion final")
        .located(By.id("repeatEmail"));*/
    public static final Target FINISH_BUTTON = Target.the("Iniciar una nueva solicitud")
        .located(By.tagName("button"));

}
