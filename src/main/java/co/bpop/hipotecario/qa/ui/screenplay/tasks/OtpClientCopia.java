package co.bpop.hipotecario.qa.ui.screenplay.tasks;

import co.bpop.hipotecario.qa.ui.screenplay.userinterface.CargaPage;
import co.bpop.hipotecario.qa.ui.screenplay.userinterface.OtpValidationPage;
import co.bpop.hipotecario.qa.ui.utilities.Constants;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OtpClientCopia implements Task {

    String solicitudNuevoOtp;

    public OtpClientCopia(List<String> data){
        this.solicitudNuevoOtp = data.get(0);
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
        if (solicitudNuevoOtp.equalsIgnoreCase("No")) {
            actor.attemptsTo(
                WaitUntil.the(CargaPage.LOGOCARGA, isVisible())
                    .forNoMoreThan(120).seconds(),
                Ensure.that(OtpValidationPage.OTP_TITLE_PAGE)
                    .isDisplayed()
                    .orElseThrow(new Throwable("Se presento desborde técnico con el siguiente mensaje: \n"+
                        Constants.MENSAJE_CLIENTE_DESBORDADO)),
                Enter.theValue("1").into(OtpValidationPage.OTP_FIELD_ONE),
                Enter.theValue("1").into(OtpValidationPage.OTP_FIELD_TWO),
                Enter.theValue("1").into(OtpValidationPage.OTP_FIELD_THREE),
                Enter.theValue("1").into(OtpValidationPage.OTP_FIELD_FOUR),
                Enter.theValue("1").into(OtpValidationPage.OTP_FIELD_FIVE),
                Enter.theValue("1").into(OtpValidationPage.OTP_FIELD_SIX),
                Enter.theValue("1").into(OtpValidationPage.OTP_FIELD_SEVEN),
                Enter.theValue("1").into(OtpValidationPage.OTP_FIELD_EIGHT),
                Click.on(OtpValidationPage.NEXT_BUTTON)
            );
        }else{
            actor.attemptsTo(
                WaitUntil.the(CargaPage.LOGOCARGA, isVisible())
                    .forNoMoreThan(120).seconds(),
                Ensure.that(OtpValidationPage.OTP_TITLE_PAGE)
                    .isDisplayed()
                    .orElseThrow(new Throwable("Se presento desborde técnico con el siguiente mensaje: \n"+
                        Constants.MENSAJE_CLIENTE_DESBORDADO)),
                WaitUntil.the(OtpValidationPage.OTP_BY_CALL_LINK, isClickable())
                    .forNoMoreThan(200).seconds()
                    .then(Click.on(OtpValidationPage.OTP_BY_CALL_LINK)),
                Enter.theValue("1").into(OtpValidationPage.OTP_FIELD_ONE),
                Enter.theValue("1").into(OtpValidationPage.OTP_FIELD_TWO),
                Enter.theValue("1").into(OtpValidationPage.OTP_FIELD_THREE),
                Enter.theValue("1").into(OtpValidationPage.OTP_FIELD_FOUR),
                Enter.theValue("1").into(OtpValidationPage.OTP_FIELD_FIVE),
                Enter.theValue("1").into(OtpValidationPage.OTP_FIELD_SIX),
                Enter.theValue("1").into(OtpValidationPage.OTP_FIELD_SEVEN),
                Enter.theValue("1").into(OtpValidationPage.OTP_FIELD_EIGHT),
                Click.on(OtpValidationPage.NEXT_BUTTON)
            );
        }
    }
    public static OtpClientCopia nuevoOtp(List<String> data){
        return Tasks.instrumented(OtpClientCopia.class, data);
    }
}
