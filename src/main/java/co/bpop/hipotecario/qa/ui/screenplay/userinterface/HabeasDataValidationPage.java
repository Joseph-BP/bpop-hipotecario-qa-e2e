package co.bpop.hipotecario.qa.ui.screenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HabeasDataValidationPage {

    public static final Target HABEAS_DATA_TITLE_PAGE = Target.the("Título Habeas Data y consulta OSS")
            .located(By.xpath("//p[@class='signature-title']"));
    public static final Target TRATAMIENTO_DDATOS_CHECKBOX = Target.the("Check autorización tratamiento datos personales")
            .located(By.xpath("//label[@id='signature-habeas-data-label-wrapper']//span[@class='checkbox-module_checkmark__onQua']"));
    public static final Target CONSULTA_OSS_CHECKBOX = Target.the("Check autorización consulta centrales de riesgo")
            .located(By.xpath("//label[@id='signature-central-risk-label-wrapper']//span[@class='checkbox-module_checkmark__onQua']"));
    public static final Target CONTINUE_BUTTON = Target.the("Botón continuar")
            .located(By.xpath("//button[@id='data-signature-form-buttom']"));
    public static final Target CONTINUAR_CLIENTE_UNO_LINK = Target.the("Link continuar con cliente uno")
            .located(By.xpath("//div[contains(text(),'Continuar solicitud con el primer cliente')]"));
    public static final Target SALIR_SOLICITUD_LINK = Target.the("Link Salir de esta solicitud")
            .located(By.xpath("//div[contains(text(),'Salir de esta solicitud')]"));

    private HabeasDataValidationPage(){}
}
