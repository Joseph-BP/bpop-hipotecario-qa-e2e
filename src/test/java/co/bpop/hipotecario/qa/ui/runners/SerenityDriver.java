package co.bpop.hipotecario.qa.ui.runners;

import java.net.URL;
import java.security.SecureRandom;
import java.util.HashMap;

import co.bpop.hipotecario.qa.ui.utilities.Constants;
import com.lambdatest.tunnel.Tunnel;
import io.appium.java_client.AppiumDriver;
import lombok.Data;
import net.thucydides.core.steps.StepEventBus;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.DriverSource;

@Data
public class SerenityDriver implements DriverSource {
    private static final Logger LOGGER = Logger.getLogger(SerenityDriver.class.getName());
    private static String device = null;
    private static final String ID_TUNNEL = Constants.PROJECT + (new SecureRandom().nextLong() * (99999 - 1 + 1) + 1 + "").replace(".", "-");
    private static Tunnel tunnel = null;
    private RemoteWebDriver driver = null;
    boolean lt = false;

    public WebDriver newDriver() {

        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        StepEventBus.getEventBus().getBaseStepListener().getCurrentTestOutcome().setContext(environmentVariables.getProperty("parallel." + device + ".browserName").toLowerCase());
        HashMap<String, Object> ltOptions = new HashMap<>();

        environmentVariables.getPropertiesWithPrefix("farm").forEach((keyValue, value) -> {
            if (((String) keyValue).contains("lt.")) {
                this.lt = true;
                ltOptions.put(((String) keyValue).split("\\.")[((String) keyValue).split("\\.").length - 1], value);
            } else if (((String) keyValue).contains("bs.")) {
                capabilities.setCapability(((String) keyValue).split("\\.")[((String) keyValue).split("\\.").length - 1], value);
            }
        });
        environmentVariables.getPropertiesWithPrefix("parallel." + device).forEach((keyValue, value) -> {
            if (((String) keyValue).contains("lt.")) {
                this.lt = true;
                ltOptions.put(((String) keyValue).split("\\.")[((String) keyValue).split("\\.").length - 1], value);
            } else {
                capabilities.setCapability(((String) keyValue).split("\\.")[((String) keyValue).split("\\.").length - 1], value);
            }
        });

        try {
            HashMap<String, String> options = new HashMap<>();
            options.put(Constants.LT_WORD_USER, (String) environmentVariables.getProperty(Constants.LT_USER));
            options.put(Constants.LT_TUNNEL, SerenityDriver.ID_TUNNEL);
            options.put(Constants.LT_WORD_KEY, (String) environmentVariables.getProperty(Constants.LT_KEY));
            if (tunnel == null) {
                tunnel = new Tunnel();
                tunnel.start(options);
            }
            ltOptions.put(Constants.LT_TUNNEL, ID_TUNNEL);
            capabilities.setCapability(Constants.LT_TUNNEL, ID_TUNNEL);
        } catch (Exception e) {
            LOGGER.log(Level.INFO, "Interrupted!", e);
        }

        if (lt) {
            capabilities.setCapability(Constants.LT_OPTION, ltOptions);
        }
        try {
            if (environmentVariables.getProperty(Constants.FARM_DEVICES).equals(Constants.TYPE_DEVICES)) {
                driver = new RemoteWebDriver(new URL(Constants.PROTOCOL_HTTP + (String) environmentVariables.getProperty(Constants.LT_USER)
                        + ":" + (String) environmentVariables.getProperty(Constants.LT_KEY) + "@" + (String) environmentVariables.getProperty(Constants.LT_GRID)), capabilities);
            } else {
                driver = new AppiumDriver(new URL(Constants.PROTOCOL_HTTP + (String) environmentVariables.getProperty(Constants.LT_USER)
                        + ":" + (String) environmentVariables.getProperty(Constants.LT_KEY) + "@" + (String) environmentVariables.getProperty(Constants.LT_GRID)), capabilities);
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARN, "Interrupted!", e);
        }
        return driver;
    }

    public boolean takesScreenshots() {
        return false;
    }

    public static void setDevice(String device) {
        SerenityDriver.device = device;
    }

    public static Tunnel getTunnel() {
        return tunnel;
    }
}