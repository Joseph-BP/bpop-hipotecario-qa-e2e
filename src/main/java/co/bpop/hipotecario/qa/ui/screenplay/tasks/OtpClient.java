package co.bpop.hipotecario.qa.ui.screenplay.tasks;

import co.bpop.hipotecario.qa.ui.screenplay.userinterface.CargaPage;
import co.bpop.hipotecario.qa.ui.screenplay.questions.*;
import co.bpop.hipotecario.qa.ui.screenplay.userinterface.DesbordePage;
import co.bpop.hipotecario.qa.ui.screenplay.userinterface.HabeasDataValidationPage;
import co.bpop.hipotecario.qa.ui.screenplay.userinterface.OtpValidationPage;
import co.bpop.hipotecario.qa.ui.utilities.Constants;
import io.cucumber.java8.El;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.Matchers.containsString;

public class OtpClient implements Task {

    String solicitudNuevoOtp;
    String textTitle;
    String textTitleOtp;
    String textTitleHabeasData;
    String textTitleDesborde;

    public OtpClient(List<String> data){
        this.solicitudNuevoOtp = data.get(0);

        /*
        if (OtpValidationPage.OTP_TITLE_PAGE.equals(isCurrentlyVisible())) {
            textTitle = String.valueOf(OtpValidationPage.OTP_TITLE_PAGE);
        } else if (HabeasDataValidationPage.HABEAS_DATA_TITLE_PAGE.equals(isCurrentlyVisible())) {
            textTitle = String.valueOf(HabeasDataValidationPage.HABEAS_DATA_TITLE_PAGE);
        } else if (OtpValidationPage.OTP_TITLE_PAGE.equals(isCurrentlyVisible())) {
            textTitle = String.valueOf(DesbordePage.VALIDACION_MENSAJE_TITULO);
        }
         */

        //textTitleOtp = OtpValidationPage.OTP_TITLE_PAGE.resolveFor(theActorInTheSpotlight()).getText();
        //textTitleHabeasData = HabeasDataValidationPage.HABEAS_DATA_TITLE_PAGE.resolveFor(theActorInTheSpotlight()).getText();
        //textTitleDesborde = DesbordePage.VALIDACION_MENSAJE_TITULO.resolveFor(theActorInTheSpotlight()).getText();



        //if (textTitleOtp.contains(Constants.TITULO_GENERACION_OTP)){
        //    textTitle = OtpValidationPage.OTP_TITLE_PAGE.resolveFor(theActorInTheSpotlight()).getText();
        //}
        //else if (textTitleHabeasData.contains(Constants.TITULO_ACEPTACION_HABEAS_DATA)){
       //     textTitle = HabeasDataValidationPage.HABEAS_DATA_TITLE_PAGE.resolveFor(theActorInTheSpotlight()).getText();
        //}
        //else if (textTitleDesborde.contains(Constants.TITULO_CLIENTE_DESBORDADO_ER_TEC)){
        //    textTitle = DesbordePage.VALIDACION_MENSAJE_TITULO.resolveFor(theActorInTheSpotlight()).getText();
        //}


        /*
        if(OtpValidationPage.OTP_TITLE_PAGE
                .resolveFor(theActorInTheSpotlight()).isVisible()){
                    theActorInTheSpotlight().should
                            (seeThat(OtpPageQuestions.title(),containsString(Constants.TITULO_GENERACION_OTP)));
                            textTitle = OtpValidationPage.OTP_TITLE_PAGE.resolveFor(theActorInTheSpotlight()).getText();
        }
        else if(HabeasDataValidationPage.HABEAS_DATA_TITLE_PAGE
                .resolveFor(theActorInTheSpotlight()).isVisible()){
                theActorInTheSpotlight().should
                        (seeThat(OtpPageQuestions.title(),containsString(Constants.TITULO_ACEPTACION_HABEAS_DATA)));
                        textTitle = HabeasDataValidationPage.HABEAS_DATA_TITLE_PAGE.resolveFor(theActorInTheSpotlight()).getText();

        }
        else if (DesbordePage.VALIDACION_MENSAJE_TITULO.resolveFor(theActorInTheSpotlight()).isVisible()){
            textTitle = DesbordePage.VALIDACION_MENSAJE_TITULO.resolveFor(theActorInTheSpotlight()).getText();
        }
         */
        /*
        textTitle = OtpPageQuestions.title().answeredBy(theActorInTheSpotlight());
        if(textTitle.contains(Constants.TITULO_GENERACION_OTP)){
            textTitle = OtpValidationPage.OTP_TITLE_PAGE.resolveFor(theActorInTheSpotlight()).getText();
        }
        else if(OtpPageQuestions.title().toString().contains(Constants.TITULO_ACEPTACION_HABEAS_DATA)){
            textTitle = HabeasDataValidationPage.HABEAS_DATA_TITLE_PAGE.resolveFor(theActorInTheSpotlight()).getText();

        }
        else if (OtpPageQuestions.title().toString().contains(Constants.TITULO_CLIENTE_DESBORDADO_ER_TEC)){
            textTitle = DesbordePage.VALIDACION_MENSAJE_TITULO.resolveFor(theActorInTheSpotlight()).getText();
        }
         */

    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {

        if (solicitudNuevoOtp.equalsIgnoreCase("No") && OtpPageQuestions.title().answeredBy(theActorInTheSpotlight()).contains(Constants.TITULO_GENERACION_OTP)) {
        //if (solicitudNuevoOtp.equalsIgnoreCase("No") && textTitle.contains(Constants.TITULO_GENERACION_OTP)) {
            actor.attemptsTo(
//                    WaitUntil.the(CargaPage.LOGOCARGA, isVisible())
//                            .forNoMoreThan(120).seconds(),
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
        }
        else if(solicitudNuevoOtp.equalsIgnoreCase("No") && OtpPageQuestions.title().answeredBy(theActorInTheSpotlight()).contains(Constants.TITULO_ACEPTACION_HABEAS_DATA)){
            FallaValidacionOtp.SignDocumentsOss();
        }
        else if (solicitudNuevoOtp.equalsIgnoreCase("No") && OtpPageQuestions.title().answeredBy(theActorInTheSpotlight()).contains(Constants.TITULO_CLIENTE_DESBORDADO_ER_TEC)){
            actor.attemptsTo(
                    Ensure.that(OtpValidationPage.OTP_TITLE_PAGE)
                            .isDisplayed()
                            .orElseThrow(new Throwable("Se presento desborde técnico con el siguiente mensaje: \n"+
                                    Constants.MENSAJE_CLIENTE_DESBORDADO))
                    /*
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
                     */
            );
        }
    }
    public static OtpClient nuevoOtp(List<String> data){
        return Tasks.instrumented(OtpClient.class, data);
    }
}