package co.bpop.hipotecario.qa.ui.screenplay.questions;

import co.bpop.hipotecario.qa.ui.screenplay.userinterface.AuthenticationClientPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class DesbordeSecondClientFailedQuestions implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        WaitUntil.the(AuthenticationClientPage.AUTHENTICATION_TITTLE, isCurrentlyVisible()).forNoMoreThan(60).seconds();
        return AuthenticationClientPage.AUTHENTICATION_TITTLE.resolveFor(actor).getText();
    }

    public static DesbordeSecondClientFailedQuestions verify(){
        return new DesbordeSecondClientFailedQuestions();
    }
}
