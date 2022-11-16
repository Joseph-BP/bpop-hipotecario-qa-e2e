package co.bpop.hipotecario.qa.ui.screenplay.tasks;

import co.bpop.hipotecario.qa.ui.screenplay.userinterface.HabeasDataValidationPage;
import co.bpop.hipotecario.qa.ui.screenplay.userinterface.OtpValidationPage;
import co.bpop.hipotecario.qa.ui.utilities.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FallaValidacionOtp implements Task {

    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                Ensure.that(OtpValidationPage.OTP_TITLE_PAGE)
                        .isDisplayed()
                        .orElseThrow(new Throwable("Se presento desborde tecnico con el siguiente mensaje: \n"+
                                Constants.MENSAJE_CLIENTE_DESBORDADO)),
                Enter.theValue("9").into(OtpValidationPage.OTP_FIELD_ONE),
                Enter.theValue("9").into(OtpValidationPage.OTP_FIELD_TWO),
                Enter.theValue("9").into(OtpValidationPage.OTP_FIELD_THREE),
                Enter.theValue("9").into(OtpValidationPage.OTP_FIELD_FOUR),
                Enter.theValue("9").into(OtpValidationPage.OTP_FIELD_FIVE),
                Enter.theValue("9").into(OtpValidationPage.OTP_FIELD_SIX),
                Enter.theValue("9").into(OtpValidationPage.OTP_FIELD_SEVEN),
                Enter.theValue("9").into(OtpValidationPage.OTP_FIELD_EIGHT),
                Click.on(OtpValidationPage.NEXT_BUTTON),

                WaitUntil.the(HabeasDataValidationPage.HABEAS_DATA_TITLE_PAGE, isVisible())
                        .forNoMoreThan(25).seconds(),
                Click.on(HabeasDataValidationPage.TRATAMIENTO_DDATOS_CHECKBOX),
                Click.on(HabeasDataValidationPage.CONSULTA_OSS_CHECKBOX),
                Click.on(HabeasDataValidationPage.CONTINUE_BUTTON)
        );
}
    public static FallaValidacionOtp SignDocumentsOss(){return Tasks.instrumented(FallaValidacionOtp.class);
    }
}
