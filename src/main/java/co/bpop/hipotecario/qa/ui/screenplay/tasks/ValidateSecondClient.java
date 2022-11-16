package co.bpop.hipotecario.qa.ui.screenplay.tasks;

import co.bpop.hipotecario.qa.ui.screenplay.userinterface.AuthenticationClientPage;
import co.bpop.hipotecario.qa.ui.screenplay.userinterface.ValidationSecondClientPage;
import co.bpop.hipotecario.qa.ui.utilities.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class ValidateSecondClient implements Task {
    String sumaIngresos;
    String parentesco;

    public ValidateSecondClient(List<String> data){
        if (data.get(0).equalsIgnoreCase("Si")){
            this.sumaIngresos = "2";
        }else{
            this.sumaIngresos = "1";
        }
        if (data.get(1) == null){
            this.parentesco = "";
        }else{
            this.parentesco = data.get(1);
        }
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (sumaIngresos.equalsIgnoreCase("2")){
            actor.attemptsTo(
                WaitUntil.the(ValidationSecondClientPage.SECOND_CLIENT_CHECKBOX.of(sumaIngresos), isClickable())
                        .forNoMoreThan(60).seconds(),
                Click.on(ValidationSecondClientPage.SECOND_CLIENT_CHECKBOX.of(sumaIngresos)),
                Click.on(ValidationSecondClientPage.RELATION_FIRST_CLIENTE_CLICK),
                Click.on(ValidationSecondClientPage.RELATION_FIRST_CLIENT_LIST.of(parentesco)),
                Click.on(ValidationSecondClientPage.CONTINUE_BUTTON),
                Ensure.that(AuthenticationClientPage.AUTHENTICATION_TITTLE).text().contains(Constants.TITULO_SEGUNDO_CLIENTE)
            );
        }else{
            actor.attemptsTo(
                WaitUntil.the(ValidationSecondClientPage.SECOND_CLIENT_CHECKBOX.of(sumaIngresos), isClickable())
                    .forNoMoreThan(60).seconds(),
                Click.on(ValidationSecondClientPage.SECOND_CLIENT_CHECKBOX.of(sumaIngresos)),
                Click.on(ValidationSecondClientPage.CONTINUE_BUTTON)
            );
        }
    }

    public static ValidateSecondClient fillForm(List<String> data){
        return Tasks.instrumented(ValidateSecondClient.class, data);
    }
}
