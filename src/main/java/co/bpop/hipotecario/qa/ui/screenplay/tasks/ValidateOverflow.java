package co.bpop.hipotecario.qa.ui.screenplay.tasks;

import co.bpop.hipotecario.qa.ui.screenplay.userinterface.DesbordePage;
import co.bpop.hipotecario.qa.ui.utilities.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ValidateOverflow implements Task {

    String desicion;
    String pep;

    public ValidateOverflow(List<String> data, String pEP){
        this.desicion = data.get(0);
        this.pep = pEP;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (desicion.equalsIgnoreCase("NO") && pep.equalsIgnoreCase("SI")){
            actor.attemptsTo(
                Ensure.that(DesbordePage.VALIDACION_MENSAJE)
                    .text().containsIgnoringCase(Constants.MENSAJE_DESBORDE_CLIENTE_DOS),
                Click.on(DesbordePage.LINKS_SALIR_SOLICITUD_NO),
                Click.on(DesbordePage.BUTTON_DESBORDE_POPUP),
                Click.on(DesbordePage.LINKS_SALIR_SOLICITUD_NO),
                Click.on(DesbordePage.LINK_SALIR_SOLICITUD_SI)
            );
        }else if (desicion.equalsIgnoreCase("SI") && pep.equalsIgnoreCase("SI")){
            actor.attemptsTo(
                Ensure.that(DesbordePage.VALIDACION_MENSAJE)
                    .text().containsIgnoringCase(Constants.MENSAJE_DESBORDE_CLIENTE_DOS),
                Click.on(DesbordePage.LINKS_SALIR_SOLICITUD_NO),
                Click.on(DesbordePage.BUTTON_DESBORDE_POPUP),
                Click.on(DesbordePage.BUTTON_DESBORDE)
            );
        } else if (desicion.equalsIgnoreCase("NO") && DesbordePage.VALIDACION_MENSAJE_TITULO.resolveFor(theActorInTheSpotlight()).getText().contains("edad entre los 18 y 75 años")) {
            actor.attemptsTo(
                Ensure.that(DesbordePage.VALIDACION_MENSAJE_TITULO)
                    .text().containsIgnoringCase(Constants.MENSAJE_CLIENTE_EDADDESBORDE_DOS),
                Click.on(DesbordePage.LINKS_SALIR_SOLICITUD_NO),
                Click.on(DesbordePage.BUTTON_DESBORDE_POPUP),
                Click.on(DesbordePage.LINKS_SALIR_SOLICITUD_NO),
                Click.on(DesbordePage.LINK_SALIR_SOLICITUD_SI)
            );
        }else if(desicion.equalsIgnoreCase("SI") && DesbordePage.VALIDACION_MENSAJE_TITULO.resolveFor(theActorInTheSpotlight()).getText().contains("edad entre los 18 y 75 años")){
            actor.attemptsTo(
                Ensure.that(DesbordePage.VALIDACION_MENSAJE_TITULO)
                    .text().containsIgnoringCase(Constants.MENSAJE_CLIENTE_EDADDESBORDE_DOS),
                Click.on(DesbordePage.LINKS_SALIR_SOLICITUD_NO),
                Click.on(DesbordePage.BUTTON_DESBORDE_POPUP),
                Click.on(DesbordePage.BUTTON_DESBORDE)
            );
        }else if (desicion.equalsIgnoreCase("NO") && DesbordePage.VALIDACION_MENSAJE_TITULO.resolveFor(theActorInTheSpotlight()).getText().contains(Constants.TITULO_CLIENTE_DESBORDADO_OTP)) {
                actor.attemptsTo(
                    Ensure.that(DesbordePage.VALIDACION_MENSAJE_TITULO)
                        .text().containsIgnoringCase(Constants.MENSAJE_CLIENTE_DESBORDADO_OTP),
                    Click.on(DesbordePage.LINKS_SALIR_SOLICITUD_NO),
                    Click.on(DesbordePage.BUTTON_DESBORDE_POPUP),
                    Click.on(DesbordePage.LINKS_SALIR_SOLICITUD_NO),
                    Click.on(DesbordePage.LINK_SALIR_SOLICITUD_SI)
                );
            }else if(desicion.equalsIgnoreCase("SI") && DesbordePage.VALIDACION_MENSAJE_TITULO.resolveFor(theActorInTheSpotlight()).getText().contains(Constants.TITULO_CLIENTE_DESBORDADO_OTP)){
                actor.attemptsTo(
                    Ensure.that(DesbordePage.VALIDACION_MENSAJE_TITULO)
                        .text().containsIgnoringCase(Constants.MENSAJE_CLIENTE_DESBORDADO_OTP),
                    Click.on(DesbordePage.LINKS_SALIR_SOLICITUD_NO),
                    Click.on(DesbordePage.BUTTON_DESBORDE_POPUP),
                    Click.on(DesbordePage.BUTTON_DESBORDE)
                );
            }else if (desicion.equalsIgnoreCase("NO") && DesbordePage.VALIDACION_MENSAJE_TITULO.resolveFor(theActorInTheSpotlight()).getText().contains(Constants.TITULO_CLIENTE_DESBORDADO_ACTIVIDAD)) {
            actor.attemptsTo(
                Ensure.that(DesbordePage.VALIDACION_MENSAJE_TITULO)
                    .text().containsIgnoringCase(Constants.TITULO_CLIENTE_DESBORDADO_ACTIVIDAD),
                Click.on(DesbordePage.LINKS_SALIR_SOLICITUD_NO),
                Click.on(DesbordePage.BUTTON_DESBORDE_POPUP),
                Click.on(DesbordePage.LINKS_SALIR_SOLICITUD_NO),
                Click.on(DesbordePage.LINK_SALIR_SOLICITUD_SI)
            );
        }else if(desicion.equalsIgnoreCase("SI") && DesbordePage.VALIDACION_MENSAJE_TITULO.resolveFor(theActorInTheSpotlight()).getText().contains(Constants.TITULO_CLIENTE_DESBORDADO_ACTIVIDAD)){
            actor.attemptsTo(
                Ensure.that(DesbordePage.VALIDACION_MENSAJE_TITULO)
                    .text().containsIgnoringCase(Constants.TITULO_CLIENTE_DESBORDADO_ACTIVIDAD),
                Click.on(DesbordePage.LINKS_SALIR_SOLICITUD_NO),
                Click.on(DesbordePage.BUTTON_DESBORDE_POPUP),
                Click.on(DesbordePage.BUTTON_DESBORDE)
            );
        } else if(desicion.equalsIgnoreCase("NO")) {
            actor.attemptsTo(
                Ensure.that(DesbordePage.VALIDACION_MENSAJE)
                    .text().containsIgnoringCase(Constants.MENSAJE_CLIENTE_GENDESBORDE),
                Click.on(DesbordePage.LINKS_SALIR_SOLICITUD_NO),
                Click.on(DesbordePage.BUTTON_DESBORDE_POPUP),
                Click.on(DesbordePage.LINKS_SALIR_SOLICITUD_NO),
                Click.on(DesbordePage.LINK_SALIR_SOLICITUD_SI)
            );
        }else{
            actor.attemptsTo(
                Ensure.that(DesbordePage.VALIDACION_MENSAJE)
                    .text().containsIgnoringCase(Constants.MENSAJE_CLIENTE_GENDESBORDE),
                Click.on(DesbordePage.LINKS_SALIR_SOLICITUD_NO),
                Click.on(DesbordePage.BUTTON_DESBORDE_POPUP),
                Click.on(DesbordePage.BUTTON_DESBORDE)
            );
        }
    }

    public static ValidateOverflow inDisplay(List<String> data, String pEP){
        return Tasks.instrumented(ValidateOverflow.class, data, pEP);
    }
}
