package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Auth;

public class AuthSteps {

    @Steps
    Auth auth;

    //    Scenario: Verify send POST request to register user endpoint with valid full name, email, password
    @Given("I set register user API endpoint")
    public void setValidRegisterEndpoint(){
        auth.setRegisterUserEndpoint();
    }

    @When("I send POST HTTP request for register with valid request body")
    public void successSendPostRegister(){
        auth.sendPostRegister();
    }

    @Then("I receive HTTP response status code 201 Created")
    public void validateStatusCode201(){
        auth.receiveResponseStatusCode201();
    }


    @And("I receive valid message that Registered Successful")
    public void receiveMessageSuccessRegister(){
        auth.validateMessageSuccessRegister();
    }

//    Scenario: Verify send POST request to register user endpoint with invalid email format (without "@")
    @When("I send POST HTTP request for register with invalid email format")
    public  void successSendPostRegisterWithInvalidEmailFormat(){
        auth.sendPostRegisterInvalidEmail();
    }
    @Then("I receive HTTP response status code 400 Bad Request")
    public void validateStatus400BadRequest(){
        auth.receiveResponseStatusCode400BadRequest();
    }

    @And("I receive valid message that Failed on Email Validation")
    public void receiveMessageFailedOnEmailValidation(){
        auth.validateMessageRegisterWithInvalidEmailFormat();
    }


//    Scenario: Verify send POST request to register user endpoint by using the registered email
    @When("I send POST HTTP request for register with registered email")
    public void successSendPostRegisteredEmail(){
        auth.sendPostRegisteredEmail();
    }

    @Then("I receive HTTP response status code 409 Conflict")
    public void validateStatus409Conflict(){
        auth.receiveResponseStatusCode409Conflict();
    }

    @And("I receive valid message that Email Already Exist")
    public void receiveMessageEmailAlreadyExist(){
        auth.validateMessageRegisteedEmail();
    }


//    Scenario: Verify send POST request to login user endpoint with valid email, and password
    @Given("I set login user API endpoint")
    public void setValidLoginUserEndpoint(){
        auth.setLoginUserEndpoint();
    }
    @When("I send POST HTTP request for login with valid request body")
    public void successSendPostLoginValid(){
        auth.sendPostLoginValid();
    }

    @And("I receive valid message that Login Successfull")
    public void receiveMessageLoginSuccessfull(){
        auth.validateMessageValidLogin();
    }

//    Scenario: Verify send POST request to login user endpoint with unregistered email and valid password
    @When("I send POST HTTP request for login with unregistered email")
    public void successSendPostLoginUnregisteredEmail(){
        auth.sendPostLoginUnregisteredEmail();
    }

    @Then("I receive HTTP response status code 401 Unauthorized")
    public void validateStatus401Unauthorized(){
        auth.receiveResponseStatusCode401Unauthorized();
    }

    @And("I receive valid message that Email Not Registered")
    public void receiveMessageEmailNotRegistered(){
        auth.validateMessageLoginUnregisteredEmail();
    }


//    Scenario: Verify send POST request to login user endpoint with invalid email (without "@") and valid password
    @When("I send POST HTTP request for login with invalid email format")
    public void successSendPostLoginInvalidEmailFormat(){
        auth.sendPostLoginInvalidEmailFormat();
    }


//    Scenario: Verify send DELETE request to delete user endpoint with valid login token
//    @Given("I set delete user API endpoint")
//    public void setValidDeleteUserEndpoint(){
//        auth.setDeleteUserEndpoint();
//    }
//
//    @When("I send DELETE HTTP request for delete user with valid login token")
//    public void successSendDeleteUserValidToken(){
//        auth.sendDeleteUserValidToken();
//    }
//
//    @And("I receive valid message that User Deleted Data Successful")
//    public void receiveMessageUserDeletedDataSuccessful(){
//        auth.validateMessageSuccessDeleteUser();
//    }


    @Then("I receive HTTP response status code 200 OK")
    public void validateStatus200OK(){
        auth.receiveResponseStatusCode200OK();
    }


}
