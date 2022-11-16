package co.bpop.hipotecario.qa.ui.screenplay.tasks;

import co.bpop.hipotecario.qa.ui.screenplay.userinterface.CargaPage;
import co.bpop.hipotecario.qa.ui.screenplay.userinterface.IncomingPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IncomingClient implements Task {

    String actividad;
    String contrato;
    String afiliacion;
    String convenio;
    String casaya;
    
    public IncomingClient(List<String> data){
        this.actividad = data.get(0);
        if (data.get(1)==null){
            this.contrato = "";
        }else{
            this.contrato = data.get(1);
        }

        if (data.get(2).equalsIgnoreCase("Si")){
            this.afiliacion = "2";
        }else{
            this.afiliacion = "1";
        }
        this.convenio = data.get(3);

        if (data.get(4).equalsIgnoreCase("Si")){
            this.casaya = "4";
        }else{
            this.casaya = "3";
        }

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember("convenio",convenio);
        if (actividad.equalsIgnoreCase("Empleado")) {
            actor.attemptsTo(
                WaitUntil.the(CargaPage.LOGOCARGA, isNotVisible())
                    .forNoMoreThan(240).seconds(),
                Click.on(IncomingPage.DROPDOWN_LIST_CLICK.of("1")),
                Click.on(IncomingPage.ACTIVITY_LIST.of(actividad)),
                Click.on(IncomingPage.DROPDOWN_LIST_CLICK.of("2")),
                Click.on(IncomingPage.ACTIVITY_LIST.of(contrato)),
                Click.on(IncomingPage.AFILIATE_CHECKBOX.of(afiliacion)),
                Click.on(IncomingPage.DROPDOWN_LIST_CLICK.of("3")),
                Click.on(IncomingPage.CONTRACT_CONV_LIST.of(convenio)),
                Click.on(IncomingPage.CASAYA_CHECKBOX.of(casaya)),
                Click.on(IncomingPage.CONTINUE_BUTTON)
            );
        } else {
            actor.attemptsTo(
                WaitUntil.the(CargaPage.LOGOCARGA, isNotVisible())
                    .forNoMoreThan(240).seconds(),
                Click.on(IncomingPage.DROPDOWN_LIST_CLICK.of("1")),
                Click.on(IncomingPage.ACTIVITY_LIST.of(actividad)),
                Click.on(IncomingPage.AFILIATE_CHECKBOX.of(afiliacion)),
                Click.on(IncomingPage.DROPDOWN_LIST_CLICK.of("2")),
                Click.on(IncomingPage.CONTRACT_CONV_LIST.of(convenio)),
                Click.on(IncomingPage.CASAYA_CHECKBOX.of(casaya)),
                Click.on(IncomingPage.CONTINUE_BUTTON)
            );
        }
    }

    public static IncomingClient with(List<String> data){
        return Tasks.instrumented(IncomingClient.class, data);
    }
}
