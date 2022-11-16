package co.bpop.hipotecario.qa.ui.screenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class DesbordePage {
    public static final Target VALIDACION_ODM_AML_OTP = Target.the("Titulo Desborde por AML, ODM, viabilidad interna, pep, inactividad")
        .locatedBy("//h6");
    public static final Target VALIDACION_MENSAJE = Target.the("Mensaje desborde")
        .locatedBy("//p[@class='message-card-base-module_subtitle__FTDCt']");
    public static final Target VALIDACION_MENSAJE_TITULO = Target.the("Mensaje titulo desborde")
        .locatedBy("//h6[@class='message-card-base-module_title__3l-jo']");
    public static final Target LINK_SALIR_SOLICITUD_SI = Target.the("Link salir de solicitud")
        .locatedBy("//span[@id='confirm-modal-secondary-button']");
    public static final Target LINKS_SALIR_SOLICITUD_NO = Target.the("Link de ventana popup salir solicitud")
        .locatedBy("//div[@class='message-card-base-module_secondary-text-button__pFjsH']");
    public static final Target BUTTON_DESBORDE_POPUP = Target.the("Boton no desborde PEP ventana popup")
        .locatedBy("(//button)[2]");
    public static final Target BUTTON_DESBORDE = Target.the("Boton si desborde PEP")
       .locatedBy("(//button)[1]");
    public static final Target TITULO_INGRESOS = Target.the("Titulo ingresos")
        .locatedBy("//h1[@class='container-module_title__vtwwK']");

    private DesbordePage(){}
}
