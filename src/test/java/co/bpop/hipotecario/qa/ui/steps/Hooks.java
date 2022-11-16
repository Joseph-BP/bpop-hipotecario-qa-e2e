package co.bpop.hipotecario.qa.ui.steps;

import co.bpop.hipotecario.qa.ui.abilities.AfterTestScenario;
import io.cucumber.java.After;
import net.serenitybdd.core.annotations.events.AfterScenario;
import net.thucydides.core.steps.StepEventBus;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

public class Hooks {
    @After
    public void afterScenario()  {
        AfterTestScenario.builder().build().apply(
                SystemEnvironmentVariables.createEnvironmentVariables(),
                StepEventBus.getEventBus().getBaseStepListener().getCurrentTestOutcome(),
                ThucydidesWebDriverSupport.getWebdriverManager().getCurrentDriver());
    }
}
