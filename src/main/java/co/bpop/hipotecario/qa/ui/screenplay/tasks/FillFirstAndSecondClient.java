package co.bpop.hipotecario.qa.ui.screenplay.tasks;

import co.bpop.hipotecario.qa.ui.screenplay.userinterface.AuthenticationClientPage;
import co.bpop.hipotecario.qa.ui.screenplay.userinterface.CargaPage;
import co.bpop.hipotecario.qa.ui.screenplay.userinterface.DesbordePage;
import co.bpop.hipotecario.qa.ui.utilities.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillFirstAndSecondClient implements Task {
    String names;
    String firstLastName;
    String secondLastName;
    String document;
    String day;
    String month;
    String year;
    String[] date;
    String phone;
    String email;
    String pepClient;

    public FillFirstAndSecondClient(List<String> data) {
        this.names = data.get(0);
        this.firstLastName = data.get(1);
        if (data.get(2) == null) {
            this.secondLastName = "  ";
        } else {
            this.secondLastName = data.get(2);
        }
        this.document = data.get(3);
        date = data.get(4).split("-");
        this.day = date[0];
        this.month = date[1];
        this.year = date[2];
        this.phone = data.get(5);
        this.email = data.get(6);
        if (data.get(7).equalsIgnoreCase("SI")) {
            this.pepClient = "2";
        } else if (data.get(7).equalsIgnoreCase("NO")) {
            this.pepClient = "1";
        }
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(AuthenticationClientPage.AUTHENTICATION_TITTLE, isVisible())
                        .forNoMoreThan(25).seconds(),
                Enter.theValue(names).into(AuthenticationClientPage.NAMES_CLIENT_FIELD),
                Enter.theValue(firstLastName).into(AuthenticationClientPage.FIRST_LAST_NAME_CLIENT_FIELD),
                Enter.theValue(secondLastName).into(AuthenticationClientPage.SECOND_LAST_NAME_CLIENT_FIELD),
                Enter.theValue(document).into(AuthenticationClientPage.DOCUMENT_ID_CLIENT_FIELD),
                Enter.theValue(day).into(AuthenticationClientPage.BIRTHDATE_DAY_FIELD),
                Click.on(AuthenticationClientPage.BIRTHDATE_MONTH_DROPDOWN),
                Click.on(AuthenticationClientPage.BIRTHDATE_MONTH_LIST.of(month)),
                Enter.theValue(year).into(AuthenticationClientPage.BIRTHDATE_YEAR_FIELD),
                Enter.theValue(phone).into(AuthenticationClientPage.CELLPHONE_NUMBER_FIELD),
                Enter.theValue(email).into(AuthenticationClientPage.EMAIL_ADDRESS_FIELD),
                Enter.theValue(email).into(AuthenticationClientPage.EMAIL_ADDRESS_CONFIRMATION_FIELD),
                Click.on(AuthenticationClientPage.PERSONAL_DATA_CHECKBOX),
                Click.on(AuthenticationClientPage.LINK_PERSONAL_DATA),
                Ensure.that(AuthenticationClientPage.PERSONAL_DATA_POPUP).text().contains(Constants.TITULO_TOOLTIP_PERSONALES),
                Click.on(AuthenticationClientPage.UNDERSTANDPBUTTON),
                Click.on(AuthenticationClientPage.CENTRAL_RISK_CHECKBOX),
                Click.on(AuthenticationClientPage.LINK_CENTRAL_RISK),
                Ensure.that(AuthenticationClientPage.CENTRAL_RISK_POPUP).text().contains(Constants.TITULO_TOOLTIP_RIESGOS),
                Click.on(AuthenticationClientPage.UNDERSTANDCBUTTON),
                Click.on(AuthenticationClientPage.PEP.of(pepClient)),
                Click.on(AuthenticationClientPage.BEGIN_TRANSACTION_BUTTON),
                WaitUntil.the(CargaPage.LOGOCARGA, isNotVisible())
                        .forNoMoreThan(240).seconds()
        );
        if (pepClient.equalsIgnoreCase("Si")) {
            Ensure.that(DesbordePage.VALIDACION_ODM_AML_OTP)
                    .isDisplayed()
                    .orElseThrow(new Throwable(Constants.MENSAJE_VALIDACION_DESBORDE));
        }
    }

    public static FillFirstAndSecondClient withData(List<String> dataInfo) {
        return Tasks.instrumented(FillFirstAndSecondClient.class, dataInfo);
    }
}