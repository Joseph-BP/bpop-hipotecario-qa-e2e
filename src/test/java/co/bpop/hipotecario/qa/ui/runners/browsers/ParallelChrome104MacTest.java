package co.bpop.hipotecario.qa.ui.runners.browsers;

import co.bpop.hipotecario.qa.ui.runners.SerenityDriver;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features",
        glue = "co/bpop/hipotecario/qa/ui/steps",
        tags = "@Flujo_cliente_uno"
)
public class ParallelChrome104MacTest {

    @BeforeClass
    public static void setUp() throws Exception {
        SerenityDriver.setDevice("CHROME_104_MAC");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        SerenityDriver.getTunnel().stop();
    }

}