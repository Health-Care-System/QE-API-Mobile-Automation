package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Medicines;

public class MedicinesSteps {

    @Steps
    Medicines medicines;

//    Scenario: Verify send GET request to get all medicines endpoint
    @Given("I set get all medicines API endpoint")
    public void setValidGetALlMedicines(){
        medicines.setGetAllMedicines();
    }

    @When("I send GET HTTP request for get all medicines")
    public void successSendGetALlMedicines(){
        medicines.sendGetAllMedicines();
    }

    @And("I receive valid message that Medicines Data Successfully Retrieved")
    public void validateMessageMedicinesDataSuccessfullyRetrieved(){
        medicines.receiveMessageSuccessGetAllMedicines();
    }

    //    Scenario: Verify send POST request to get all medicines endpoint
    @When("I send POST HTTP request for get all medicines")
    public void successSendPostToGetAllMedicines(){
        medicines.sendPostToGetAllMedicines();
    }

    @Then("I receive HTTP response status code 405 Method Not Allowed")
    public void validateStatus405(){
        medicines.receiveResponseStatusCode405MethodNotAllowed();
    }


//    Scenario: Verify send GET request to get medicines by name endpoint with valid name
    @Given("I set get medicine by name API endpoint with valid name")
    public void setValidGetMedicineByNameEndpoint(){
        medicines.setValidGetMedicineByName();
    }

    @When("I send GET HTTP request for get medicine by name")
    public void successSendValidGetMedicineByName(){
        medicines.sendValidGetMedicineByName();
    }



//    Scenario: Verify send GET request to get medicines by name endpoint with invalid name
    @Given("I set get medicine by name API endpoint with invalid name")
    public void setInvalidGetByMedicineName(){
        medicines.setGetMedicineByInvalidName();
    }

    @When("I send GET HTTP request for get medicine by invalid name")
    public void successSendGetMedicineByInvalidName(){
        medicines.sendGetMedicineByInvalidName();
    }

    @Then("I receive HTTP response status code 404 Not Found")
    public void validateStatus404(){
        medicines.receiveResponseStatusCode404();
    }

    @And("I receive valid message that Medicine Not Found")
    public void receiveMessageMedicineNotFound(){
        medicines.validateMessageGetMedicineByInvalidName();
    }


//    Scenario: Verify send POST request to get medicines by name endpoint with valid name
    @When("I send POST HTTP request for get medicine by name")
    public void successSendPostToGetMedicineByName(){
        medicines.sendPostToGetMedicineByName();
    }



//    Scenario: Verify send GET request to get medicine by ID endpoint with valid medicine ID
    @Given("I set get medicine by ID API endpoint with valid ID")
    public void setValidGetMedicineByIDEndpoint(){
        medicines.setValidGetMedicineByID();
    }

    @When("I send GET HTTP request for get medicine by ID")
    public void successSendValidGetMedicineByID(){
        medicines.sendValidGetMedicineByID();
    }



    //    Scenario: Verify send GET request to get medicine by ID endpoint with invalid medicine ID
    @Given("I set get medicine by invalid ID API endpoint with invalid ID")
    public void setInvalidGetMedicineByID(){
        medicines.setGetMedicineByInvalidID();
    }

    @When("I send GET HTTP request for get medicine by invalid ID")
    public void successSendGetMedicineByInvalidID(){
        medicines.sendGetMedicineByInvalidID();
    }

    @And("I receive valid message that Invalid Medicine ID")
    public void receiveMessageInvalidMedicineID(){
        medicines.validateMessageGetMedicineByInvalidID();
    }


//    Scenario: Verify send GET request to get medicine by ID endpoint with non existing medicine ID
    @Given("I set get medicine by invalid ID API endpoint with non existing ID")
    public void setGetMedicineByNonExistingID(){
        medicines.setGetMedicineByNonExistID();
    }

    @When("I send GET HTTP request for get medicine by non existing ID")
    public void successSendGetMedicineByNonExistID(){
        medicines.sendGetMedicineByNonExistID();
    }

    @Then("I receive HTTP response status code 500 Internal Server Error")
    public void validateStatus500(){
        medicines.receiveResponseStatusCode500();
    }

    @And("I receive valid message that Failed to Retrieve Medicine Data")
    public void receiveMessageFailedRetrieveMedicineData(){
        medicines.validateMessageGetNonExistMedicineID();
    }


//    Scenario: Verify send POST request to get medicine by ID endpoint with valid medicineID
    @When("I send POST HTTP request for get medicine by ID")
    public void successSendPostToGetMedicineByID(){
        medicines.sendPostToGetMedicineByID();
    }

}
