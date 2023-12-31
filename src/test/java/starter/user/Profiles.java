package starter.user;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import java.io.File;
import java.util.UUID;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class Profiles {
//    private static String authToken;

    protected String url = "https://dev.healthify.my.id";


    protected String tokenLoginUser = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6InBhc2llbmhlYWx0aGlmeUBnbWFpbC5jb20iLCJleHAiOjE3MDMzNzY2ODEsImlkIjoxNzUsInJvbGUiOiJ1c2VyIn0.GYCC7t2SR9yx3og9zZoe_s2TF3DpAGKigCfZfLh_i-s";


//    Scenario: Verify send PUT request to update user with valid full name, email, password, image url, gender, birthdate, blood type, height, and weight
    @Step("I set update user profile API endpoint")
    public String setValidUpdateUser(){
        return url + "/users/profile";
    }

    @Step("I send PUT HTTP request for update user profile with valid request body")
    public void sendPutRequestToUpdateProfileWithValidData(){

        File imageFile = new File("E:\\!SIB\\!capstone-project\\API_Mobile_Automation\\src\\test\\java\\starter\\user\\emojipng.com-1738931.png");  // Ganti dengan path file gambar yang sesuai

        String randomEmail = "user" + UUID.randomUUID().toString() + "@gmail.com";

        SerenityRest.given()
//                .header("Authorization", authToken)
                .header("Authorization", tokenLoginUser)
                .multiPart("fullname", "Hanisah Fildza Annafisah")
//                .multiPart("email", randomEmail)
                .formParams("password", "a1234567890")
//                .multiPart("profile_picture", imageFile, "image/jpeg")
                .multiPart("gender", "female")
                .multiPart("birthdate", "1999-09-30")
                .multiPart("blood_type", "A")
                .multiPart("height", 170)
                .multiPart("weight", 50)
                .put(setValidUpdateUser());
    }

    @Step("I receive valid message that User Updated Data Successful")
    public void validateMessageSuccessUpdateProfile(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("user updated data successful")));
    }


//    Scenario: Verify send PUT request to update user with invalid email format (without "@")
    @Step("I send PUT HTTP request for update user profile with invalid email format")
    public void sendPutUpdateUserWithInvalidEmailFormat(){

        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .multiPart("email", "user5gmail.com")
                .put(setValidUpdateUser());
    }


//    Scenario: Verify send PUT request to update user with name  is exceeding the limit (30)
    @Step("I send PUT HTTP request for update user profile with the name is exceed")
    public void sendPutUpdateProfileWithExceedName(){

        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .multiPart("fullname", "Hanisah Fildza Annafisah Annafi")
                .put(setValidUpdateUser());
    }


    @Step("And I receive valid message that Failed on Max Validation")
    public void validateMessageUpdateProfileWithExceedName(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("Field 'Fullname' failed on 'max' validation")));
    }


//    Scenario: Verify send PUT request to update user with invalid gender
    @Step("I send PUT HTTP request for update user profile with invalid gender")
    public void sendPutUpdateProfileWithInvalidGender(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .multiPart("gender", "habah")
                .put(setValidUpdateUser());
    }

    @Step("I receive valid message that Invalid Input Gender Data")
    public void validateMessageInvalidGender(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("invalid input gender data ('male', 'female')")));
    }



//    Scenario: Verify send PUT request to update user with invalid blood type
    @Step("I send PUT HTTP request for update user profile with invalid blood type")
    public void sendPutUpdateProfileWithInvalidBloodType(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .multiPart("blood_type", "SSS")
                .put(setValidUpdateUser());
    }

    @Step("I receive valid message that Invalid Input Blood Type Data")
    public void validateMessageInvalidBloodType(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("invalid input blood type data,('a', 'b', 'o', 'ab')")));
    }


//    Scenario: Verify send PUT request to update user with invalid height
    @Step("I send PUT HTTP request for update user profile with invalid height")
    public void sendPutUpdateProfileWithInvalidHeight(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .multiPart("height", "abcdde")
                .put(setValidUpdateUser());
    }

    @Step("I receive valid message that Invalid Input Update Data")
    public void validateMessageInvalidHeight(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("invalid input update data")));
    }


//    Scenario: Verify send PUT request to update user with invalid weight
    @Step("I send PUT HTTP request for update user profile with invalid weight")
    public void sendPutUpdateProfileWithInvalidWeight(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .multiPart("weight", "abcdde")
                .put(setValidUpdateUser());
    }



    //    Scenario: Verify send GET request to get user profile endpoint  with valid user ID
    @Step("I set get user profile API endpoint")
    public String setValidGetUserProfile(){
        return url + "/users/profile";
    }

    @Step("I send GET HTTP request for get user profile with valid token")
    public void sendValidGetUserProfile(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .get(setValidGetUserProfile());
    }

    @Step("I receive valid message that Users Data Successfully Retrieved")
    public void validateMessageGetUserProfile(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("users data successfully retrieved")));
    }

}
