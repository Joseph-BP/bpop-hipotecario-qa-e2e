package co.bpop.hipotecario.qa.ui.screenplay.tasks;

import co.bpop.hipotecario.qa.ui.screenplay.userinterface.CargaPage;
import co.bpop.hipotecario.qa.ui.screenplay.userinterface.DataInmuPage;
import co.bpop.hipotecario.qa.ui.utilities.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DataHouse implements Task {

    String estado;
    String proyecto;
    String usoInmueble;
    String ciudad;
    String valor;
    String tipoInmueble;
    String subsidio;
    String credito;
    String tipoMonto;
    String monto;
    String tasaEfectiva;
    String plazo;
    String amortizacion;
    String convenio;

    public DataHouse(List<String> data){
        this.estado = data.get(0);
        if (data.get(0).equalsIgnoreCase(Constants.TIPO_PROYECTO_NUEVO)){
            this.proyecto = data.get(1);
        }else{
            this.proyecto = "";
        }
        if (data.get(2).equalsIgnoreCase("Residencial")){
            this.usoInmueble = "1";
        }else{
            this.usoInmueble = "2";
        }
        this.ciudad = data.get(3);
        this.valor = data.get(4);
        this.tipoInmueble = data.get(5);
        this.subsidio = data.get(6);
        if (data.get(7).equalsIgnoreCase("hipotecario")){
            this.credito = "3";
        }else{
            this.credito = "4";
        }
        if (data.get(8).equalsIgnoreCase("Pesos")){
            this.tipoMonto = "\\$";
        }else{
            this.tipoMonto = "%";
        }
        this.monto = data.get(9);
        this.plazo = data.get(10)+" años";
        this.tasaEfectiva = data.get(11);
        if (data.get(12).equalsIgnoreCase("Pesos")){
            this.amortizacion = "5";
        }else {
            this.amortizacion = "6";
        }
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        convenio = actor.recall("convenio");
        if (estado.equalsIgnoreCase(Constants.TIPO_PROYECTO_NUEVO)
            && tipoMonto.equalsIgnoreCase("%")
            && (!convenio.equalsIgnoreCase("Nuestra Causa")&&!convenio.equalsIgnoreCase("Caja Honor"))) {
            actor.attemptsTo(
                Click.on(DataInmuPage.STATUSINM.of(estado)),
                Click.on(DataInmuPage.DROPDOWN_LIST_CLICK.of("1")),
                Click.on(DataInmuPage.LISTAS_DDROPDOWN.of(proyecto)),
                Click.on(DataInmuPage.TOOLTIP_USO),
                Ensure.that(DataInmuPage.TOOLTIP_MESSAGE.of("2")).text().contains(Constants.TITULO_TOOLTIP_USO),
                Click.on(DataInmuPage.TOOLTIP_USO_CLOSE),
      
                Click.on(DataInmuPage.FINANCIAL_CHECKBOX.of(usoInmueble)),
                SendKeys.of(ciudad).into(DataInmuPage.CITY_INM_TEXT),
                Click.on(DataInmuPage.SELECCION_CIUDAD.of(ciudad.toUpperCase())),
                Enter.theValue(valor).into(DataInmuPage.VALUE_INM_TEXT),
                Click.on(DataInmuPage.DROPDOWN_LIST_CLICK.of("2")),
                Click.on(DataInmuPage.LISTAS_DDROPDOWN_TIPO_INMU.of(tipoInmueble)),
                Click.on(DataInmuPage.DROPDOWN_LIST_CLICK.of("3")),
                Click.on(DataInmuPage.LISTAS_DDROPDOWN.of(subsidio)),
                Click.on(DataInmuPage.FINANCIAL_CHECKBOX.of(credito)),
                Click.on(DataInmuPage.TIPO_MONTO.of(tipoMonto)),
                Click.on(DataInmuPage.DROPDOWN_LIST_CLICK.of("4")),
                Click.on(DataInmuPage.LISTAS_DROPDOWN_MONTO.of(monto)),
                Click.on(DataInmuPage.DROPDOWN_LIST_CLICK.of("5")),
                Click.on(DataInmuPage.LISTAS_DDROPDOWN.of(plazo)),

                Click.on(DataInmuPage.TOOLTIP_TASA),
                Ensure.that(DataInmuPage.TOOLTIP_MESSAGE.of("4")).text().contains(Constants.TITULO_TOOLTIP_TASA),
                Click.on(DataInmuPage.TOOLTIP_TASA_CLOSE),

                Enter.theValue(tasaEfectiva).into(DataInmuPage.ANNUALTAX_TEXT),
                Click.on(DataInmuPage.FINANCIAL_CHECKBOX.of(amortizacion)),
                WaitUntil.the(DataInmuPage.APROVE_BUTTON, isClickable()),
                Click.on(DataInmuPage.APROVE_BUTTON)
                );
        }else if (estado.equalsIgnoreCase(Constants.TIPO_PROYECTO_NUEVO)
            && (!convenio.equalsIgnoreCase("Nuestra Causa")&&!convenio.equalsIgnoreCase("Caja Honor"))){
            actor.attemptsTo(
                Click.on(DataInmuPage.STATUSINM.of(estado)),
                Click.on(DataInmuPage.DROPDOWN_LIST_CLICK.of("1")),
                Click.on(DataInmuPage.LISTAS_DDROPDOWN.of(proyecto)),

                Click.on(DataInmuPage.TOOLTIP_USO),

                Ensure.that(DataInmuPage.TOOLTIP_MESSAGE.of("2")).text().contains(Constants.TITULO_TOOLTIP_USO),
                Click.on(DataInmuPage.FINANCIAL_CHECKBOX.of(usoInmueble)),
                SendKeys.of(ciudad).into(DataInmuPage.CITY_INM_TEXT),
                Click.on(DataInmuPage.SELECCION_CIUDAD.of(ciudad.toUpperCase())),
                Enter.theValue(valor).into(DataInmuPage.VALUE_INM_TEXT),
                Click.on(DataInmuPage.DROPDOWN_LIST_CLICK.of("2")),
                Click.on(DataInmuPage.LISTAS_DDROPDOWN_TIPO_INMU.of(tipoInmueble)),
                Click.on(DataInmuPage.DROPDOWN_LIST_CLICK.of("3")),
                Click.on(DataInmuPage.LISTAS_DDROPDOWN.of(subsidio)),
                Click.on(DataInmuPage.FINANCIAL_CHECKBOX.of(credito)),
                Click.on(DataInmuPage.TIPO_MONTO.of(tipoMonto)),
                Enter.theValue(monto).into(DataInmuPage.MONTO_FINANCIA),
                Click.on(DataInmuPage.DROPDOWN_LIST_CLICK.of("5")),
                Click.on(DataInmuPage.LISTAS_DDROPDOWN.of(plazo)),

                Click.on(DataInmuPage.TOOLTIP_TASA),

                Ensure.that(DataInmuPage.TOOLTIP_MESSAGE.of("4")).text().contains(Constants.TITULO_TOOLTIP_TASA),
                Enter.theValue(tasaEfectiva).into(DataInmuPage.ANNUALTAX_TEXT),
                Click.on(DataInmuPage.FINANCIAL_CHECKBOX.of(amortizacion)),
                WaitUntil.the(DataInmuPage.APROVE_BUTTON, isClickable()),
                Click.on(DataInmuPage.APROVE_BUTTON)
            );
        } else if (estado.equalsIgnoreCase(Constants.TIPO_PROYECTO_USADO)
            || estado.equalsIgnoreCase(Constants.TIPO_PROYECTO_DEFINIR)
            &&tipoMonto.equalsIgnoreCase("%")
            && (!convenio.equalsIgnoreCase("Nuestra Causa")&&!convenio.equalsIgnoreCase("Caja Honor"))){
            actor.attemptsTo(
                Click.on(DataInmuPage.STATUSINM.of(estado)),

                Click.on(DataInmuPage.TOOLTIP_USO),

                Ensure.that(DataInmuPage.TOOLTIP_MESSAGE.of("2")).text().contains(Constants.TITULO_TOOLTIP_USO),
                Click.on(DataInmuPage.FINANCIAL_CHECKBOX.of(usoInmueble)),
                SendKeys.of(ciudad).into(DataInmuPage.CITY_INM_TEXT),
                Click.on(DataInmuPage.SELECCION_CIUDAD.of(ciudad.toUpperCase())),
                Enter.theValue(valor).into(DataInmuPage.VALUE_INM_TEXT),
                Click.on(DataInmuPage.DROPDOWN_LIST_CLICK.of("1")),
                Click.on(DataInmuPage.LISTAS_DDROPDOWN_TIPO_INMU.of(tipoInmueble)),
                Click.on(DataInmuPage.FINANCIAL_CHECKBOX.of(credito)),
                Click.on(DataInmuPage.TIPO_MONTO.of(tipoMonto)),
                Click.on(DataInmuPage.DROPDOWN_LIST_CLICK.of("2")),
                Click.on(DataInmuPage.LISTAS_DROPDOWN_MONTO.of(monto)),
                Click.on(DataInmuPage.DROPDOWN_LIST_CLICK.of("5")),
                Click.on(DataInmuPage.LISTAS_DDROPDOWN.of(plazo)),

                Click.on(DataInmuPage.TOOLTIP_TASA),

                Ensure.that(DataInmuPage.TOOLTIP_MESSAGE.of("4")).text().contains(Constants.TITULO_TOOLTIP_TASA),
                Enter.theValue(tasaEfectiva).into(DataInmuPage.ANNUALTAX_TEXT),
                Click.on(DataInmuPage.FINANCIAL_CHECKBOX.of(amortizacion)),
                WaitUntil.the(DataInmuPage.APROVE_BUTTON, isClickable()),
                Click.on(DataInmuPage.APROVE_BUTTON)
            );
        }else if (estado.equalsIgnoreCase(Constants.TIPO_PROYECTO_USADO)
            || estado.equalsIgnoreCase(Constants.TIPO_PROYECTO_DEFINIR)
            && (!convenio.equalsIgnoreCase("Nuestra Causa")&&!convenio.equalsIgnoreCase("Caja Honor"))) {
            actor.attemptsTo(
                Click.on(DataInmuPage.STATUSINM.of(estado)),

                Click.on(DataInmuPage.TOOLTIP_USO),

                Ensure.that(DataInmuPage.TOOLTIP_MESSAGE.of("2")).text().contains(Constants.TITULO_TOOLTIP_USO),
                Click.on(DataInmuPage.FINANCIAL_CHECKBOX.of(usoInmueble)),
                SendKeys.of(ciudad).into(DataInmuPage.CITY_INM_TEXT),
                Click.on(DataInmuPage.SELECCION_CIUDAD.of(ciudad.toUpperCase())),
                Enter.theValue(valor).into(DataInmuPage.VALUE_INM_TEXT),
                Click.on(DataInmuPage.DROPDOWN_LIST_CLICK.of("1")),
                Click.on(DataInmuPage.LISTAS_DDROPDOWN_TIPO_INMU.of(tipoInmueble)),
                Click.on(DataInmuPage.FINANCIAL_CHECKBOX.of(credito)),
                Click.on(DataInmuPage.TIPO_MONTO.of(tipoMonto)),
                Enter.theValue(monto).into(DataInmuPage.MONTO_FINANCIA),
                Click.on(DataInmuPage.DROPDOWN_LIST_CLICK.of("5")),
                Click.on(DataInmuPage.LISTAS_DDROPDOWN.of(plazo)),

                Click.on(DataInmuPage.TOOLTIP_TASA),

                Ensure.that(DataInmuPage.TOOLTIP_MESSAGE.of("4")).text().contains(Constants.TITULO_TOOLTIP_TASA),
                Enter.theValue(tasaEfectiva).into(DataInmuPage.ANNUALTAX_TEXT),
                Click.on(DataInmuPage.FINANCIAL_CHECKBOX.of(amortizacion)),
                WaitUntil.the(DataInmuPage.APROVE_BUTTON, isClickable()),
                Click.on(DataInmuPage.APROVE_BUTTON)
            );
        }else if (estado.equalsIgnoreCase(Constants.TIPO_PROYECTO_NUEVO)
            && tipoMonto.equalsIgnoreCase("%")
            && (convenio.equalsIgnoreCase("Nuestra Causa")||convenio.equalsIgnoreCase("Caja Honor"))) {
            actor.attemptsTo(
                Click.on(DataInmuPage.STATUSINM.of(estado)),
                Click.on(DataInmuPage.DROPDOWN_LIST_CLICK.of("1")),
                Click.on(DataInmuPage.LISTAS_DDROPDOWN.of(proyecto)),

                Click.on(DataInmuPage.TOOLTIP_USO),

                Ensure.that(DataInmuPage.TOOLTIP_MESSAGE.of("2")).text().contains(Constants.TITULO_TOOLTIP_USO),
                Click.on(DataInmuPage.FINANCIAL_CHECKBOX.of(usoInmueble)),
                SendKeys.of(ciudad).into(DataInmuPage.CITY_INM_TEXT),
                Click.on(DataInmuPage.SELECCION_CIUDAD.of(ciudad.toUpperCase())),
                Enter.theValue(valor).into(DataInmuPage.VALUE_INM_TEXT),
                Click.on(DataInmuPage.DROPDOWN_LIST_CLICK.of("2")),
                Click.on(DataInmuPage.LISTAS_DDROPDOWN_TIPO_INMU.of(tipoInmueble)),
                Click.on(DataInmuPage.DROPDOWN_LIST_CLICK.of("3")),
                Click.on(DataInmuPage.LISTAS_DDROPDOWN.of(subsidio)),
                Click.on(DataInmuPage.FINANCIAL_CHECKBOX.of(credito)),
                Click.on(DataInmuPage.TIPO_MONTO.of(tipoMonto)),
                Click.on(DataInmuPage.DROPDOWN_LIST_CLICK.of("4")),
                Click.on(DataInmuPage.LISTAS_DROPDOWN_MONTO.of(monto)),
                Click.on(DataInmuPage.DROPDOWN_LIST_CLICK.of("5")),
                Click.on(DataInmuPage.LISTAS_DDROPDOWN.of(plazo)),

                Click.on(DataInmuPage.TOOLTIP_TASA),

                Ensure.that(DataInmuPage.TOOLTIP_MESSAGE.of("4")).text().contains(Constants.TITULO_TOOLTIP_TASA),
                Enter.theValue(tasaEfectiva).into(DataInmuPage.ANNUALTAX_TEXT),
                Click.on(DataInmuPage.FINANCIAL_CHECKBOX.of(amortizacion)),
                WaitUntil.the(DataInmuPage.APROVE_BUTTON, isClickable()),
                Click.on(DataInmuPage.APROVE_BUTTON)
            );
        }else if (estado.equalsIgnoreCase(Constants.TIPO_PROYECTO_NUEVO)
            && (convenio.equalsIgnoreCase("Nuestra Causa")||convenio.equalsIgnoreCase("Caja Honor"))){
            actor.attemptsTo(
                Click.on(DataInmuPage.STATUSINM.of(estado)),
                Click.on(DataInmuPage.DROPDOWN_LIST_CLICK.of("1")),
                Click.on(DataInmuPage.LISTAS_DDROPDOWN.of(proyecto)),

                Click.on(DataInmuPage.TOOLTIP_USO),

                Ensure.that(DataInmuPage.TOOLTIP_MESSAGE.of("2")).text().contains(Constants.TITULO_TOOLTIP_USO),
                Click.on(DataInmuPage.FINANCIAL_CHECKBOX.of(usoInmueble)),
                SendKeys.of(ciudad).into(DataInmuPage.CITY_INM_TEXT),
                Click.on(DataInmuPage.SELECCION_CIUDAD.of(ciudad.toUpperCase())),
                Enter.theValue(valor).into(DataInmuPage.VALUE_INM_TEXT),
                Click.on(DataInmuPage.DROPDOWN_LIST_CLICK.of("2")),
                Click.on(DataInmuPage.LISTAS_DDROPDOWN_TIPO_INMU.of(tipoInmueble)),
                Click.on(DataInmuPage.DROPDOWN_LIST_CLICK.of("3")),
                Click.on(DataInmuPage.LISTAS_DDROPDOWN.of(subsidio)),
                Click.on(DataInmuPage.FINANCIAL_CHECKBOX.of(credito)),
                Click.on(DataInmuPage.TIPO_MONTO.of(tipoMonto)),
                Enter.theValue(monto).into(DataInmuPage.MONTO_FINANCIA),
                Click.on(DataInmuPage.DROPDOWN_LIST_CLICK.of("5")),
                Click.on(DataInmuPage.LISTAS_DDROPDOWN.of(plazo)),

                Click.on(DataInmuPage.TOOLTIP_TASA),

                Ensure.that(DataInmuPage.TOOLTIP_MESSAGE.of("4")).text().contains(Constants.TITULO_TOOLTIP_TASA),
                Enter.theValue(tasaEfectiva).into(DataInmuPage.ANNUALTAX_TEXT),
                Click.on(DataInmuPage.FINANCIAL_CHECKBOX.of(amortizacion)),
                WaitUntil.the(DataInmuPage.APROVE_BUTTON, isClickable()),
                Click.on(DataInmuPage.APROVE_BUTTON)
            );
        } else if (estado.equalsIgnoreCase(Constants.TIPO_PROYECTO_USADO)
            || estado.equalsIgnoreCase(Constants.TIPO_PROYECTO_DEFINIR)
            &&tipoMonto.equalsIgnoreCase("%")
            && (convenio.equalsIgnoreCase("Nuestra Causa")||convenio.equalsIgnoreCase("Caja Honor"))){
            actor.attemptsTo(
                Click.on(DataInmuPage.STATUSINM.of(estado)),

                Click.on(DataInmuPage.TOOLTIP_USO),

                Ensure.that(DataInmuPage.TOOLTIP_MESSAGE.of("2")).text().contains(Constants.TITULO_TOOLTIP_USO),
                Click.on(DataInmuPage.FINANCIAL_CHECKBOX.of(usoInmueble)),
                SendKeys.of(ciudad).into(DataInmuPage.CITY_INM_TEXT),
                Click.on(DataInmuPage.SELECCION_CIUDAD.of(ciudad.toUpperCase())),
                Enter.theValue(valor).into(DataInmuPage.VALUE_INM_TEXT),
                Click.on(DataInmuPage.DROPDOWN_LIST_CLICK.of("1")),
                Click.on(DataInmuPage.LISTAS_DDROPDOWN_TIPO_INMU.of(tipoInmueble)),
                Click.on(DataInmuPage.FINANCIAL_CHECKBOX.of(credito)),
                Click.on(DataInmuPage.TIPO_MONTO.of(tipoMonto)),
                Click.on(DataInmuPage.DROPDOWN_LIST_CLICK.of("2")),
                Click.on(DataInmuPage.LISTAS_DROPDOWN_MONTO.of(monto)),
                Click.on(DataInmuPage.DROPDOWN_LIST_CLICK.of("5")),
                Click.on(DataInmuPage.LISTAS_DDROPDOWN.of(plazo)),

                Click.on(DataInmuPage.TOOLTIP_TASA),

                Ensure.that(DataInmuPage.TOOLTIP_MESSAGE.of("4")).text().contains(Constants.TITULO_TOOLTIP_TASA),
                Enter.theValue(tasaEfectiva).into(DataInmuPage.ANNUALTAX_TEXT),
                Click.on(DataInmuPage.FINANCIAL_CHECKBOX.of(amortizacion)),
                WaitUntil.the(DataInmuPage.APROVE_BUTTON, isClickable()),
                Click.on(DataInmuPage.APROVE_BUTTON)
            );
        }else if (estado.equalsIgnoreCase(Constants.TIPO_PROYECTO_USADO)
            || estado.equalsIgnoreCase(Constants.TIPO_PROYECTO_DEFINIR)
            && (convenio.equalsIgnoreCase("Nuestra Causa")||convenio.equalsIgnoreCase("Caja Honor"))) {
            actor.attemptsTo(
                Click.on(DataInmuPage.STATUSINM.of(estado)),

                Click.on(DataInmuPage.TOOLTIP_USO),

                Ensure.that(DataInmuPage.TOOLTIP_MESSAGE.of("2")).text().contains(Constants.TITULO_TOOLTIP_USO),
                Click.on(DataInmuPage.FINANCIAL_CHECKBOX.of(usoInmueble)),
                SendKeys.of(ciudad).into(DataInmuPage.CITY_INM_TEXT),
                Click.on(DataInmuPage.SELECCION_CIUDAD.of(ciudad.toUpperCase())),
                Enter.theValue(valor).into(DataInmuPage.VALUE_INM_TEXT),
                Click.on(DataInmuPage.DROPDOWN_LIST_CLICK.of("1")),
                Click.on(DataInmuPage.LISTAS_DDROPDOWN_TIPO_INMU.of(tipoInmueble)),
                Click.on(DataInmuPage.FINANCIAL_CHECKBOX.of(credito)),
                Click.on(DataInmuPage.TIPO_MONTO.of(tipoMonto)),
                Enter.theValue(monto).into(DataInmuPage.MONTO_FINANCIA),
                Click.on(DataInmuPage.DROPDOWN_LIST_CLICK.of("5")),
                Click.on(DataInmuPage.LISTAS_DDROPDOWN.of(plazo)),

                Click.on(DataInmuPage.TOOLTIP_TASA),

                Ensure.that(DataInmuPage.TOOLTIP_MESSAGE.of("4")).text().contains(Constants.TITULO_TOOLTIP_TASA),
                Enter.theValue(tasaEfectiva).into(DataInmuPage.ANNUALTAX_TEXT),
                Click.on(DataInmuPage.FINANCIAL_CHECKBOX.of(amortizacion)),
                WaitUntil.the(DataInmuPage.APROVE_BUTTON, isClickable()),
                Click.on(DataInmuPage.APROVE_BUTTON)
            );
        }
    }

    public static DataHouse fillInformation(List<String> data){
        return Tasks.instrumented(DataHouse.class, data);
    }
}
