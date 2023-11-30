package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Auth;

public class AuthSteps {

    @Steps
    Auth auth;

    @Given("I set register API endpoint")
    public void setValidRegisterEndpoint(){
        auth.setRegisterEndpoint();
    }

    @When("I send POST HTTP request for register")
    public void successSendPostRegister(){
        auth.sendPostRegister();
    }

    @Then("I receive HTTP response status code 200 OK")
    public void validateStatus200OK(){
        auth.receiveResponseStatusCode200OK();
    }


    @Given("I set login API endpoint")
    public void setValidLogin(){
        auth.setLoginEndpoint();
    }

    @When("I send POST HTTP request for login")
    public void successSendPostLogin(){
        auth.sendPostLogin();
    }

    @Given("I set user information API endpoint")
    public void setValidUserInfo(){
        auth.setUserInfoEndpoint();
    }

    @When("I send GET HTTP request for user information")
    public void successSendGetUserInfo(){
        auth.sendGetUserInfo();
    }



}
