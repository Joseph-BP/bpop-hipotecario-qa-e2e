package co.bpop.hipotecario.qa.ui.screenplay.questions;

import co.bpop.hipotecario.qa.ui.screenplay.userinterface.DesbordePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class DesbordeQuestions implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        WaitUntil.the(DesbordePage.BUTTON_DESBORDE, isPresent()).forNoMoreThan(60).seconds();
        return DesbordePage.VALIDACION_MENSAJE_TITULO.resolveFor(actor).getText()+" "+DesbordePage.VALIDACION_MENSAJE.resolveFor(actor).getText();
    }

    public static DesbordeQuestions message(){
        return new DesbordeQuestions();
    }
}
