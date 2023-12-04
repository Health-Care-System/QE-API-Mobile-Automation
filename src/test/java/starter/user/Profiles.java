package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import java.io.File;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class Profiles {

    protected String url = "";
//    Scenario: Verify send PUT request to update user with valid full name, email, password, image url, gender, birthdate, blood type, height, and weight
    @Step("I set update user profile API endpoint")
    public String setValidUpdateUser(){
        return url + "users/profile";
    }

    @Step("I send PUT HTTP request for update user profile with valid request body")
    public void sendPutRequestToUpdateProfileWithValidData(){

        File imageFile = new File("\"E:\\!SIB\\!capstone-project\\API_Mobile_Automation\\src\\test\\java\\starter\\user\\emojipng.com-1738931.png\"");  // Ganti dengan path file gambar yang sesuai

        SerenityRest.given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6InVzZXI2QGdtYWlsLmNvbSIsImV4cCI6MTcwMTkzNjc1MywiaWQiOjEzLCJyb2xlIjoidXNlciJ9.1g4i0lByTwCoU2heQcKp2fYNgxxopTrl_fhvCGHvBlk")
                .formParams("fullname", "Hanisah Fildza Annafisah")
                .formParams("email", "user5@gmail.com")
                .formParams("password", "a1234567890")
                .multiPart("profile_picture", imageFile, "image/jpeg")  // Menambahkan form parameter untuk upload foto profil
                .formParams("gender", "female")
                .formParams("birthdate", "1999-09-30")
                .formParams("blood_type", "A")
                .formParams("height", 170)
                .formParams("weight", 50)
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
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6InVzZXI2QGdtYWlsLmNvbSIsImV4cCI6MTcwMTkzNjc1MywiaWQiOjEzLCJyb2xlIjoidXNlciJ9.1g4i0lByTwCoU2heQcKp2fYNgxxopTrl_fhvCGHvBlk")
                .formParams("email", "user5gmail.com")
                .put(setValidUpdateUser());
    }


//    Scenario: Verify send PUT request to update user with name  is exceeding the limit (30)
    @Step("I send PUT HTTP request for update user profile with the name is exceed")
    public void sendPutUpdateProfileWithExceedName(){
        StringBuilder fullnameBuilder = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            fullnameBuilder.append("a");
        }

        String fullname = fullnameBuilder.toString();

        SerenityRest.given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6InVzZXI2QGdtYWlsLmNvbSIsImV4cCI6MTcwMTkzNjc1MywiaWQiOjEzLCJyb2xlIjoidXNlciJ9.1g4i0lByTwCoU2heQcKp2fYNgxxopTrl_fhvCGHvBlk")
                .formParams("fullname", fullname)
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
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6InVzZXI2QGdtYWlsLmNvbSIsImV4cCI6MTcwMTkzNjc1MywiaWQiOjEzLCJyb2xlIjoidXNlciJ9.1g4i0lByTwCoU2heQcKp2fYNgxxopTrl_fhvCGHvBlk")
                .formParams("gender", "female")
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
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6InVzZXI2QGdtYWlsLmNvbSIsImV4cCI6MTcwMTkzNjc1MywiaWQiOjEzLCJyb2xlIjoidXNlciJ9.1g4i0lByTwCoU2heQcKp2fYNgxxopTrl_fhvCGHvBlk")
                .formParams("blood_type", "A")
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
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6InVzZXI2QGdtYWlsLmNvbSIsImV4cCI6MTcwMTkzNjc1MywiaWQiOjEzLCJyb2xlIjoidXNlciJ9.1g4i0lByTwCoU2heQcKp2fYNgxxopTrl_fhvCGHvBlk")
                .formParams("height", "abcdde")
                .put(setValidUpdateUser());
    }

    @Step("I receive valid message that Invalid Input Update Data")
    public void validateMessageInvalidHeight(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("Invalid Input Update Data")));
    }


//    Scenario: Verify send PUT request to update user with invalid weight
    @Step("I send PUT HTTP request for update user profile with invalid weight")
    public void sendPutUpdateProfileWithInvalidWeight(){
        SerenityRest.given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6InVzZXI2QGdtYWlsLmNvbSIsImV4cCI6MTcwMTkzNjc1MywiaWQiOjEzLCJyb2xlIjoidXNlciJ9.1g4i0lByTwCoU2heQcKp2fYNgxxopTrl_fhvCGHvBlk")
                .formParams("weight", "abcdde")
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
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6InVzZXI2QGdtYWlsLmNvbSIsImV4cCI6MTcwMTkzNjc1MywiaWQiOjEzLCJyb2xlIjoidXNlciJ9.1g4i0lByTwCoU2heQcKp2fYNgxxopTrl_fhvCGHvBlk")
                .get(setValidGetUserProfile());
    }

    @Step("I receive valid message that Users Data Successfully Retrieved")
    public void validateMessageGetUserProfile(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("users data successfully retrieved")));
    }

}
