package co.bpop.hipotecario.qa.ui.screenplay.tasks;

import co.bpop.hipotecario.qa.ui.screenplay.userinterface.DesbordePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class EsperaInactividadSesion implements Task {

    private int time;

    public EsperaInactividadSesion(String time){
        this.time = Integer.parseInt(time)*61;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(DesbordePage.VALIDACION_MENSAJE_TITULO, isCurrentlyVisible())
                .forNoMoreThan(time).seconds()
        );
    }
    public static EsperaInactividadSesion porTiempo(String time){
        return Tasks.instrumented(EsperaInactividadSesion.class,time);
    }
}
