/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.bpop.hipotecario.qa.ui.screenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OtpValidationPage {

  public static final Target OTP_TITLE_PAGE = Target.the("Otp aviso")
      .located(By.xpath("//div//h4"));
  public static final Target OTP_FIELD_ONE = Target.the("Otp campo 1")
      .located(By.cssSelector("#opt-input-field-item-0"));
  public static final Target OTP_FIELD_TWO = Target.the("Otp campo 2")
      .located(By.cssSelector("#opt-input-field-item-1"));
  public static final Target OTP_FIELD_THREE = Target.the("Otp campo 3")
      .located(By.cssSelector("#opt-input-field-item-2"));
  public static final Target OTP_FIELD_FOUR = Target.the("Otp campo 4")
      .located(By.cssSelector("#opt-input-field-item-3"));
  public static final Target OTP_FIELD_FIVE = Target.the("Otp campo 5")
      .located(By.cssSelector("#opt-input-field-item-4"));
  public static final Target OTP_FIELD_SIX = Target.the("Otp campo 6")
      .located(By.cssSelector("#opt-input-field-item-5"));
  public static final Target OTP_FIELD_SEVEN = Target.the("Otp campo 7")
      .located(By.cssSelector("#opt-input-field-item-6"));
  public static final Target OTP_FIELD_EIGHT = Target.the("Otp campo 8")
      .located(By.cssSelector("#opt-input-field-item-7"));
  public static final Target OTP_BY_CALL_LINK = Target.the("Solicitar otp por llamada")
      .located(By.xpath("//span[contains(text(),'Solicita un nuevo código para recibirlo por llamad')]"));
  public static final Target NEXT_BUTTON = Target.the("Continuar")
      .located(By.tagName("button"));

  public static final Target MENSAJ_DEBORDEOTP_CODIGO_INVALIDO = Target.the("Mensaje desborde codigo invalido")
      .locatedBy("");
    public static final Target QUIT_BUTTON = Target.the("Boton de salir")
        .located(By.tagName("button"));

  private OtpValidationPage(){}
}
