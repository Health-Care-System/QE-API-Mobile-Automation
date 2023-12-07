package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.json.JSONObject;

import java.io.File;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class TransactionDoctor {

    protected String url = "https://www.healthify.my.id";

    protected String tokenLoginUser = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6InVzZXIxMjFAZ21haWwuY29tIiwiZXhwIjoxNzAyMTc3MzE0LCJpZCI6NTgsInJvbGUiOiJ1c2VyIn0.5jNuVONwduYEeqovHd43prGyKgFJiyir_YjKJhGWlks";


//    Scenario: Verify send POST request to create doctor transaction endpoint with valid doctor ID, payment method, and payment confirmation
    @Step("I set create doctor transaction API endpoint with valid doctor ID")
    public String setValidCreateDocTransaction(){
        return url + "/users/doctor-payments/1";
    }

    @Step("I send POST HTTP request for create doctor transaction with valid request body")
    public void sendPostValidCreateDocTransaction(){

        File imageFile = new File("E:\\!SIB\\!capstone-project\\API_Mobile_Automation\\src\\test\\java\\starter\\user\\emojipng.com-1738931.png");

        SerenityRest.given()
//                .header("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6InVzZXI0QGdtYWlsLmNvbSIsImV4cCI6MTcwMTc5MzE5NiwiaWQiOjMsInJvbGUiOiJ1c2VyIn0.7izAkeR4Nh3Vqhw1QzpT-mR4WGRT1HzmA1XcN0J14rI")
                .header("Authorization", tokenLoginUser)
                .formParams("payment_method", "manual transfer bca")
                .multiPart("payment_confirmation", imageFile, "image/jpeg")
                .post(setValidCreateDocTransaction());
    }

    @Step("I receive HTTP response status code 201 Created")
    public void receiveResponseStatusCode201(){
        restAssuredThat(response -> response.statusCode(201));
    }

    @Step("I receive valid message that doctor transaction created successful")
    public void validateMessageSuccessCreateDocTransaction(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("doctor transaction created successful")));
    }


//    Scenario: Verify send POST request to create doctor transaction endpoint with invalid doctor ID
    @Step("I set create doctor transaction API endpoint with invalid doctor ID")
    public String setCreateDocTransInvalidID(){
        return url + "/users/doctor-payments/abcde";
    }

    @Step("I send POST HTTP request for create doctor transaction to invalid doctor ID endpoint")
    public void sendPostCreateDocTransInvalidID(){

        File imageFile = new File("E:\\!SIB\\!capstone-project\\API_Mobile_Automation\\src\\test\\java\\starter\\user\\emojipng.com-1738931.png");


        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .formParams("payment_method", "manual transfer bca")
                .multiPart("payment_confirmation", imageFile, "image/jpeg")
                .post(setCreateDocTransInvalidID());
    }

    @Step("I receive valid message that invalid doctor id")
    public void validateMessageCreateDOcTransByInvalidID(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("invalid doctor id")));
    }


//    Scenario: Verify send POST request to create doctor transaction with non existing doctor ID
    @Step("I set create doctor transaction API endpoint with non existing doctor ID")
    public String setCreateDocTransWithNonExistID(){
        return  url + "/users/doctor-payments/999";
    }

    @Step("I send POST HTTP request for create doctor transaction to non exist doctor ID")
    public void sendPostCreateDocTransNonExistID(){

        File imageFile = new File("E:\\!SIB\\!capstone-project\\API_Mobile_Automation\\src\\test\\java\\starter\\user\\emojipng.com-1738931.png");


        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .formParams("payment_method", "manual transfer bca")
                .multiPart("payment_confirmation", imageFile, "image/jpeg")
                .post(setCreateDocTransWithNonExistID());
    }

    @Step("I receive valid message that doctor failed to retrieve doctor data")
    public void validateMessageCreateDocTransWithNonExistID(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("failed to retrieve doctor data")));
    }


//    Scenario: Verify send POST request to create doctor transaction with empty doctor ID
    @Step("I set create doctor transaction API endpoint with empty doctor ID")
    public String setCreateDocTransEmptyID(){
        return url + "/users/doctor-payments/";
    }

    @Step("I send POST HTTP request for create doctor transaction to empty doctor ID")
    public void sendPostCreateDocTransEmptyID(){

        File imageFile = new File("E:\\!SIB\\!capstone-project\\API_Mobile_Automation\\src\\test\\java\\starter\\user\\emojipng.com-1738931.png");


        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .formParams("payment_method", "manual transfer bca")
                .multiPart("payment_confirmation", imageFile, "image/jpeg")
                .post(setCreateDocTransEmptyID());
    }


//    Scenario: Verify send POST request to create doctor transaction with empty payment method
    @Step("I send POST HTTP request for create doctor transaction with empty payment method")
    public void sendPostCreateDocTransWithEmptyPaymentMethod(){
        File imageFile = new File("E:\\!SIB\\!capstone-project\\API_Mobile_Automation\\src\\test\\java\\starter\\user\\emojipng.com-1738931.png");


        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .formParams("payment_method", "")
                .multiPart("payment_confirmation", imageFile, "image/jpeg")
                .post(setValidCreateDocTransaction());
    }

    @Step("I receive valid message that Failed on Payment Method Validation")
    public void validateMessageCreateDocTransWithEmptyPaymentMethod(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("Field 'PaymentMethod' failed on 'required' validation")));
    }



//    Scenario: Verify send POST request to create doctor transaction with invalid payment method
    @Step("I send POST HTTP request for create doctor transaction with invalid payment method")
    public void sendPostCreateDocTransWithInvalidPaymentMethod(){
        File imageFile = new File("E:\\!SIB\\!capstone-project\\API_Mobile_Automation\\src\\test\\java\\starter\\user\\emojipng.com-1738931.png");


        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .formParams("payment_method", "abcde")
                .multiPart("payment_confirmation", imageFile, "image/jpeg")
                .post(setValidCreateDocTransaction());
    }

    @Step("I receive valid message that failed to create doctor transaction")
    public void validateMessageDoctorTransactionWithInvalidPaymentMethod(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("invalid input payment method data ('manual transfer bca', 'manual transfer bri', 'manual transfer bni')")));
    }


//    Scenario: Verify send POST request to create doctor transaction with empty payment confirmation
    @Step("I send POST HTTP request for create doctor transaction with empty payment confirmation")
    public void sendPostCreateDocTransWithEmptyPaymentConfirmation(){
        File imageFile = new File("E:\\!SIB\\!capstone-project\\API_Mobile_Automation\\src\\test\\java\\starter\\user\\emojipng.com-1738931.png");

        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .formParams("payment_method", "manual transfer bca")
                .multiPart("payment_confirmation", "")
                .post(setValidCreateDocTransaction());
    }

    @Step("I receive valid message that payment confirmation file is required")
    public void validateMessagePaymentConfirmationIsEmpty(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("payment confirmation file is required")));
    }


//    Scenario: Verify send POST request to create doctor transaction with invalid file for payment confirmation
    @Step("I send POST HTTP request for create doctor transaction with invalid payment confirmation")
    public void sendPostCreateDocTransWithInvalidPaymentConfirmation(){
        File imageFile = new File("C:\\Users\\ferna\\Dropbox\\PC\\Downloads\\Hasil Diskusi BE dan UI_UX.pdf");

        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .formParams("payment_method", "manual transfer bca")
                .multiPart("payment_confirmation", imageFile, "file/pdf")
                .post(setValidCreateDocTransaction());
    }

    @Step("I receive valid message that invalid image file format")
    public void validateMessageInvalidPaymentConfirmation(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("invalid image file format. supported formats: jpg, jpeg, png")));
    }


//    Scenario: Verify send GET request to get all doctor transactions endpoint
    @Step("I set get all doctor transactions API endpoint")
    public String  setValidGetAllDocTrans(){
        return url + "/users/doctor-payments?offset=0&limit=10";
    }

    @Step("I send GET HTTP request for get all doctor transactions")
    public void sendValidGetAllDoctorTransaction(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .get(setValidGetAllDocTrans());
    }

    @Step("I receive valid message that doctor transaction data successfully retrieved")
    public void validateMessageValidGetAllDocTrans(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("doctor transaction data successfully retrieved")));
    }


//    Scenario: Verify send POST request to get all doctor transactions endpoint
    @Step("I send POST HTTP request for get all doctor transactions")
    public void sendPostToGetAllDocTrans(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .post(setValidGetAllDocTrans());
    }


//    Scenario: Verify send GET request to get doctor transaction by status success
    @Step("I set get doctor transactions API endpoint with status success")
    public String  setValidGetDocTransByStatusSuccess(){
        return url + "/users/doctor-payments?offset=0&limit=20&payment_status=success";
    }

    @Step("I send GET HTTP request for get doctor transactions with status success")
    public void sendGetDocTransByStatusSuccess(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .get(setValidGetDocTransByStatusSuccess());
    }


//    Scenario: Verify send GET request to get doctor transaction by status pending
    @Step("I set get doctor transactions API endpoint with status pending")
    public String  setValidGetDocTransByStatusPending(){
        return url + "/users/doctor-payments?offset=0&limit=20&payment_status=pending";
    }

    @Step("I send GET HTTP request for get doctor transactions with status pending")
    public void sendGetDocTransByStatusPending(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .get(setValidGetDocTransByStatusPending());
    }


//    Scenario: Verify send GET request to get doctor transaction by status cancelled
    @Step("I set get doctor transactions API endpoint with status cancelled")
    public String  setValidGetDocTransByStatusCancelled(){
        return url + "/users/doctor-payments?offset=0&limit=20&payment_status=cancelled";
    }

    @Step("I send GET HTTP request for get doctor transactions with status cancelled")
    public void sendGetDocTransByStatusCancelled(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .get(setValidGetDocTransByStatusCancelled());
    }


//    Scenario: Verify send POST request to get doctor transaction by status endpoint
    @Step("I send POST HTTP request for get doctor transactions with status pending")
    public void sendPostToDocTransByStatusPending(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .post(setValidGetDocTransByStatusPending());
    }


//    Scenario: Verify send GET request to get doctor transaction by valid ID
    @Step("I set get doctor transactions by valid ID API endpoint")
    public String setValidGetDocTransByID(){
        return url + "/users/doctor-payments/20";
    }

    @Step("I send GET HTTP request for get doctor transactions by valid ID")
    public void sendGetDocTransByValidID(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .get(setValidGetDocTransByID());
    }


//    Scenario: Verify send GET request to get doctor transaction by invalid ID
    @Step("I set get doctor transactions by invalid ID API endpoint")
    public String setGetDocTransByInvalidID(){
        return url + "/users/doctor-payments/abcde";
    }

    @Step("I send GET HTTP request for get doctor transactions by invalid ID")
    public void sendGetDocTransByInvalidID(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .get(setGetDocTransByInvalidID());
    }

    @Step("I receive valid message that invalid transaction id")
    public void validateMessageGetDocTransByInvalidID(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("invalid transaction id")));
    }


//    Scenario: Verify send GET request to get doctor transaction by non existing ID
    @Step("I set get doctor transactions by non exist ID API endpoint")
    public String setGetDocTransByNonExistID(){
        return url + "/users/doctor-payments/999";
    }

    @Step("I send GET HTTP request for get doctor transactions by non exist ID")
    public void sendGetDocTransByNonExistID(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .get(setGetDocTransByNonExistID());
    }

    @Step("I receive valid message that failed to retrieve doctor transaction data")
    public void validateMessageGetDocTransByNonExistID(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("failed to retrieve doctor transaction data")));
    }


//    Scenario: Verify send POST request to get doctor transaction by valid ID
    @Step("I send POST HTTP request for get doctor transactions by valid ID")
    public void sendPostToGetDocTransByID(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .post(setValidGetDocTransByID());
    }


}
