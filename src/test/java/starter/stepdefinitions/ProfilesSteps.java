package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Auth;
import starter.user.Profiles;

public class ProfilesSteps {

    @Steps
    Profiles profiles;

//    @Steps
//    Auth auth;
//
//    //    Login First
//
//    @Given("I set login user API endpoint before update")
//    public void setValidLoginFirstEndpoint(){
//        profiles.setValidLoginBeforeUpdate();
//    }
//
//    @When("I send POST HTTP request for login with valid request body before update profiles")
//    public void successSendPostLoginFirst(){
//        profiles.sendPostLoginValidBeforeUpdateProfile();
//    }

//    Scenario: Verify send PUT request to update user with valid full name, email, password, image url, gender, birthdate, blood type, height, and weight
    @Given("I set update user profile API endpoint")
    public void setValidUpdateProfileEndpoint(){
        profiles.setValidUpdateUser();
    }

    @When("I send PUT HTTP request for update user profile with valid request body")
    public void successSendValidPutRequestUpdateProfile(){
        profiles.sendPutRequestToUpdateProfileWithValidData();
    }

    @And("I receive valid message that User Updated Data Successful")
    public void receiveMessageUserUpdatedDataSuccessful(){
        profiles.validateMessageSuccessUpdateProfile();
    }



    //    Scenario: Verify send PUT request to update user with invalid email format (without "@")
    @When("I send PUT HTTP request for update user profile with invalid email format")
    public void successSendPutUpdateProfileInvalidEmail(){
        profiles.sendPutUpdateUserWithInvalidEmailFormat();
    }



    //    Scenario: Verify send PUT request to update user with name  is exceeding the limit (30)
    @When("I send PUT HTTP request for update user profile with the name is exceed")
    public void successSendPutUpdateProfileWithExceedName(){
        profiles.sendPutUpdateProfileWithExceedName();
    }

    @And("I receive valid message that Failed on Max Validation")
    public void receiveMessageMaxValidationName(){
        profiles.validateMessageUpdateProfileWithExceedName();
    }


    //    Scenario: Verify send PUT request to update user with invalid gender
    @When("I send PUT HTTP request for update user profile with invalid gender")
    public void successSendPutUpdateProfileInvalidGender(){
        profiles.sendPutUpdateProfileWithInvalidGender();
    }

    @And("I receive valid message that Invalid Input Gender Data")
    public void receiveMessageInvalidInputGender(){
        profiles.validateMessageInvalidGender();
    }



    //    Scenario: Verify send PUT request to update user with invalid blood type
    @When("I send PUT HTTP request for update user profile with invalid blood type")
    public void successSendPutUpdateProfileWithInvalidBloodType(){
        profiles.sendPutUpdateProfileWithInvalidBloodType();
    }

    @And("I receive valid message that Invalid Input Blood Type Data")
    public void receiveMessageBloodTypeValidation(){
        profiles.validateMessageInvalidBloodType();
    }


    //    Scenario: Verify send PUT request to update user with invalid height
    @When("I send PUT HTTP request for update user profile with invalid height")
    public void successSendPutUpdateProfileWithInvalidHeight(){
        profiles.sendPutUpdateProfileWithInvalidHeight();
    }

    @And("I receive valid message that Invalid Input Update Data")
    public void receiveMessageInvalidInputUpdateData(){
        profiles.validateMessageInvalidHeight();
    }



    //    Scenario: Verify send PUT request to update user with invalid weight
    @When("I send PUT HTTP request for update user profile with invalid weight")
    public void successSendPutUpdateProfileWithInvalidWeight(){
        profiles.sendPutUpdateProfileWithInvalidWeight();
    }



    //    Scenario: Verify send GET request to get user profile endpoint  with valid user ID
    @Given("I set get user profile API endpoint")
    public void setValidGetUserProfileEndpoint(){
        profiles.setValidGetUserProfile();
    }

    @When("I send GET HTTP request for get user profile with valid token")
    public void successSendValidGetUserProfile(){
        profiles.sendValidGetUserProfile();
    }

    @And("I receive valid message that Users Data Successfully Retrieved")
    public void receiveMessageUserDataSuccessfullyRetrieved(){
        profiles.validateMessageGetUserProfile();
    }





}
