package co.bpop.hipotecario.qa.ui.screenplay.tasks;

import co.bpop.hipotecario.qa.ui.screenplay.userinterface.HabeasDataValidationPage;
import co.bpop.hipotecario.qa.ui.screenplay.userinterface.OtpValidationPage;
import co.bpop.hipotecario.qa.ui.utilities.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class HabeasData implements Task {

    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(HabeasDataValidationPage.HABEAS_DATA_TITLE_PAGE, isVisible())
                        .forNoMoreThan(25).seconds(),
                Ensure.that(HabeasDataValidationPage.HABEAS_DATA_TITLE_PAGE)
                        .isDisplayed()
                        .orElseThrow(new Throwable("Se presento desborde técnico con el siguiente mensaje: \n" +
                                Constants.MENSAJE_CLIENTE_DESBORDADO)),
                Click.on(HabeasDataValidationPage.TRATAMIENTO_DDATOS_CHECKBOX),
                Click.on(HabeasDataValidationPage.CONSULTA_OSS_CHECKBOX),
                Click.on(HabeasDataValidationPage.CONTINUE_BUTTON)
        );

}
    public static HabeasData SignDocuments(){return Tasks.instrumented(HabeasData.class);
    }
}
