/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.bpop.hipotecario.qa.ui.screenplay.tasks;

import co.bpop.hipotecario.qa.ui.logs.LogPrinter;
import co.bpop.hipotecario.qa.ui.screenplay.userinterface.CargaPage;
import co.bpop.hipotecario.qa.ui.screenplay.userinterface.SegmentSelectionPage;
import co.bpop.hipotecario.qa.ui.utilities.Constants;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectionAdvisorSegment implements Task {

  private Target segmentType;
  String segmento;
  String proyecto;

  public SelectionAdvisorSegment(String segment, DataTable proyect) {
      segmento = segment;
      switch (segment.toUpperCase()) {
          case "EN SALA DE VENTAS":
            segmentType = SegmentSelectionPage.SALES_ROOM_OPTION_BUTTON;
            break;
          case "EN OFICINA":
            segmentType = SegmentSelectionPage.OFFICE_OPTION_BUTTON;
            break;

          case "EN FERIA":

              segmentType = SegmentSelectionPage.FAIR_ROOM_OPTION_BUTTON;

              break;

          case "EN OTRO LUGAR":
            segmentType = SegmentSelectionPage.OTHER_SIDE_OPTION_BUTTON;
            break;

          default:
            LogPrinter.printLog(Constants.INVALID_CHANNEL_SALE_MESSAGE);
            break;
        }
      proyecto=proyect.asList().get(0);

  }

  @Override
  public <T extends Actor> void performAs(T actor) {
      if (segmento.equalsIgnoreCase("EN SALA DE VENTAS")){
          actor.attemptsTo(
              WaitUntil.the(CargaPage.LOGOCARGA, WebElementStateMatchers.isNotVisible()).forNoMoreThan(10)
                  .seconds(),
              Click.on(segmentType),
              Click.on(SegmentSelectionPage.ICON_LIST_ROOM),
              Click.on(SegmentSelectionPage.SALES_ROOM_DROPDOWN_LIST.of(proyecto)),
              Click.on(SegmentSelectionPage.BEGIN_APPLICATION_BUTTON));
      }else{
          actor.attemptsTo(
              WaitUntil.the(CargaPage.LOGOCARGA, WebElementStateMatchers.isNotVisible()).forNoMoreThan(10)
                  .seconds(),
              Click.on(segmentType),
              Click.on(SegmentSelectionPage.BEGIN_APPLICATION_BUTTON));
      }

  }

  public static Performable a(String segment, DataTable proyect) {
    return instrumented(SelectionAdvisorSegment.class, segment, proyect);
  }

}
