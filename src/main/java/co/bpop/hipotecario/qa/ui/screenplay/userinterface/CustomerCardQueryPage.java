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

public class CustomerCardQueryPage {

  public static final Target CUSTOMER_QUERY_TITTLE = Target.the("Título")
      .located(By.xpath("//h1[contains(text(),'ingresa el número de cédula')]"));
    public static final Target TITTLE_CUSTOMER_CARD_QUERY = Target.the("Titulo final")
        .locatedBy("(//h1)[2]");
  public static final Target CITIZENSHIP_CARD_FIELD = Target.the("Campo cédula de ciudadanía")
      .located(By.id("document-number"));
  public static final Target BEGIN_TRANSACTION_BUTTON = Target.the("Botón empezar solicitud")
      .located(By.xpath("//button[@type='submit']"));

  private CustomerCardQueryPage(){}
}
