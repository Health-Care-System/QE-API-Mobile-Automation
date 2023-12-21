package starter.user;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.UUID;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class TransactionMedicine {

    protected String url = "https://dev.healthify.my.id";

    protected String tokenLoginUser = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6InBhc2llbmhlYWx0aGlmeUBnbWFpbC5jb20iLCJleHAiOjE3MDMzNzY2ODEsImlkIjoxNzUsInJvbGUiOiJ1c2VyIn0.GYCC7t2SR9yx3og9zZoe_s2TF3DpAGKigCfZfLh_i-s";

    protected String medTransID = "216"; // +1 increment manual & skip 221

    protected String deleteMedTrans = "221"; // +1 increment manual

    private int medicineTransactionId;

    private String medicineTransactionIdString;

    protected String idAsString;


//    Scenario: Verify send POST request to create medicine transaction endpoint with valid request body
    @Step("I set valid create medicine transaction API endpoint")
    public String setValidCreateMedTrans(){
        return url + "/users/medicines-payments";
    }

    @Step("I send POST HTTP request for create medicine transaction with valid request body")
    public  void  sendValidPostCreateMedTrans(){

        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "Fernand Andrean");
        requestBody.put("address", "Zimbabwe");
        requestBody.put("hp", "081234567890");
        requestBody.put("payment_method", "manual transfer bca");

        JSONArray medicineDetailsArray = new JSONArray();

        JSONObject medicine1 = new JSONObject();
        medicine1.put("medicine_id", 3);
        medicine1.put("quantity", 1);

        medicineDetailsArray.put(medicine1);

        requestBody.put("medicine_details", medicineDetailsArray);

        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", tokenLoginUser)
                .body(requestBody.toString())
                .post(setValidCreateMedTrans());

//        JSONObject requestBody = new JSONObject();
//
//        requestBody.put("name", "Fernand Andrean");
//        requestBody.put("address", "Zimbabwe");
//        requestBody.put("hp", "081234567890");
//        requestBody.put("payment_method", "manual transfer bca");
//
//        JSONArray medicineDetailsArray = new JSONArray();
//
//        JSONObject medicine1 = new JSONObject();
//        medicine1.put("medicine_id", 1);
//        medicine1.put("quantity", 1);
//
//        medicineDetailsArray.put(medicine1);
//
//        requestBody.put("medicine_details", medicineDetailsArray);

//        Response response = SerenityRest.given()
//                .header("Content-Type","application/json")
//                .header("Authorization", tokenLoginUser)
//                .body(requestBody.toString())
//                .post(setValidCreateMedTrans());
//
//        int medicineTransactionId = response.then().extract().path("'results'.'id'");
//
//        medicineTransactionIdString = String.valueOf(medicineTransactionId);

        // Send the POST request
//        SerenityRest.given()
//                .header("Content-Type", "application/json")
//                .header("Authorization", tokenLoginUser)
//                .body(requestBody.toString())
//                .post(setValidCreateMedTrans());
//
//        // Extract the response
//        String response = SerenityRest.then().extract().response().asString();
//
//        // Extract the ID from the response using JsonPath
//        JsonPath jsonPath = new JsonPath(response);
//        int id = jsonPath.getInt("'results'.'id'");
//
//        // Convert the ID to a String
//        String idAsString = String.valueOf(id);
    }

    public int getMedicineTransactionId() {
        return medicineTransactionId;
    }

    @Step("I receive valid message that successfully created medicine transaction")
    public void validateMessageSuccessCreateMedTrans(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("successfully created medicine transaction")));
    }


//    Scenario: Verify send POST request to create medicine transaction endpoint with multiple diferent product
    @Step("I send POST HTTP request for create medicine transaction with multiple diferent product")
    public void sendPostCreateMedTransWithMultipleDiffProduct(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "Fernand Andrean");
        requestBody.put("address", "Zimbabwe");
        requestBody.put("hp", "081234567890");
        requestBody.put("payment_method", "manual transfer bca");

        JSONArray medicineDetailsArray = new JSONArray();

        JSONObject medicine1 = new JSONObject();
        medicine1.put("medicine_id", 2);
        medicine1.put("quantity", 1);

        JSONObject medicine2 = new JSONObject();
        medicine2.put("medicine_id", 3);
        medicine2.put("quantity", 1);

        medicineDetailsArray.put(medicine1);
        medicineDetailsArray.put(medicine2);

        requestBody.put("medicine_details", medicineDetailsArray);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", tokenLoginUser)
                .body(requestBody.toString())
                .post(setValidCreateMedTrans());
    }


//    Scenario: Verify send POST request to create medicine transaction endpoint with empty name
    @Step("I send POST HTTP request for create medicine transaction with empty name")
    public void sendPostCreateMedTransWithEmptyName(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "");
        requestBody.put("address", "Zimbabwe");
        requestBody.put("hp", "081234567890");
        requestBody.put("payment_method", "manual transfer bca");

        JSONArray medicineDetailsArray = new JSONArray();

        JSONObject medicine1 = new JSONObject();
        medicine1.put("medicine_id", 1);
        medicine1.put("quantity", 1);

        medicineDetailsArray.put(medicine1);

        requestBody.put("medicine_details", medicineDetailsArray);

        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", tokenLoginUser)
                .body(requestBody.toString())
                .post(setValidCreateMedTrans());
    }

    @Step("I receive valid message that failed create medicine transaction with empty name")
    public void validateMessageNameFieldRequiredValidation(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("Field 'Name' failed on 'required' validation")));
    }


//    Scenario: Verify send POST request to create medicine transaction endpoint with empty address
    @Step("I send POST HTTP request for create medicine transaction with empty address")
    public void sendPostCreateMedTransWithEmptyAddress(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "Fernand Andrean");
        requestBody.put("address", "");
        requestBody.put("hp", "081234567890");
        requestBody.put("payment_method", "manual transfer bca");

        JSONArray medicineDetailsArray = new JSONArray();

        JSONObject medicine1 = new JSONObject();
        medicine1.put("medicine_id", 1);
        medicine1.put("quantity", 1);

        medicineDetailsArray.put(medicine1);

        requestBody.put("medicine_details", medicineDetailsArray);

        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", tokenLoginUser)
                .body(requestBody.toString())
                .post(setValidCreateMedTrans());
    }

    @Step("I receive valid message that failed create medicine transaction with empty address")
    public void validateMessageAddressFieldRequiredValidation(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("Field 'Address' failed on 'required' validation")));
    }



//    Scenario: Verify send POST request to create medicine transaction endpoint with empty phone number
    @Step("I send POST HTTP request for create medicine transaction with empty phone number")
    public void sendPostCreateMedTransWithEmptyPhoneNumber(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "Fernand Andrean");
        requestBody.put("address", "Zimbabwe");
        requestBody.put("hp", "");
        requestBody.put("payment_method", "manual transfer bca");

        JSONArray medicineDetailsArray = new JSONArray();

        JSONObject medicine1 = new JSONObject();
        medicine1.put("medicine_id", 1);
        medicine1.put("quantity", 1);

        medicineDetailsArray.put(medicine1);

        requestBody.put("medicine_details", medicineDetailsArray);

        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", tokenLoginUser)
                .body(requestBody.toString())
                .post(setValidCreateMedTrans());
    }

    @Step("I receive valid message that failed create medicine transaction with empty phone number")
    public void validateMessageHpFieldRequiredValidation(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("Field 'HP' failed on 'required' validation")));
    }



//    Scenario: Verify send POST request to create medicine transaction endpoint with empty payment method
    @Step("I send POST HTTP request for create medicine transaction with empty payment method")
    public void sendPostCreateMedTransWithEmptyPaymentMethod(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "Fernand Andrean");
        requestBody.put("address", "Zimbabwe");
        requestBody.put("hp", "081234567890");
        requestBody.put("payment_method", "");

        JSONArray medicineDetailsArray = new JSONArray();

        JSONObject medicine1 = new JSONObject();
        medicine1.put("medicine_id", 1);
        medicine1.put("quantity", 1);

        medicineDetailsArray.put(medicine1);

        requestBody.put("medicine_details", medicineDetailsArray);

        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", tokenLoginUser)
                .body(requestBody.toString())
                .post(setValidCreateMedTrans());
    }

    @Step("I receive valid message that failed create medicine transaction with empty payment method")
    public void validateMessagePaymentMethodFieldRequiredValidation(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("Field 'PaymentMethod' failed on 'required' validation")));
    }



//    Scenario: Verify send POST request to create medicine transaction endpoint with non exist medicine ID
    @Step("I send POST HTTP request for create medicine transaction with non exist medicine ID")
    public void sendPostCreateMedTransWithNonExistMedicineID(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "Fernand Andrean");
        requestBody.put("address", "Zimbabwe");
        requestBody.put("hp", "081234567890");
        requestBody.put("payment_method", "manual transfer bca");

        JSONArray medicineDetailsArray = new JSONArray();

        JSONObject medicine1 = new JSONObject();
        medicine1.put("medicine_id", 999);
        medicine1.put("quantity", 1);

        medicineDetailsArray.put(medicine1);

        requestBody.put("medicine_details", medicineDetailsArray);

        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", tokenLoginUser)
                .body(requestBody.toString())
                .post(setValidCreateMedTrans());
    }

    @Step("I receive valid message that failed create medicine transaction with non exist medicine ID")
    public void validateMessageInvalidMedicineID(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("medicine id not found")));
    }



//    Scenario: Verify send POST request to create medicine transaction endpoint with invalid medicine id
    @Step("I send POST HTTP request for create medicine transaction with invalid medicine ID")
    public void sendPostCreateMedTransWithInvalidID(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "Fernand Andrean");
        requestBody.put("address", "Zimbabwe");
        requestBody.put("hp", "081234567890");
        requestBody.put("payment_method", "manual transfer bca");

        JSONArray medicineDetailsArray = new JSONArray();

        JSONObject medicine1 = new JSONObject();
        medicine1.put("medicine_id", "999");
        medicine1.put("quantity", 1);

        medicineDetailsArray.put(medicine1);

        requestBody.put("medicine_details", medicineDetailsArray);

        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", tokenLoginUser)
                .body(requestBody.toString())
                .post(setValidCreateMedTrans());
    }

    @Step("I receive valid message that failed create medicine transaction with invalid medicine ID")
    public void validateMessageInvalidRequestBody(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("invalid request body")));
    }



//    Scenario: Verify send POST request to create medicine transaction endpoint with empty quantity
    @Step("I send POST HTTP request for create medicine transaction with empty quantity")
    public void sendPostCreateMedTransWithEmptyQuantity(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "Fernand Andrean");
        requestBody.put("address", "Zimbabwe");
        requestBody.put("hp", "081234567890");
        requestBody.put("payment_method", "manual transfer bca");

        JSONArray medicineDetailsArray = new JSONArray();

        JSONObject medicine1 = new JSONObject();
        medicine1.put("medicine_id", 1);
//        medicine1.put("quantity", 1);

        medicineDetailsArray.put(medicine1);

        requestBody.put("medicine_details", medicineDetailsArray);

        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", tokenLoginUser)
                .body(requestBody.toString())
                .post(setValidCreateMedTrans());
    }

    @Step("I receive valid message that failed create medicine transaction with empty quantity")
    public void validateMessageQuantityCannotBeEmpty(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("quantity cannot be empty")));
    }


//    Scenario: Verify send POST request to create medicine transaction endpoint with invalid quantity
    @Step("I send POST HTTP request for create medicine transaction with invalid quantity")
    public void sendPostCreateMedTransWithInvalidQuantity(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "Fernand Andrean");
        requestBody.put("address", "Zimbabwe");
        requestBody.put("hp", "081234567890");
        requestBody.put("payment_method", "manual transfer bca");

        JSONArray medicineDetailsArray = new JSONArray();

        JSONObject medicine1 = new JSONObject();
        medicine1.put("medicine_id", 1);
        medicine1.put("quantity", "1");

        medicineDetailsArray.put(medicine1);

        requestBody.put("medicine_details", medicineDetailsArray);

        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", tokenLoginUser)
                .body(requestBody.toString())
                .post(setValidCreateMedTrans());
    }

    @Step("I receive valid message that failed create medicine transaction with invalid quantity")
    public void validateMessageFailedCreateMedTransWithInvalidQuantity(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("invalid request body")));
    }


//    Scenario: Verify send DELETE request to create medicine transaction endpoint with valid request body
    @Step("I send DELETE HTTP request for create medicine transaction with valid request body")
    public void sendDeleteToCreateMedTrans(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "Fernand Andrean");
        requestBody.put("address", "Zimbabwe");
        requestBody.put("hp", "081234567890");
        requestBody.put("payment_method", "manual transfer bca");

        JSONArray medicineDetailsArray = new JSONArray();

        JSONObject medicine1 = new JSONObject();
        medicine1.put("medicine_id", 1);
        medicine1.put("quantity", 1);

        medicineDetailsArray.put(medicine1);

        requestBody.put("medicine_details", medicineDetailsArray);

        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", tokenLoginUser)
                .body(requestBody.toString())
                .delete(setValidCreateMedTrans());
    }



//    Scenario: Verify send GET request to get all medicine transactions endpoint
    @Step("I set valid get all medicine transactions API endpoint")
    public String setValidGetALlMedTrans(){
        return url + "/users/medicines-payments?offset=0&limit=10";
    }

    @Step("I send GET HTTP request for get all medicine transactions")
    public void sendValidGetAllMedTrans(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .get(setValidGetALlMedTrans());
    }

    @Step("I receive valid message that successfully get data medicine transactions")
    public void validateMessageSuccessfullyGetAllMedTrans(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("successfully get data medicine transactions")));
    }


//    Scenario: Verify send POST request to get all medicine transactions endpoint
    @Step("I send POST HTTP request for get all medicine transactions")
    public void sendPostToGetAllMedTrans(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .post(setValidGetALlMedTrans());
    }



//    Scenario: Verify send GET request to get medicine transaction by status endpoint (belum dibayar)
    @Step("I set valid get medicine transactions by status belum dibayar API endpoint")
    public String  setValidGetMedTransByStatusUnpaid(){
        return url + "/users/medicines-payments?offset=0&limit=5&status_transaction=belum dibayar";
    }

    @Step("I send GET HTTP request for get medicine transactions by status belum dibayar")
    public void sendValidGetMedTransByStatusUnpaid(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .get(setValidGetMedTransByStatusUnpaid());
    }


//    Scenario: Verify send GET request to ge medicine transaction by status endpoint (sudah dibayar)
    @Step("I set valid get medicine transactions by status sudah dibayar API endpoint")
    public String setValidGetMedTransByStatusPaid(){
        return url + "/users/medicines-payments?offset=0&limit=5&status_transaction=sudah dibayar";
    }

    @Step("I send GET HTTP request for get medicine transactions by status sudah dibayar")
    public void sendValidGetMedTransByStatusPaid(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .get(setValidGetMedTransByStatusPaid());
    }



//    Scenario: Verify send GET request to get medicine transaction by status endpoint with invalid status
    @Step("I set valid get medicine transactions by invalid API endpoint")
    public String setGetMedTransByInvalidStatus(){
        return url + "/users/medicines-payments?offset=0&limit=5&status_transaction=abcde";
    }

    @Step("I send GET HTTP request for get medicine transactions by invalid status")
    public void sendGetMedTransByInvalidStatus(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .get(setGetMedTransByInvalidStatus());
    }

    @Step("I receive valid message that failed get medicine transaction with invalid status")
    public void validateMessageFailedGetMedTransByInvalidStatus(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("medicines transaction not found")));
    }



//    Scenario: Verify send DELETE request to get transaction by status endpoint
    @Step("I send DELETE HTTP request for get medicine transactions by status belum dibayar")
    public void sendDeleteToGetMedTransByStatus(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .delete(setValidGetMedTransByStatusUnpaid());
    }



//    Scenario: Verify send GET request to get medicine transactions by ID endpoint
    @Step("I set valid get medicine transactions by ID API endpoint")
    public String setGetMedTransByValidID(){
        return url + "/users/medicines-payments/211";
    }

    @Step("I send GET HTTP request for get medicine transactions by ID")
    public  void sendGetMedTransByValidID(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .get(setGetMedTransByValidID());
    }

    @Step("I receive valid message that successfully get data medicine transaction")
    public void validateMessageSuccessfullyGetMedTransByID(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("successfully get data medicine transaction")));
    }



//    Scenario: Verify send GET request to get medicine transactions by invalid ID endpoint
    @Step("I set get medicine transactions by invalid ID API endpoint")
    public String setGetMedTransByInvalidID(){
        return url + "/users/medicines-payments/abcde";
    }


    @Step("I send GET HTTP request for get medicine transactions by invalid ID")
    public void sendGetMedTransByInvalidID(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .get(setGetMedTransByInvalidID());
    }

    @Step("I receive valid message that failed to get medicine transaction by invalid ID")
    public void validateMessageFailedGetMedTransByInvalidID(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("invalid medicine transaction id")));
    }


//    Scenario: Verify send GET request to get medicine transactions by non existing ID endpoint
    @Step("I set get medicine transactions by non existing ID API endpoint")
    public String setGetMedTransByNonExistingID(){
        return url + "/users/medicines-payments/999";
    }

    @Step("I send GET HTTP request for get medicine transactions by non existing ID")
    public void sendGetMedTransByNonExistID(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .get(setGetMedTransByNonExistingID());
    }

    @Step("I receive valid message that failed to get medicine transaction by non existing ID")
    public void validateMessageFailedGetMedTransByNonExistID(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("not found")));
    }



//    Scenario: Verify send DELETE request to delete medicine transactions by valid ID endpoint
    @Step("I set valid delete medicine transactions API endpoint with valid ID")
    public String setValidDeleteMedTransByValidID(){
        return url + "/users/medicines-payments/" + deleteMedTrans;
    }

    @Step("I send DELETE HTTP request for delete medicine transactions with valid ID")
    public void sendValidDeleteMedTrans(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .delete(setValidDeleteMedTransByValidID());
    }

    @Step("I receive valid message that successfully deleted medicine transaction")
    public void validateMessageSuccessDeleteMedTrans(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("permission denied")));
    }


//    Scenario: Verify send DELETE request to delete medicine transactions by invalid ID endpoint
    @Step("I set valid delete medicine transactions API endpoint with invalid ID")
    public String setDeleteMedTransByInvalidID(){
        return url + "/users/medicines-payments/abcde";
    }

    @Step("I send DELETE HTTP request for delete medicine transactions with invalid ID")
    public void sendDeleteMedTransByInvalidID(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .delete(setDeleteMedTransByInvalidID());
    }

    @Step("I receive valid message that failed to delete medicine transaction with invalid ID")
    public void validateMessageFailedDeleteMedTransWithInvalidID(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("invalid id param")));
    }


//    Scenario: Verify send DELETE request to delete medicine transactions by non existing ID endpoint
    @Step("I set valid delete medicine transactions API endpoint with non existing ID")
    public String setDeleteMedTransByNonExistID(){
        return url + "/users/medicines-payments/999";
    }

    @Step("I send DELETE HTTP request for delete medicine transactions with non existing ID")
    public void sendDeleteMedTransByNonExistID(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .delete(setDeleteMedTransByNonExistID());
    }

    @Step("I receive HTTP response status code 403 Forbidden")
    public void receiveResponseStatusCode403(){
        restAssuredThat(response -> response.statusCode(403));
    }

    @Step("I receive valid message that failed to delete medicine transaction with non existing ID")
    public void validateMessageFailedDeleteMedTransByNonExistID(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("permission denied")));
    }



//    Scenario: Verify send POST request to create checkout with valid request body and medicine transaction ID
    @Step("I set valid create checkout API endpoint with valid medicine transaction ID")
    public String setCreateCheckoutWithValidID(){
        return url + "/users/medicines-payments/checkout?medicine_transaction_id=" + medTransID;
    }

    @Step("I send POST HTTP request for create checkout with valid medicine transaction ID")
    public void sendValidPostCreateCheckout(){
        File imageFile = new File("E:\\!SIB\\!capstone-project\\API_Mobile_Automation\\src\\test\\java\\starter\\user\\emojipng.com-1738931.png");

        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .multiPart("payment_confirmation", imageFile, "image/jpeg")
                .post(setCreateCheckoutWithValidID());
    }

    @Step("I receive valid message that successfully created checkout")
    public void validateMessageSuccessCreateCheckout(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("successfully created checkout")));
    }


//    Scenario: Verify send POST request to create checkout with valid request body and invalid medicine transaction ID
    @Step("I set valid create checkout API endpoint with invalid medicine transaction ID")
    public String setCreateCheckoutWithInvalidMEdTransID(){
        return url + "/users/medicines-payments/checkout?medicine_transaction_id=abcde";
    }

    @Step("I send POST HTTP request for create checkout with invalid medicine transaction ID")
    public void sendPostCreateCheckoutWithInvalidMedTransID(){
        File imageFile = new File("E:\\!SIB\\!capstone-project\\API_Mobile_Automation\\src\\test\\java\\starter\\user\\emojipng.com-1738931.png");

        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .multiPart("payment_confirmation", imageFile, "image/jpeg")
                .post(setCreateCheckoutWithInvalidMEdTransID());
    }

    @Step("I receive valid message that failed to create checkout with invalid medicine transaction")
    public void validateMessageFailedCreateCheckoutWithInvalidMedTransID(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("invalid request body")));
    }



//    Scenario: Verify send POST request to create checkout with valid request body and non existing medicine transaction ID
    @Step("I set valid create checkout API endpoint with non esxisting medicine transaction ID")
    public String setCreateCheckoutWithNonExistMedTransID(){
        return url + "/users/medicines-payments/checkout?medicine_transaction_id=999";
    }

    @Step("I send POST HTTP request for create checkout with non existing medicine transaction ID")
    public void sendPostCreateCheckoutWithNonExistMedTransID(){
        File imageFile = new File("E:\\!SIB\\!capstone-project\\API_Mobile_Automation\\src\\test\\java\\starter\\user\\emojipng.com-1738931.png");

        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .multiPart("payment_confirmation", imageFile, "image/jpeg")
                .post(setCreateCheckoutWithNonExistMedTransID());
    }

    @Step("I receive valid message that failed to create checkout with non existing medicine transaction ID")
    public void validateMessageFailedCreateCheckoutWithNonExistMedTransID(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("permission denied")));
    }



//    Scenario: Verify send POST request to create checkout with invalid payment confirmation and valid medicine transaction ID
    @Step("I send POST HTTP request for create checkout with valid medicine transaction ID and invalid payment confirmation")
    public void sendPostCreateCheckoutWithInvalidPaymentConfirmation(){
        File imageFile = new File("C:\\Users\\ferna\\Dropbox\\PC\\Downloads\\Hasil Diskusi BE dan UI_UX.pdf");

        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .multiPart("payment_confirmation", imageFile, "file/pdf")
                .post(setCreateCheckoutWithNonExistMedTransID());
    }

    @Step("I receive valid message that failed to create checkout with invalid payment confirmation")
    public void validateMessageFailedCreateCheckoutWithInvalidPaymentConfirmation(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("invalid image file format. only jpg, jpeg, png allowed")));
    }



//    Scenario: Verify send POST request to create checkout with empty payment confirmation and valid medicine transaction ID
    @Step("I send POST HTTP request for create checkout with valid medicine transaction ID and empty payment confirmation")
    public void sendPostCreateCheckoutWithEmptyPaymentConfirmation(){
        File imageFile = new File("E:\\!SIB\\!capstone-project\\API_Mobile_Automation\\src\\test\\java\\starter\\user\\emojipng.com-1738931.png");

        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .multiPart("payment_confirmation", "")
                .post(setCreateCheckoutWithNonExistMedTransID());
    }

    @Step("I receive valid message that failed to create checkout with empty payment confirmation")
    public void validateMessageFailedCreateCheckoutWithEmptyPaymentConfirmation(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("image file required")));
    }



//    Scenario: Verify send GET request to get all checkout endpoint
    @Step("I set valid get all checkout API endpoint")
    public String setValidGetAllCheckout(){
        return url + "/users/medicines-payments/checkout?offset=0&limit=5";
    }

    @Step("I send GET HTTP request for get all checkout")
    public void sendValidGetAllCheckout(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .get(setValidGetAllCheckout());
    }

    @Step("I receive valid message that successfully get data checkouts")
    public void validateMessageSuccessGetAllCheckout(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("successfully get data checkouts")));
    }



//    Scenario: Verify send GET request to get checkout by status pending endpoint
    @Step("I set valid get checkout by status pending API endpoint")
    public String setValidGetCheckoutByStatusPending(){
        return url + "/users/medicines-payments/checkout?offset=0&limit=5&payment_status=pending";
    }

    @Step("I send GET HTTP request for get checkout by status pending")
    public void sendValidGetCheckoutByStatusPending(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .get(setValidGetCheckoutByStatusPending());
    }



//    Scenario: Verify send GET request to get checkout by status success endpoint
    @Step("I set valid get checkout by status success API endpoint")
    public String setValidGetCheckoutByStatusSuccess(){
        return url + "/users/medicines-payments/checkout?offset=0&limit=5&payment_status=success";
    }

    @Step("I send GET HTTP request for get checkout by status success")
    public void sendValidGetCheckoutByStatusSuccess(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .get(setValidGetCheckoutByStatusSuccess());
    }



//    Scenario: Verify send GET request to get checkout by status cancelled endpoint
    @Step("I set valid get checkout by status cancelled API endpoint")
    public String setValidGetCheckoutByStatusCancelled(){
        return url + "/users/medicines-payments/checkout?offset=0&limit=5&payment_status=cancelled";
    }

    @Step("I send GET HTTP request for get checkout by status cancelled")
    public void sendValidGetCheckoutByStatusCancelled(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .get(setValidGetCheckoutByStatusCancelled());
    }



//    Scenario: Verify send GET request to get checkout by invalid status endpoint
    @Step("I set valid get checkout by invalid status API endpoint")
    public String setValidGetCheckoutByInvalidStatus(){
        return url + "/users/medicines-payments/checkout?offset=0&limit=5&payment_status=12345";
    }

    @Step("I send GET HTTP request for get checkout by invalid status")
    public void sendValidGetCheckoutByInvalidStatus(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .get(setValidGetCheckoutByInvalidStatus());
    }

    @Step("I receive valid message that failed get checkout with invalid status")
    public void validateMessageFailedGetCheckoutByInvalidStatus(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("checkouts not found")));
    }




//    Scenario: Verify send GET request to get checkout by ID endpoint
    @Step("I set valid get checkout by valid ID API endpoint")
    public String setValidGetCheckoutByID(){
        return url + "/users/medicines-payments/checkout/100";
    }

    @Step("I send GET HTTP request for get checkout by valid ID")
    public void sendValidGetCheckoutByID(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .get(setValidGetCheckoutByID());
    }

    @Step("I receive valid message that successfully get data checkout")
    public void validateMessageSuccessGetCheckoutByID(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("successfully get data checkout")));
    }



//    Scenario: Verify send GET request to get checkout by invalid ID endpoint
    @Step("I set valid get checkout by invalid ID API endpoint")
    public String setInvalidGetCheckoutByID(){
        return url + "/users/medicines-payments/checkout/abcde";
    }

    @Step("I send GET HTTP request for get checkout by invalid ID")
    public void sendGetCheckoutByInvalidID(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .get(setInvalidGetCheckoutByID());
    }

    @Step("I receive valid message that failed to get checkout by invalid ID")
    public void validateMessageFailedGetCheckoutByInvalidCheckoutID(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("invalid checkout id")));
    }



//    Scenario: Verify send GET request to get checkout by non existing ID endpoint
    @Step("I set valid get checkout by non existing ID API endpoint")
    public String setGetCheckoutByNonExistID(){
        return url + "/users/medicines-payments/checkout/999";
    }

    @Step("I send GET HTTP request for get checkout by non existing ID")
    public void sendGetCheckoutByNonExistID(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .get(setGetCheckoutByNonExistID());
    }

    @Step("I receive valid message that failed to get checkout by non existing ID")
    public void validateMessageFailedGetCheckoutByNonExistID(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("not found checkout")));
    }





}
