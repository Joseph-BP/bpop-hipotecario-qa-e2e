/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.bpop.hipotecario.qa.ui.screenplay.questions;

import co.bpop.hipotecario.qa.ui.screenplay.userinterface.PreApprovalPage;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthPageQuestions implements Question<String>{

    @Override
    public String answeredBy(Actor actor) {
        WaitUntil.the(PreApprovalPage.FINISH_BUTTON, isPresent()).forNoMoreThan(60).seconds();
        return PreApprovalPage.TITTLE_PREAPROBACION.resolveFor(actor).getText();
    }

    public static AuthPageQuestions title(){
      return new AuthPageQuestions();
    }
}
