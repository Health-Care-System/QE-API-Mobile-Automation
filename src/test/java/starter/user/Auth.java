package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;


public class Auth {

    protected String url = "https://altashop-api.fly.dev/api";

    @Step("I set register API endpoint")
    public String setRegisterEndpoint(){
        return url + "/auth/register";
    }

    @Step("I send POST HTTP request for register")
    public void sendPostRegister(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("email", "dohc964563498@gmail.com");
        requestBody.put("password", "abcde");
        requestBody.put("fullname", "Andre");

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setRegisterEndpoint());
    }

    @Step("I receive HTTP response status code 200 OK")
    public void receiveResponseStatusCode200OK(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I set login API endpoint")
    public String setLoginEndpoint(){
        return url + "/auth/login";
    }

    @Step("I send POST HTTP request for login")
    public void sendPostLogin(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("email", "dohc3297@gmail.com");
        requestBody.put("password", "abcde");

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setLoginEndpoint());
    }

//    @Then("I receive login token")

    @Step("I set user information API endpoint")
    public String setUserInfoEndpoint(){
        return url + "/auth/info";
    }

    @Step("I send GET HTTP request for user information")
    public void sendGetUserInfo(){
        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuZHJlYW4iLCJFbWFpbCI6ImRvaGM5MDkwQGdtYWlsLmNvbSJ9.zqsZ7AVEey4afO657sxkS8vr7Mik4xnpKUgmFZAoULE")
                .get(setUserInfoEndpoint());
    }


}
