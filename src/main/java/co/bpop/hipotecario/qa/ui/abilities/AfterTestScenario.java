package co.bpop.hipotecario.qa.ui.abilities;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import co.bpop.hipotecario.qa.ui.utilities.Constants;
import com.google.gson.Gson;
import lombok.*;
import co.bpop.hipotecario.qa.ui.abilities.models.StatusTest;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.webdriver.RemoteDriver;
import net.serenitybdd.core.webdriver.enhancers.AfterAWebdriverScenario;
import net.thucydides.core.model.TestOutcome;
import net.thucydides.core.util.EnvironmentVariables;

@Data
@Builder
public class AfterTestScenario implements AfterAWebdriverScenario {
    private static final Logger LOGGER = Logger.getLogger(AfterTestScenario.class.getName());

    @Override
    public void apply(EnvironmentVariables environmentVariables, TestOutcome testOutcome, WebDriver driver) {

        if ((driver == null) || (!RemoteDriver.isARemoteDriver(driver))) {
            return;
        }

        try {
            String sessionId = RemoteDriver.of(driver).getSessionId().toString();
            String username = environmentVariables.getProperty(Constants.LT_USER).toString();
            String accessKey = environmentVariables.getProperty(Constants.LT_KEY).toString();

            URI uri = new URI(Constants.PROTOCOL_HTTPS + username + ":" + accessKey
                    + Constants.LT_API_HUB + sessionId);
            HttpPatch putRequest = new HttpPatch(uri);
            String result = Constants.STATUS_COMPLETE;
            if (testOutcome.isSuccess().equals(true)) {
                result = Constants.STATUS_PASSED;
            } else if (testOutcome.isFailure().equals(true) || testOutcome.isError().equals(true) || testOutcome.isCompromised().equals(true)) {
                result = Constants.STATUS_FAILED;
            }

            StringEntity entity = new StringEntity(
                    new Gson().toJson(StatusTest.builder()
                            .name(testOutcome.getStoryTitle() + " - " + testOutcome.getTitle())
                            .statusInd(result)
                            .build())
            );
            putRequest.setEntity(entity);
            HttpClientBuilder.create().build().execute(putRequest);
        } catch (URISyntaxException | IOException e) {
            LOGGER.log(Level.WARN, "Interrupted!", e);
        }
    }

}