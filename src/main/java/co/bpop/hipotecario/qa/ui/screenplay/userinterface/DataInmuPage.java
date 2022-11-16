package co.bpop.hipotecario.qa.ui.screenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DataInmuPage {

    public static final Target TOOLTIP_USO = Target.the("ventanas popup con información de uso del inmueble")
            .locatedBy("//span[@id='tooltip-uso-propiedad-2-desktop-trigger']");
    public static final Target TOOLTIP_USO_CLOSE = Target.the("Cierre tooltip uso")
            .locatedBy("//span[@id='tooltip-uso-propiedad-2-desktop-icon-close']");
    public static final Target TOOLTIP_TASA = Target.the("ventanas popup con información de tasa efectiva")
            .locatedBy("//span[@id='tooltip-tasa-desktop-trigger']");
    public static final Target TOOLTIP_TASA_CLOSE = Target.the("Cierre tooltip tasa")
            .locatedBy("//span[@id='tooltip-tasa-desktop-icon-close']");

    public static final Target TOOLTIP_MESSAGE = Target.the("Mensaje de tooltip")
        //.locatedBy("(//div[@class='tooltip-module_content-text__20sSk'])[{0}]/span[1]");
            .locatedBy("(//div[@class='tooltip-module_content-text__20sSk'])[{0}]/span[1]");
    public static final Target STATUSINM = Target.the("Estado del inmueble")
        .locatedBy("//span[contains(text(),'{0}')]//parent::div");//Nuevo-Usado-Por definir
    public static final Target DROPDOWN_LIST_CLICK = Target.the("Proyecto - Tipo inmueble - Subsidio - Porcentaje - monto % - opcion de compra - Plazo")
        .locatedBy("(//span[@class='dropdown-module_name__VyJ9q'])[{0}]"); //1 a 6
    public static final Target LISTAS_DDROPDOWN = Target.the("Valores de listas de listas desplegables dinamico")
        .locatedBy("//span[contains(text(),'{0}')]");
    public static final Target LISTAS_DROPDOWN_MONTO = Target.the("Valores de listas desplegables monto")
        .locatedBy("(//span[starts-with(text(),'{0}')])[1]");
    public static final Target LISTAS_DROPDOWN_OPCION = Target.the("Valores de listas desplegables opcion compra")
        .locatedBy("(//span[starts-with(text(),'{0}')])[2]");
    public static final Target LISTAS_DDROPDOWN_TIPO_INMU = Target.the("Valores de listas de listas desplegables tipo inmueble")
        .locatedBy("//span[starts-with(text(),'{0}')]");
    public static final Target FINANCIAL_CHECKBOX = Target.the("Uso destino inmueble - Opcion de credito - Sistema Amortizacion")
        .locatedBy("(//span[@class='radio-button-module_control-wrapper__3cwuc']/child::span)[{0}]"); //1-6 checkbox
    public static final Target SELECCION_CIUDAD = Target.the("Campo desplegable de seleccion de ciudad inmueble")
        .locatedBy("//span[contains(text(),'{0}')]");
    public static final Target VALUE_INM_TEXT = Target.the("Valor del inmueble")
        .located(By.xpath("//input[@id='input-text-base']"));
    public static final Target TIPO_MONTO = Target.the("Tipo de monto % o $")
        .locatedBy("//div[@class='switch']//child::div[contains(text(),'{0}')]");
    public static final Target MONTO_FINANCIA = Target.the("Monto a financiar texto")
        .located(By.id("monto"));
    public static final Target CITY_INM_TEXT = Target.the("Ciudad del inmueble")
        .located(By.id("city"));
    public static final Target ANNUALTAX_TEXT = Target.the("Tasa efectiva anual")
        .located(By.id("tax-rate"));
    public static final Target APROVE_BUTTON = Target.the("Solicitar pre-aprobacion")
        .located(By.tagName("button"));

    private DataInmuPage(){}
}
