package co.bpop.hipotecario.qa.ui.screenplay.tasks;

import co.bpop.hipotecario.qa.ui.screenplay.userinterface.CargaPage;
import co.bpop.hipotecario.qa.ui.screenplay.userinterface.PreApprovalPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class Preapproval implements Task {
    /*
    private String mail;

    public Preapproval(List<String> mail){
        this.mail = mail.get(0);
    }
     */

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
            Scroll.to(PreApprovalPage.LABEL_CREDIT_OPTION),
            Click.on(PreApprovalPage.FINISH_BUTTON),
            WaitUntil.the(CargaPage.LOGOCARGA, isNotVisible())
                        .forNoMoreThan(240).seconds()
        );

    }

    public static Preapproval withEmail(List<String> mailData){
        return Tasks.instrumented(Preapproval.class,mailData);
    }
}
