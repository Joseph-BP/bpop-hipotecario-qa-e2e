package co.bpop.hipotecario.qa.ui.screenplay.tasks;

import co.bpop.hipotecario.qa.ui.screenplay.userinterface.AuthenticationClientPage;
import co.bpop.hipotecario.qa.ui.screenplay.userinterface.CargaPage;
import co.bpop.hipotecario.qa.ui.screenplay.userinterface.CustomerCardQueryPage;
import co.bpop.hipotecario.qa.ui.screenplay.userinterface.DesbordePage;
import co.bpop.hipotecario.qa.ui.utilities.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CustomerQuery implements Task {
    String citizenshipCard;

    public CustomerQuery(List<String> data) {
        this.citizenshipCard = data.get(0);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CustomerCardQueryPage.TITTLE_CUSTOMER_CARD_QUERY, isVisible())
                        .forNoMoreThan(25).seconds(),
                Enter.theValue(citizenshipCard).into(CustomerCardQueryPage.CITIZENSHIP_CARD_FIELD),
                Click.on(CustomerCardQueryPage.BEGIN_TRANSACTION_BUTTON),
                WaitUntil.the(CargaPage.LOGOCARGA, isNotVisible())
                        .forNoMoreThan(240).seconds()
        );
    }

    public static CustomerQuery withData(List<String> dataInfo) {
        return Tasks.instrumented(CustomerQuery.class, dataInfo);
    }
}