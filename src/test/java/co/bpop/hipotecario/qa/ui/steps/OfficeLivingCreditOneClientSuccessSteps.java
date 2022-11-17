/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.bpop.hipotecario.qa.ui.steps;

import co.bpop.hipotecario.qa.ui.screenplay.questions.*;
import co.bpop.hipotecario.qa.ui.screenplay.tasks.*;
import co.bpop.hipotecario.qa.ui.screenplay.userinterface.*;
import co.bpop.hipotecario.qa.ui.utilities.Constants;
import co.bpop.hipotecario.qa.ui.utilities.EnvironmentProperties;
import co.bpop.hipotecario.qa.ui.utilities.apis.AuthenticationAWS;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.hamcrest.Matchers.containsString;

public class OfficeLivingCreditOneClientSuccessSteps {
    private String url;

    @Steps
    AuthenticationAWS auth;

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
        url = EnvironmentProperties.getProperty("webdriver.base.url");
        url = auth.withToken(url);
    }

    @Dado("que deseo generar link de acceso a hipotecario")
    public void queDeseoGenerarLinkDeAccesoAHipotecario() {
        Logger.getLogger("Link de hiptecario con token")
                .log(Level.INFO, "Se ha generado correctamente el link para acceder a hipotecario: " + url);
    }

    @Dado("Que {} es un asesor de ventas del banco popular")
    public void officeAdvisorStartFlow(String officeAdvisorName) {
        theActorCalled(officeAdvisorName).attemptsTo(
                Open.url(url)
        );
    }

    @Cuando("{} selecciona el segmento de venta {}")
    public void officeAdvisorSelectSegmentType(String officeAdvisorName, String segmentType, DataTable proyecto) {
        theActorInTheSpotlight().attemptsTo(
                SelectionAdvisorSegment.a(segmentType, proyecto)
        );
    }

    @Cuando("ingresa el numero de identificacion del cliente")
    public void ingresaElNumeroDeIdentificacionDelCliente(DataTable data) {
        theActorInTheSpotlight().attemptsTo(
                CustomerQuery.withData(data.asList())
        );
    }

    @Cuando("llena el formulario de autenticacion cliente")
    public void llenaElFormularioDeAutenticacionCliente(DataTable data) {
        theActorInTheSpotlight().remember("PEP", data.asList().get(6).toUpperCase());
        theActorInTheSpotlight().attemptsTo(
                FillFirstAndSecondClient.withData(data.asList())
        );
    }

    @Cuando("solicita OTP nuevo")
    public void solicitaOtpNuevo(DataTable data) {
            theActorInTheSpotlight().attemptsTo(
                    OtpClient.nuevoOtp(data.asList()));
    }

    @Cuando("falla generacion OTP")
    public void fallaGeneracionOtp() {
        theActorInTheSpotlight().attemptsTo(
                HabeasData.SignDocuments()
        );
    }

    @Cuando("falla validacion OTP")
    public void fallaValidacionOtp() {
        theActorInTheSpotlight().attemptsTo(
                FallaValidacionOtp.SignDocumentsOss()
        );
    }


    @Cuando("espera {} minutos")
    public void Espera10Minutos(String time) {
        theActorInTheSpotlight().attemptsTo(
                EsperaInactividadSesion.porTiempo(time)
        );
    }

    @Cuando("selecciona opciones en Sarlaft")
    public void seleccionaOpcionesEnSarlaft(DataTable data) {
        theActorInTheSpotlight().attemptsTo(
                SarlaftData.fiscalAndInternational(data.asList())
        );
    }

    @Cuando("adicionara ingresos adicionales")
    public void adicionaraIngresosAdicionales(DataTable data) {
        theActorInTheSpotlight().attemptsTo(
                ValidateSecondClient.fillForm(data.asList())
        );
    }

    @Cuando("llena informacion de ingresos")
    public void llenaInformacionDeIngresos(DataTable data) {
        theActorInTheSpotlight().attemptsTo(
                IncomingClient.with(data.asList())
        );
    }

    @Cuando("llena informacion de inmueble")
    public void llenaInformacionDeInmueble(DataTable data) {
        theActorInTheSpotlight().attemptsTo(
                DataHouse.fillInformation(data.asList())
        );
    }

    @Cuando("valida continuación con o sin ingresos")
    public void validaContinuacionConoSinIngresos(DataTable data) {
        theActorInTheSpotlight().remember("desicion", data.asList());
        theActorInTheSpotlight().attemptsTo(
                ValidateOverflow.inDisplay(data.asList(), theActorInTheSpotlight().recall("PEP"))
        );
    }

    @Entonces("valida o envia preaprobacion")
    public void validaOEnviaPreaprobacion(DataTable data) {
        if (PreApprovalPage.TITTLE_PREAPROBACION
                .resolveFor(theActorInTheSpotlight()).isVisible()) {
            theActorInTheSpotlight().should(
                    seeThat(AuthPageQuestions.title(), containsString(Constants.MENSAJE_FINAL_PREABPROBACION))
            );
            theActorInTheSpotlight().attemptsTo(
                    Preapproval.withEmail(data.asList())
            );
                /*if (EnvironmentProperties.getProperty("webdriver.driver").equalsIgnoreCase("provided")){
                    BroserStackSerenityDriver.markTestStatus("Passed", Constants.MENSAJE_FINAL_PREABPROBACION, Serenity.getDriver());
                }*/
            //} else if (NotPreapprovalPage.NOTPREAPPROVAL_TITTLE
        }else if (NotPreapprovalPage.NOTPREAPPROVAL_TITTLE
                .resolveFor(theActorInTheSpotlight()).isVisible()) {
            theActorInTheSpotlight().should(
                    seeThat(NotPreapprovalQuestions.endProcces(), containsString(Constants.NOT_PREAPPROVAL_MESSAGE)));
            theActorInTheSpotlight().attemptsTo(
                    NotApproval.iniPage()
            );
           /* if (EnvironmentProperties.getProperty("webdriver.driver").equalsIgnoreCase("provided")) {
                BroserStackSerenityDriver.markTestStatus("Passed", Constants.NOT_PREAPPROVAL_MESSAGE, Serenity.getDriver());
            }*/
        /*} else{
            if (EnvironmentProperties.getProperty("webdriver.driver").equalsIgnoreCase("provided")) {
                BroserStackSerenityDriver.markTestStatus("Failed", "No fue ni aprobado ni rechazado el cliente", Serenity.getDriver());
            }*/
        }
    }


    @Entonces("sera desbordado")
    public void seraDesbordado() {
        if (theActorInTheSpotlight().recall("PEP").toString().equalsIgnoreCase("SI")) {
            theActorInTheSpotlight().should(
                    seeThat(DesbordeQuestions.message(), containsString(Constants.MENSAJE_DESBORDE_CLIENTE_UNO))
            );
          /*if (EnvironmentProperties.getProperty("webdriver.driver").equalsIgnoreCase("provided")) {
              BroserStackSerenityDriver.markTestStatus("Passed", Constants.MENSAJE_DESBORDE_CLIENTE_UNO, Serenity.getDriver());
          }*/
            // }else if (DesbordePage.VALIDACION_MENSAJE_TITULO
        }
        if (DesbordePage.VALIDACION_MENSAJE_TITULO
                .resolveFor(theActorInTheSpotlight()).getText().contains("edad entre los 18 y 75 años")) {
            theActorInTheSpotlight().should(
                    seeThat(DesbordeQuestions.message(), containsString(Constants.MENSAJE_CLIENTE_EDADDESBORDE))
            );
          /*if (EnvironmentProperties.getProperty("webdriver.driver").equalsIgnoreCase("provided")) {
              BroserStackSerenityDriver.markTestStatus("Passed", Constants.MENSAJE_CLIENTE_EDADDESBORDE, Serenity.getDriver());
          }*/
            //}else if(DesbordePage.VALIDACION_MENSAJE_TITULO
        }
        if (DesbordePage.VALIDACION_MENSAJE_TITULO
                .resolveFor(theActorInTheSpotlight()).getText().contains(Constants.MENSAJE_CLIENTE_DESBORDADO_OTP)) {
            theActorInTheSpotlight().should(
                    seeThat(DesbordeQuestions.message(), containsString(Constants.MENSAJE_CLIENTE_DESBORDADO_OTP))
            );
          /*if (EnvironmentProperties.getProperty("webdriver.driver").equalsIgnoreCase("provided")) {
              BroserStackSerenityDriver.markTestStatus("Passed", Constants.MENSAJE_CLIENTE_DESBORDADO_OTP, Serenity.getDriver());
          }*/
            //}else if(DesbordePage.VALIDACION_MENSAJE_TITULO
        }
        if (DesbordePage.VALIDACION_MENSAJE_TITULO
                .resolveFor(theActorInTheSpotlight()).getText().contains(Constants.MENSAJE_CLIENTE_DESBORDADO_INACTIVIDAD_T)) {
            theActorInTheSpotlight().should(
                    seeThat(DesbordeQuestions.message(), containsString(Constants.MENSAJE_CLIENTE_DESBORDADO_INACTIVIDAD_COM))
            );
          /*if (EnvironmentProperties.getProperty("webdriver.driver").equalsIgnoreCase("provided")) {
              BroserStackSerenityDriver.markTestStatus("Passed", Constants.MENSAJE_CLIENTE_DESBORDADO_INACTIVIDAD_COM, Serenity.getDriver());
          }*/
            //}else if(DesbordePage.VALIDACION_MENSAJE_TITULO
        }
        if (DesbordePage.VALIDACION_MENSAJE_TITULO
                .resolveFor(theActorInTheSpotlight()).getText().contains(Constants.TITULO_CLIENTE_DESBORDADO_GEN_OTP)) {
            theActorInTheSpotlight().should(
                    seeThat(DesbordeQuestions.message(), containsString(Constants.MENSAJE_CLIENTE_DESBORDADO_GEN_OTP))
            );
          /*if (EnvironmentProperties.getProperty("webdriver.driver").equalsIgnoreCase("provided")) {
              BroserStackSerenityDriver.markTestStatus("Passed", Constants.MENSAJE_CLIENTE_DESBORDADO_GEN_OTP, Serenity.getDriver());
          }*/
            //}else if(DesbordePage.VALIDACION_MENSAJE_TITULO
        }
        if (DesbordePage.VALIDACION_MENSAJE_TITULO
                .resolveFor(theActorInTheSpotlight()).getText().contains(Constants.TITULO_CLIENTE_DESBORDADO_ER_TEC)) {
            theActorInTheSpotlight().should(
                    seeThat(DesbordeQuestions.message(), containsString(Constants.MENSAJE_CLIENTE_DESBORDADO_ER_TEC))
            );
          /*if (EnvironmentProperties.getProperty("webdriver.driver").equalsIgnoreCase("provided")) {
              BroserStackSerenityDriver.markTestStatus("Passed", Constants.MENSAJE_CLIENTE_DESBORDADO_ER_TEC, Serenity.getDriver());
          }*/
            //}else if(DesbordePage.VALIDACION_MENSAJE_TITULO
        }
        if (DesbordePage.VALIDACION_MENSAJE_TITULO
                .resolveFor(theActorInTheSpotlight()).getText().contains(Constants.TITULO_CLIENTE_DESBORDADO_ACTIVIDAD)) {
            theActorInTheSpotlight().should(
                    seeThat(DesbordeQuestions.message(), containsString(Constants.MENSAJE_CLIENTE_DESBORDADO_ACTIVIDAD))
            );
          /*if (EnvironmentProperties.getProperty("webdriver.driver").equalsIgnoreCase("provided")) {
              BroserStackSerenityDriver.markTestStatus("Passed", Constants.MENSAJE_CLIENTE_DESBORDADO_ER_TEC, Serenity.getDriver());
          }*/
            //}else{
        } else {
            theActorInTheSpotlight().should(
                    seeThat(DesbordeQuestions.message(), containsString(Constants.MENSAJE_CLIENTE_GENDESBORDE))
            );
          /*if (EnvironmentProperties.getProperty("webdriver.driver").equalsIgnoreCase("provided")) {
              BroserStackSerenityDriver.markTestStatus("Failed", Constants.MENSAJE_CLIENTE_GENDESBORDE, Serenity.getDriver());
          }*/
        }
        theActorInTheSpotlight().attemptsTo(
                Click.on(DesbordePage.BUTTON_DESBORDE),
                WaitUntil.the(AuthenticationClientPage.AUTHENTICATION_TITTLE, isPresent()).forNoMoreThan(60).seconds(),
                Ensure.that(AuthenticationClientPage.AUTHENTICATION_TITTLE).isDisplayed()
        );
    }

    @Entonces("verifica comportamiento desborde hasta pagina principal")
    public void verificaComportamientoDesbordeHastaPaginaPrincipal() {
        List<String> data = theActorInTheSpotlight().recall("desicion");
        if (data.get(0).equalsIgnoreCase("SI")) {
            theActorInTheSpotlight().should(
                    seeThat(DesbordeSecondClientSuccessQuestions.verify(), containsString(Constants.MENSAJE_DESBORDE_CLIENTE_DOS_SUMA))
            );
            /*if (EnvironmentProperties.getProperty("webdriver.driver").equalsIgnoreCase("provided")) {
                BroserStackSerenityDriver.markTestStatus("Passed", Constants.MENSAJE_DESBORDE_CLIENTE_DOS_SUMA, Serenity.getDriver());
            }*/
            //} else {
        } else {
            theActorInTheSpotlight().should(
                    seeThat(DesbordeSecondClientFailedQuestions.verify(), containsString(Constants.MENSAJE_DESBORDE_CLIENTE_DOS_INICIAL))
            );
            /*if (EnvironmentProperties.getProperty("webdriver.driver").equalsIgnoreCase("provided")) {
                BroserStackSerenityDriver.markTestStatus("Failed", Constants.MENSAJE_DESBORDE_CLIENTE_DOS_INICIAL, Serenity.getDriver());
            }*/
        }
    }
}
