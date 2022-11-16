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
        //tags = "@Creacion_Link_Autenticacion"
        //tags = "@Flujo_cliente_uno"
        tags = "@Flujo_cliente_uno_y_dos"
        //tags = "@Flujo_cliente_uno_fallo_generacion_otp"
        //tags = "@Flujo_cliente_uno_fallo_validacion_otp"
        //tags = "@Flujo_cliente_uno_y_dos_fallo_generacion_otp"
        //tags = "@Flujo_cliente_uno_y_dos_fallo_validacion_otp"
)
public class ParallelChrome104Test {

    @BeforeClass
    public static void setUp() throws Exception {
        SerenityDriver.setDevice("CHROME_104_WIN");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        SerenityDriver.getTunnel().stop();
    }

}