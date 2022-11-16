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

public class AuthenticationClientPage {

  public static final Target AUTHENTICATION_TITTLE = Target.the("Título")
      .located(By.xpath("//h1[contains(text(),'dentifica a tu')]"));
    public static final Target TITTLE_SEGMENTO = Target.the("Titulo final")
        .locatedBy("(//h1)[2]");
  public static final Target NAMES_CLIENT_FIELD = Target.the("Campo ingresar nombres")
      .located(By.id("names"));
  public static final Target FIRST_LAST_NAME_CLIENT_FIELD = Target.the("Campo primer apellido")
      .located(By.id("first-last-name"));
  public static final Target SECOND_LAST_NAME_CLIENT_FIELD = Target.the("Campo segundo apellido")
      .located(By.id("second-last-name"));
  public static final Target DOCUMENT_ID_CLIENT_FIELD = Target.the("Campo cédula ciudadanía")
      .located(By.id("document-number"));
  public static final Target BIRTHDATE_DAY_FIELD = Target.the("Campo día de nacimiento")
      .located(By.id("birthdate-day"));
  public static final Target BIRTHDATE_MONTH_DROPDOWN = Target.the("Lista mes de nacimiento")
      .located(By.id("icon-simple-arrow"));
    public static final Target BIRTHDATE_MONTH_LIST = Target.the("Lista mes de nacimiento")
        .locatedBy("//div[@class='dropdown-module_expanded-section__zbZr3']//child::span[contains(text(),'{0}')]");
  public static final Target BIRTHDATE_YEAR_FIELD = Target.the("Campo año de nacimiento")
      .located(By.id("birthdate-year"));
  public static final Target CELLPHONE_NUMBER_FIELD = Target.the("Campo número de celular")
      .located(By.id("cellphone"));
  public static final Target EMAIL_ADDRESS_FIELD = Target.the("Campo correo electrónico")
          .located(By.id("email"));
  public static final Target EMAIL_ADDRESS_CONFIRMATION_FIELD = Target.the("Campo confirmación de correo electrónico")
          .located(By.id("repeatEmail"));
  public static final Target PERSONAL_DATA_CHECKBOX = Target.the("Acepto tratamiento de datos")
      .locatedBy("(//span[@class='checkbox-module_checkmark__onQua'])[1]");
  public static final Target LINK_PERSONAL_DATA = Target.the("Link de datos personales")
      .located(By.xpath("(//div[contains(text(),'datos personales')])[1]"));
  public static final Target PERSONAL_DATA_POPUP = Target.the("Habeas data pop up")
      .located(By.xpath("//h6[contains(text(),'datos ')]"));
    public static final Target UNDERSTANDPBUTTON = Target.the("Boton entendido popup datos personales")
        .located(By.xpath("(//button[@id='modal-primary-button'])[1]"));
  public static final Target CENTRAL_RISK_CHECKBOX = Target.the("Acepto consulta en centrales de riesgo")
      .locatedBy("(//span[@class='checkbox-module_checkmark__onQua'])[2]");
    public static final Target LINK_CENTRAL_RISK = Target.the("Link de centrales de riesgos")
        .located(By.xpath("(//div[contains(text(),'centrales de ')])[1]"));
  public static final Target CENTRAL_RISK_POPUP = Target.the("Centrales de riesgo")
      .located(By.xpath("//h6[contains(text(),'centrales de ')]"));
  public static final Target UNDERSTANDCBUTTON = Target.the("Boton entendido popup")
      .located(By.xpath("(//button[@id='modal-primary-button'])[2]"));
  public static final Target PEP = Target.the("Cliente PEP")
      .locatedBy("(//span[@class='radio-button-module_control-wrapper__3cwuc']/child::span)[{0}]");
  public static final Target BEGIN_TRANSACTION_BUTTON = Target.the("Continuar")
      .located(By.id("auth-page-form-submit"));

  private AuthenticationClientPage(){}
}
