package co.bpop.hipotecario.qa.ui.utilities.apis;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import io.restassured.response.Response;

public class AuthenticationAWS {
    private Response response;
    private String token;

    @Step
    public String withToken(String url){
        if (url.contains("dev")) {
            response = SerenityRest.given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Accept", "application/json")
                .body("grant_type=client_credentials" +
                    "&client_id=ti7vfacoku0uhtnugl8p4h5h3" +
                    "&client_secret=qui24ss24qj25gq415o6n8cqqkbro0t6qogeju05i942ju84uv5" +
                    "&scope=gb-hipotecario-dev-auth-api/authorization/authorization")
                .post("https://gb-hipotecario-dev.auth.us-east-2.amazoncognito.com/oauth2/token");
            response.then()
                .log().ifValidationFails().assertThat().statusCode(200);
            token = response.then().extract().path("access_token");
        }else if (url.contains("stg")) {
            response = SerenityRest.given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Accept", "application/json")
                .body("grant_type=client_credentials" +
                    "&client_id=60oa66nnbhc86igk35t39oijvk" +
                    "&client_secret=14hrnpejtje67l35amfrlbi5phnluj17a1t7brqq6rcpm338s90m" +
                    "&scope=gb-hipotecario-stg-auth-api/authorization/authorization")
                .post("https://gb-hipotecario-stg.auth.us-east-2.amazoncognito.com/oauth2/token");
            response.then()
                .log().ifValidationFails().assertThat().statusCode(200);
            token = response.then().extract().path("access_token");
        }
        return url+"?token="+token;
    }
}
