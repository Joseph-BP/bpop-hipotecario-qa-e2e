package co.bpop.hipotecario.qa.ui.screenplay.questions;

import co.bpop.hipotecario.qa.ui.screenplay.userinterface.NotPreapprovalPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class NotPreapprovalQuestions implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return NotPreapprovalPage.NOTPREAPPROVAL_TITTLE.resolveFor(actor).getText();
    }

    public static NotPreapprovalQuestions endProcces(){
        return new NotPreapprovalQuestions();
    }
}
