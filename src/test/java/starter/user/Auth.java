package starter.user;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import java.util.UUID;


import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;


public class Auth {

    protected String url = "https://dev.healthify.my.id";


    private static String authToken;



//    Scenario: Verify send POST request to register user endpoint with valid full name, email, password
    @Step("I set register user API endpoint")
    public String setRegisterUserEndpoint(){
        return url + "/users/register";
    }

    @Step("I send POST HTTP request for register with valid request body")
    public void sendPostRegister(){
        JSONObject requestBody = new JSONObject();

        String email = "user" + UUID.randomUUID().toString() + "@gmail.com";


        requestBody.put("fullname", "Fernand Andrean");
        requestBody.put("email", email);
        requestBody.put("password", "a1234567890");


        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setRegisterUserEndpoint());

    }

    @Step("I receive HTTP response status code 201 Created")
    public void receiveResponseStatusCode201(){
        restAssuredThat(response -> response.statusCode(201));
    }

    @Step("I receive valid message that Registered Successful")
        public void validateMessageSuccessRegister(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("successfully created registeredCheck your email for OTP verification")));
    }


    @Step("I receive HTTP response status code 200 OK")
    public void receiveResponseStatusCode200OK(){
        restAssuredThat(response -> response.statusCode(200));
    }



//    Scenario: Verify send POST request to register user endpoint with invalid email format (without "@")
    @Step("I send POST HTTP request for register with invalid email format")
    public void sendPostRegisterInvalidEmail(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("fullname", "Fernand Andrean");
        requestBody.put("email", "salahgmail.com");
        requestBody.put("password", "a1234567890");

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setRegisterUserEndpoint());
    }
    @Step("Then I receive HTTP response status code 400 Bad Request")
    public void receiveResponseStatusCode400BadRequest(){
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step("And I receive valid message that Failed on Email Validation")
    public void validateMessageRegisterWithInvalidEmailFormat() {
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("Field 'Email' failed on 'email' validation")));
    }


//    Scenario: Verify send POST request to register user endpoint by using the registered email
    @Step("I send POST HTTP request for register with registered email")
    public void sendPostRegisteredEmail(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("fullname", "Fernand Andrean");
        requestBody.put("email", "registereduser@gmail.com");
        requestBody.put("password", "a1234567890");

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setRegisterUserEndpoint());
    }

    @Step("I receive HTTP response status code 409 Conflict")
    public void receiveResponseStatusCode409Conflict(){
        restAssuredThat(response -> response.statusCode(409));
    }

    @Step("I receive valid message that Email Already Exist")
    public void validateMessageRegisteedEmail() {
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("email already exists")));
    }



//    Scenario: Verify send POST request to login user endpoint with valid email, and password
    @Step("I set login user API endpoint")
    public String setLoginUserEndpoint(){
        return url + "/users/login";
    }
    @Step("I send POST HTTP request for login with valid request body")
    public void sendPostLoginValid(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("email", "pasienhealthify@gmail.com");
        requestBody.put("password", "a1234567890");

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setLoginUserEndpoint());

        Response response = SerenityRest.lastResponse();
        authToken = response.path("results.token");
    }

    @Step("I receive valid message that Login Successfull")
    public void validateMessageValidLogin(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("login successful")));
    }



//    Scenario: Verify send POST request to login user endpoint with unregistered email and valid password
    @Step("I send POST HTTP request for login with unregistered email")
    public void sendPostLoginUnregisteredEmail(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("email", "unregistered@gmail.com");
        requestBody.put("password", "a1234567890");

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setLoginUserEndpoint());
    }

    @Step("I receive HTTP response status code 401 Unauthorized")
    public void receiveResponseStatusCode401Unauthorized(){
        restAssuredThat(response -> response.statusCode(401));
    }

    @Step("I receive valid message that Email Not Registered")
    public void validateMessageLoginUnregisteredEmail(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("email not registered")));
    }


//    Scenario: Verify send POST request to login user endpoint with invalid email (without "@") and valid password
    @Step("I send POST HTTP request for login with invalid email format")
    public void sendPostLoginInvalidEmailFormat(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("email", "user5gmail.com");
        requestBody.put("password", "a1234567890");

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setLoginUserEndpoint());
    }



//    Scenario: Verify send DELETE request to delete user endpoint with valid login token
//    @Step("I set delete user API endpoint")
//    public String setDeleteUserEndpoint(){
//        return url + "/users";
//    }
//
//    @Step("I send DELETE HTTP request for delete user with valid login token")
//    public void sendDeleteUserValidToken(){
//        SerenityRest
//                .given()
//                .header("Authorization", "Bearer " + authToken)
//                .delete(setDeleteUserEndpoint());
//    }
//
//    @Step("I receive valid message that User Deleted Data Successful")
//    public void validateMessageSuccessDeleteUser(){
//        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("user deleted data successful")));
//
//        JSONObject requestBody = new JSONObject();
//
//        requestBody.put("fullname", "Fernand Andrean");
//        requestBody.put("email", "user5@gmail.com");
//        requestBody.put("password", "a1234567890");
//        SerenityRest.given()
//                .header("Content-Type","application/json")
//                .body(requestBody.toString())
//                .post(setRegisterUserEndpoint());
//
//    }


}
