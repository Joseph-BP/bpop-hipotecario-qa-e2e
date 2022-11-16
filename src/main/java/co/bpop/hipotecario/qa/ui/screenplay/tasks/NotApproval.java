package co.bpop.hipotecario.qa.ui.screenplay.tasks;

import co.bpop.hipotecario.qa.ui.screenplay.userinterface.AuthenticationClientPage;
import co.bpop.hipotecario.qa.ui.screenplay.userinterface.NotPreapprovalPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class NotApproval implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(NotPreapprovalPage.END_BUTTON),
                WaitUntil.the(AuthenticationClientPage.TITTLE_SEGMENTO, WebElementStateMatchers.isVisible())
                                .forNoMoreThan(120).seconds(),
            Ensure.that(AuthenticationClientPage.TITTLE_SEGMENTO).text().contains("conoce en minutos")
        );
    }
    public static NotApproval iniPage(){
        return Tasks.instrumented(NotApproval.class);
    }
}
