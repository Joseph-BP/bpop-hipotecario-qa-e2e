/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.bpop.hipotecario.qa.ui.screenplay.questions;

import co.bpop.hipotecario.qa.ui.screenplay.userinterface.OtpValidationPage;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OtpPageQuestions {
    public static Question<String> otpTitlePage(){
        return actor -> TextContent.of(OtpValidationPage.OTP_TITLE_PAGE).viewedBy(actor).asString().trim();
    }
}