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

public class SegmentSelectionPage {

  public static final Target SALES_ROOM_OPTION_BUTTON = Target.the("Segmento en sala de ventas")
      .located(
          By.cssSelector("#segment-field-radio-button-1-label-wrapper"));
  public static final Target ICON_LIST_ROOM = Target.the("Icono de despliegue lista sala de ventas")
      .locatedBy("//span[@id='icon-simple-arrow']");
  public static final Target SALES_ROOM_DROPDOWN_LIST = Target.the("Lista de salas de venta")
      .locatedBy("//div[@class='dropdown-module_expanded-content__EK1-k']/div/span[contains(text(),'{0}')]");
  public static final Target OFFICE_OPTION_BUTTON = Target.the("Segmento en oficinas")
      .located(
          By.cssSelector("#segment-field-radio-button-2-label-wrapper"));

  public static final Target FAIR_ROOM_OPTION_BUTTON = Target.the("Segmento En Feria")

          .located(
                  By.cssSelector("#segment-field-radio-button-3-label-wrapper"));
  public static final Target OTHER_SIDE_OPTION_BUTTON = Target.the("Segmento en otro sitio")
      .located(
          By.cssSelector("#segment-field-radio-button-4-label-wrapper"));
  public static final Target BEGIN_APPLICATION_BUTTON = Target.the("Comenzar solicitud")
      .located(
          By.tagName("button"));
  private SegmentSelectionPage(){}
}
