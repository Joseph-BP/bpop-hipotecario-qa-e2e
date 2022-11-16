package co.bpop.hipotecario.qa.ui.screenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class CargaPage {
    public static final Target LOGOCARGA = Target.the("Espera para logo de carga en todas las paginas")
        .locatedBy("//div[@class='loader-module_content__dkJ9N']");

    private CargaPage(){}
}
