package co.bpop.hipotecario.qa.ui.screenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SarlaftPage {
    public static final Target TITLE_SARLAFT = Target.the("Titulo parrafo Sarlaft")
        .locatedBy("(//div//h1)[2]");
    public static final Target RESIDENT_FISCAL_CHECKBOX = Target.the("responsable de impuestos o residente fiscal")
        .locatedBy("(//span[@class='radio-button-module_control-wrapper__3cwuc']/child::span)[{0}]"); //1-No 2-Si
    public static final Target TINSSN = Target.the("Campo texto TIN")
        .located(By.id("tin-ssn"));
    public static final Target OPERATION_INTERNATIONAL_CHECKBOX = Target.the("realiza operaciones internacionales")
        .locatedBy("(//span[@class='radio-button-module_control-wrapper__3cwuc']/child::span)[{0}]"); //1-No 2-Si
    public static final Target TIPO_PRODUCTO = Target.the("Tipo producto operaciones internacionales")
        .located(By.id("product-type"));
    public static final Target ENTIDAD = Target.the("Entidad operaciones internacionales")
        .located(By.id("entity"));
    public static final Target MONEDA = Target.the("Moneda y Pais operaciones internacionales")
        .locatedBy("(//div[@class='dropdown-module_content__2Y0kE'])[1]"); //1-Moneda 2-Pais
    public static final Target PAIS = Target.the("Moneda y Pais operaciones internacionales")
        .locatedBy("(//div[@class='dropdown-module_content__2Y0kE'])[2]");//1-Moneda 2-Pais
    public static final Target MONEDA_PAIS_LISTA = Target.the("Moneda y pais operaciones internacionales")
        .locatedBy("//span[contains(text(),'{0}')]//parent::div");
    public static final Target MONTO = Target.the("Monto operaciones internacionales")
        .located(By.id("amount"));
    public static final Target CIUDAD = Target.the("ciudad o estado operaciones internacionales")
        .located(By.id("city"));
    public static final Target CUENTA = Target.the("cuenta operaciones internacionales")
        .located(By.id("account-number"));

    public static final Target CONTINUE_BUTTON = Target.the("Continuar")
        .located(By.tagName("button"));

    private SarlaftPage(){}
}
