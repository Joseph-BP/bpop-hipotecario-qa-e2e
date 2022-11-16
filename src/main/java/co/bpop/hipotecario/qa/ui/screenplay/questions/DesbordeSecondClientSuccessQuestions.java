package co.bpop.hipotecario.qa.ui.screenplay.questions;

import co.bpop.hipotecario.qa.ui.screenplay.userinterface.DesbordePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class DesbordeSecondClientSuccessQuestions implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return DesbordePage.TITULO_INGRESOS.resolveFor(actor).getText();
    }

    public static DesbordeSecondClientSuccessQuestions verify(){
        return new DesbordeSecondClientSuccessQuestions();
    }
}
