package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class Medicines {

    protected String url = "https://dev.healthify.my.id";

//    Scenario: Verify send GET request to get all medicines endpoint
    @Step("I set get all medicines API endpoint")
    public String setGetAllMedicines(){
        return url + "/users/medicines?offset=0&limit=3";
    }

    @Step("I send GET HTTP request for get all medicines")
    public void sendGetAllMedicines(){
        SerenityRest.given().get(setGetAllMedicines());
    }

    @Step("I receive valid message that Medicines Data Successfully Retrieved")
    public void receiveMessageSuccessGetAllMedicines(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("successfully get data medicines")));
    }


//    Scenario: Verify send POST request to get all medicines endpoint

    @Step("I send POST HTTP request for get all medicines")
    public void sendPostToGetAllMedicines(){
        SerenityRest.given().post(setGetAllMedicines());
    }

    @Step("I receive HTTP response status code 405 Method Not Allowed")
    public void receiveResponseStatusCode405MethodNotAllowed(){
        restAssuredThat(response -> response.statusCode(405));
    }


//    Scenario: Verify send GET request to get medicines by name endpoint with valid name
    @Step("I set get medicine by name API endpoint with valid name")
    public String setValidGetMedicineByName(){
        return url + "/users/medicines?keyword=Panadol&offset=0&limit=3";
    }

    @Step("I send GET HTTP request for get medicine by name")
    public void sendValidGetMedicineByName(){
        SerenityRest.given().get(setValidGetMedicineByName());
    }


//    Scenario: Verify send GET request to get medicines by name endpoint with invalid name
    @Step("I set get medicine by name API endpoint with invalid name")
    public String setGetMedicineByInvalidName(){
        return url + "/users/medicines?keyword=1234567890&offset=0&limit=3";
    }

    @Step("I send GET HTTP request for get medicine by invalid name")
    public void sendGetMedicineByInvalidName(){
        SerenityRest.given().get(setGetMedicineByInvalidName());
    }

    @Step("I receive HTTP response status code 404 Not Found")
    public void receiveResponseStatusCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step("I receive valid message that Medicine Not Found")
    public void validateMessageGetMedicineByInvalidName(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("medicines not found")));
    }


//    Scenario: Verify send POST request to get medicines by name endpoint with valid name
    @Step("I send POST HTTP request for get medicine by name")
    public void sendPostToGetMedicineByName(){
        SerenityRest.given().post(setValidGetMedicineByName());
    }


//    Scenario: Verify send GET request to get medicine by ID endpoint with valid medicine ID
    @Step("I set get medicine by ID API endpoint with valid ID")
    public String setValidGetMedicineByID(){
        return url + "/users/medicines/2";
    }

    @Step("I send GET HTTP request for get medicine by ID")
    public void sendValidGetMedicineByID(){
        SerenityRest.given().get(setValidGetMedicineByID());
    }

    @Step("I receive valid message that Medicine Data Successfully Retrieved")
    public void validateMessageValidGetMedByID(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("successfully get data medicine")));
    }



//    Scenario: Verify send GET request to get medicine by ID endpoint with invalid medicine ID
    @Step("I set get medicine by invalid ID API endpoint with invalid ID")
    public String setGetMedicineByInvalidID(){
        return url + "/users/medicines/ID";
    }

    @Step("I send GET HTTP request for get medicine by invalid ID")
    public void sendGetMedicineByInvalidID(){
        SerenityRest.given().get(setGetMedicineByInvalidID());
    }

    @Step("I receive valid message that Invalid Medicine ID")
    public void validateMessageGetMedicineByInvalidID(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("invalid id param")));
    }



//    Scenario: Verify send GET request to get medicine by ID endpoint with non existing medicine ID
    @Step("I set get medicine by invalid ID API endpoint with non existing ID")
    public String setGetMedicineByNonExistID(){
        return url + "/users/medicines/999";
    }

    @Step("I send GET HTTP request for get medicine by non existing ID")
    public void sendGetMedicineByNonExistID(){
        SerenityRest.given().get(setGetMedicineByNonExistID());
    }

    @Step("I receive HTTP response status code 500 Internal Server Error")
    public void receiveResponseStatusCode500(){
        restAssuredThat(response -> response.statusCode(500));
    }

    @Step("I receive valid message that Failed to Retrieve Medicine Data")
    public void validateMessageGetNonExistMedicineID(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("failed to retrieve medicine data")));
    }

//    Scenario: Verify send POST request to get medicine by ID endpoint with valid medicineID
    @Step("I send POST HTTP request for get medicine by ID")
    public void sendPostToGetMedicineByID(){
        SerenityRest.given().post(setValidGetMedicineByID());
    }

}
