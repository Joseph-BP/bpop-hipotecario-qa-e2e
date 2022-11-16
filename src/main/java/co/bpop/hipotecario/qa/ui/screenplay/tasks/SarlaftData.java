package co.bpop.hipotecario.qa.ui.screenplay.tasks;

import co.bpop.hipotecario.qa.ui.screenplay.userinterface.SarlaftPage;
import co.bpop.hipotecario.qa.ui.utilities.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class SarlaftData implements Task {

    private String fiscal;
    private String tin;
    private String international;
    private String producto;
    private String entidad;
    private String moneda;
    private String monto;
    private String pais;
    private String ciudadEstado;
    private String cuenta;

    public SarlaftData(List<String> data){
        if (data.get(0).equalsIgnoreCase("SI")){
            this.fiscal = "2";
            this.tin = data.get(1);
        }else if (data.get(0).equalsIgnoreCase("NO")){
            this.fiscal = "1";
            this.tin = "";
        }
        if (data.get(2).equalsIgnoreCase("SI")){
            this.international = "2";
            this.producto = data.get(3);
            this.entidad = data.get(4);
            this.moneda = data.get(5);
            this.monto = data.get(6);
            this.pais = data.get(7);
            this.ciudadEstado = data.get(8);
            this.cuenta = data.get(9);
        }else if (data.get(2).equalsIgnoreCase("NO")){
            this.international = "1";
            this.producto = "";
            this.entidad = "";
            this.moneda = "";
            this.monto = "";
            this.pais = "";
            this.ciudadEstado = "";
            this.cuenta = "";
        }
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (fiscal.equalsIgnoreCase("2") && international.equalsIgnoreCase("1")){
            actor.attemptsTo(
                WaitUntil.the(SarlaftPage.RESIDENT_FISCAL_CHECKBOX.of(fiscal), isPresent())
                    .forNoMoreThan(120).seconds(),
                Ensure.that(SarlaftPage.TITLE_SARLAFT).isDisplayed()
                        .orElseThrow(new Throwable(Constants.MENSAJE_CLIENTE_DESBORDADO)),
                Click.on(SarlaftPage.RESIDENT_FISCAL_CHECKBOX.of(fiscal)),
                Enter.theValue(tin).into(SarlaftPage.TINSSN),
                Click.on(SarlaftPage.CONTINUE_BUTTON)
            );
        }else if (fiscal.equalsIgnoreCase("1") && international.equalsIgnoreCase("2")){
            actor.attemptsTo(
                WaitUntil.the(SarlaftPage.RESIDENT_FISCAL_CHECKBOX.of(fiscal), isPresent())
                    .forNoMoreThan(120).seconds(),
                Ensure.that(SarlaftPage.TITLE_SARLAFT).isDisplayed()
                    .orElseThrow(new Throwable(Constants.MENSAJE_CLIENTE_DESBORDADO)),
                Click.on(SarlaftPage.RESIDENT_FISCAL_CHECKBOX.of(fiscal)),
                Click.on(SarlaftPage.OPERATION_INTERNATIONAL_CHECKBOX.of(international)),
                Enter.theValue(producto).into(SarlaftPage.TIPO_PRODUCTO),
                Enter.theValue(entidad).into(SarlaftPage.ENTIDAD),
                Click.on(SarlaftPage.MONEDA),
                Click.on(SarlaftPage.MONEDA_PAIS_LISTA.of(moneda)),
                Enter.theValue(monto).into(SarlaftPage.MONTO),
                Click.on(SarlaftPage.PAIS),
                Click.on(SarlaftPage.MONEDA_PAIS_LISTA.of(pais)),
                Enter.theValue(ciudadEstado).into(SarlaftPage.CIUDAD),
                Enter.theValue(cuenta).into(SarlaftPage.CUENTA),
                Click.on(SarlaftPage.CONTINUE_BUTTON)
            );
        } else if (fiscal.equalsIgnoreCase("2") && international.equalsIgnoreCase("2")){
            actor.attemptsTo(
                WaitUntil.the(SarlaftPage.RESIDENT_FISCAL_CHECKBOX.of(fiscal), isPresent())
                    .forNoMoreThan(120).seconds(),
                Ensure.that(SarlaftPage.TITLE_SARLAFT).isDisplayed()
                    .orElseThrow(new Throwable(Constants.MENSAJE_CLIENTE_DESBORDADO)),
                Click.on(SarlaftPage.RESIDENT_FISCAL_CHECKBOX.of(fiscal)),
                Enter.theValue(tin).into(SarlaftPage.TINSSN),
                Click.on(SarlaftPage.OPERATION_INTERNATIONAL_CHECKBOX.of(international)),
                Enter.theValue(producto).into(SarlaftPage.TIPO_PRODUCTO),
                Enter.theValue(entidad).into(SarlaftPage.ENTIDAD),
                Click.on(SarlaftPage.MONEDA),
                Click.on(SarlaftPage.MONEDA_PAIS_LISTA.of(moneda)),
                Enter.theValue(monto).into(SarlaftPage.MONTO),
                Click.on(SarlaftPage.PAIS),
                Click.on(SarlaftPage.MONEDA_PAIS_LISTA.of(pais)),
                Enter.theValue(ciudadEstado).into(SarlaftPage.CIUDAD),
                Enter.theValue(cuenta).into(SarlaftPage.CUENTA),
                Click.on(SarlaftPage.CONTINUE_BUTTON)
            );
        } else if (fiscal.equalsIgnoreCase("1") && international.equalsIgnoreCase("1")){
            actor.attemptsTo(
                WaitUntil.the(SarlaftPage.RESIDENT_FISCAL_CHECKBOX.of(fiscal), isPresent())
                    .forNoMoreThan(120).seconds(),
                Ensure.that(SarlaftPage.TITLE_SARLAFT).isDisplayed()
                    .orElseThrow(new Throwable(Constants.MENSAJE_CLIENTE_DESBORDADO)),
                Click.on(SarlaftPage.CONTINUE_BUTTON)
            );
        }

    }
    public static SarlaftData fiscalAndInternational(List<String> data){
        return Tasks.instrumented(SarlaftData.class, data);
    }
}
