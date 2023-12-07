package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.TransactionDoctor;

public class TransactionDoctorSteps {

    @Steps
    TransactionDoctor transactionDoctor;

    //    Scenario: Verify send POST request to create doctor transaction endpoint with valid doctor ID, payment method, and payment confirmation
    @Given("I set create doctor transaction API endpoint with valid doctor ID")
    public void setValidCrateDocTransactionEndpoint(){
        transactionDoctor.setValidCreateDocTransaction();
    }

    @When("I send POST HTTP request for create doctor transaction with valid request body")
    public void successSendValidPostCreateDocTransaction(){
        transactionDoctor.sendPostValidCreateDocTransaction();
    }

    @Then("I receive HTTP response status code 201 Created")
    public void validateStatusCode201(){
        transactionDoctor.receiveResponseStatusCode201();
    }

    @And("I receive valid message that doctor transaction created successful")
    public void receiveMessageDocTransactionCreatedSuccessful(){
        transactionDoctor.validateMessageSuccessCreateDocTransaction();
    }


//    Scenario: Verify send POST request to create doctor transaction endpoint with invalid doctor ID
    @Given("I set create doctor transaction API endpoint with invalid doctor ID")
    public void setCreateDocTransWithInvalidID(){
        transactionDoctor.setCreateDocTransInvalidID();
    }

    @When("I send POST HTTP request for create doctor transaction to invalid doctor ID endpoint")
    public void successSendPostCreateDocTransToInvalidID(){
        transactionDoctor.sendPostCreateDocTransInvalidID();
    }


    @And("I receive valid message that invalid doctor id")
    public void receiveMessageInvalidDoctorID(){
        transactionDoctor.validateMessageCreateDOcTransByInvalidID();
    }


//    Scenario: Verify send POST request to create doctor transaction with non existing doctor ID
    @Given("I set create doctor transaction API endpoint with non existing doctor ID")
    public void setTransactionDoctorWithNonExistID(){
        transactionDoctor.setCreateDocTransWithNonExistID();
    }

    @When("I send POST HTTP request for create doctor transaction to non exist doctor ID")
    public void successSendPostCreateDocTransToNonExistID(){
        transactionDoctor.sendPostCreateDocTransNonExistID();
    }

    @And("I receive valid message that doctor failed to retrieve doctor data")
    public void receiveMessageFailedRetrieveDoctorData(){
        transactionDoctor.validateMessageCreateDocTransWithNonExistID();
    }


//    Scenario: Verify send POST request to create doctor transaction with empty doctor ID
    @Given("I set create doctor transaction API endpoint with empty doctor ID")
    public void setTransactionDoctorWithEmptyID(){
        transactionDoctor.setCreateDocTransEmptyID();
    }

    @When("I send POST HTTP request for create doctor transaction to empty doctor ID")
    public void successSendPostCreateDocTransEmptyID(){
        transactionDoctor.sendPostCreateDocTransEmptyID();
    }



    //    Scenario: Verify send POST request to create doctor transaction with empty payment method
    @When("I send POST HTTP request for create doctor transaction with empty payment method")
    public void successSendPostCreateDocTransWithEMptyPaymentMethod(){
        transactionDoctor.sendPostCreateDocTransWithEmptyPaymentMethod();
    }

    @And("I receive valid message that Failed on Payment Method Validation")
    public void receiveMessagePaymentMethodValidation(){
        transactionDoctor.validateMessageCreateDocTransWithEmptyPaymentMethod();
    }



    //    Scenario: Verify send POST request to create doctor transaction with invalid payment method
    @When("I send POST HTTP request for create doctor transaction with invalid payment method")
    public void successSendPostCreateDoctorTransactionWithInvalidPaymentMethod(){
        transactionDoctor.sendPostCreateDocTransWithInvalidPaymentMethod();
    }

    @And("I receive valid message that failed to create doctor transaction")
    public void receiveMessageFailedCreateDocTrans(){
        transactionDoctor.validateMessageDoctorTransactionWithInvalidPaymentMethod();
    }



    //    Scenario: Verify send POST request to create doctor transaction with empty payment confirmation
    @When("I send POST HTTP request for create doctor transaction with empty payment confirmation")
    public void successSendPostCreateDocTransEmptyPaymentConfirmation(){
        transactionDoctor.sendPostCreateDocTransWithEmptyPaymentConfirmation();
    }

    @And("I receive valid message that payment confirmation file is required")
    public void receiveMessagePaymentConfirmationRequired(){
        transactionDoctor.validateMessagePaymentConfirmationIsEmpty();
    }


    //    Scenario: Verify send POST request to create doctor transaction with invalid file for payment confirmation
    @When("I send POST HTTP request for create doctor transaction with invalid payment confirmation")
    public void successSendPostCreateDocTransWithInvalidPaymentConfirmation(){
        transactionDoctor.sendPostCreateDocTransWithInvalidPaymentConfirmation();
    }

    @And("I receive valid message that invalid image file format")
    public void receiveMessageInvalidFileFormat(){
        transactionDoctor.validateMessageInvalidPaymentConfirmation();
    }


    //    Scenario: Verify send GET request to get all doctor transactions endpoint
    @Given("I set get all doctor transactions API endpoint")
    public void setValidGetAllDocTransEndpoint(){
        transactionDoctor.setValidGetAllDocTrans();
    }

    @When("I send GET HTTP request for get all doctor transactions")
    public void successSendValidGetAllDocTrans(){
        transactionDoctor.sendValidGetAllDoctorTransaction();
    }

    @And("I receive valid message that doctor transaction data successfully retrieved")
    public void receiveMessageSuccessfullyRetrievedDocTrans(){
        transactionDoctor.validateMessageValidGetAllDocTrans();
    }


    //    Scenario: Verify send POST request to get all doctor transactions endpoint
    @When("I send POST HTTP request for get all doctor transactions")
    public void successSendPostToGetAllDocTrans(){
        transactionDoctor.sendPostToGetAllDocTrans();
    }


    //    Scenario: Verify send GET request to get doctor transaction by status success
    @Given("I set get doctor transactions API endpoint with status success")
    public void setValidGetDocTransByStatusSuccessEndpoint(){
        transactionDoctor.setValidGetDocTransByStatusSuccess();
    }

    @When("I send GET HTTP request for get doctor transactions with status success")
    public void successSendGetDocTransByStatusSuccess(){
        transactionDoctor.sendGetDocTransByStatusSuccess();
    }

//    Scenario: Verify send GET request to get doctor transaction by status pending
    @Given("I set get doctor transactions API endpoint with status pending")
    public void setValidGetDocTransByStatusPendingEndpoint(){
        transactionDoctor.setValidGetDocTransByStatusPending();
    }

    @When("I send GET HTTP request for get doctor transactions with status pending")
    public void successSendGetDocTransByStatusPending(){
        transactionDoctor.sendGetDocTransByStatusPending();
    }


    //    Scenario: Verify send GET request to get doctor transaction by status cancelled
    @Given("I set get doctor transactions API endpoint with status cancelled")
    public void setValidGetDocTransByStatusCancelledEndpoint(){
        transactionDoctor.setValidGetDocTransByStatusCancelled();
    }

    @When("I send GET HTTP request for get doctor transactions with status cancelled")
    public void successSendGetDocTransByStatusCancelled(){
        transactionDoctor.sendGetDocTransByStatusCancelled();
    }


    //    Scenario: Verify send POST request to get doctor transaction by status endpoint
    @When("I send POST HTTP request for get doctor transactions with status pending")
    public void successSendPostDocTransByStatusPending(){
        transactionDoctor.sendPostToDocTransByStatusPending();
    }



    //    Scenario: Verify send GET request to get doctor transaction by valid ID
    @Given("I set get doctor transactions by valid ID API endpoint")
    public void setValidDocTransByIDEndpoint(){
        transactionDoctor.setValidGetDocTransByID();
    }

    @When("I send GET HTTP request for get doctor transactions by valid ID")
    public void successSendGetDocTransByID(){
        transactionDoctor.sendGetDocTransByValidID();
    }



    //    Scenario: Verify send GET request to get doctor transaction by invalid ID
    @Given("I set get doctor transactions by invalid ID API endpoint")
    public void setGetDocTransByInvalidIDEndpoint(){
        transactionDoctor.setGetDocTransByInvalidID();
    }

    @When("I send GET HTTP request for get doctor transactions by invalid ID")
    public void successSendGetDocTransByInvalidID(){
        transactionDoctor.sendGetDocTransByInvalidID();
    }

    @And("I receive valid message that invalid transaction id")
    public void receiveMessageInvalidTransactionID(){
        transactionDoctor.validateMessageGetDocTransByInvalidID();
    }



    //    Scenario: Verify send GET request to get doctor transaction by non existing ID
    @Given("I set get doctor transactions by non exist ID API endpoint")
    public void setGetDocTransByNonExistID(){
        transactionDoctor.setGetDocTransByNonExistID();
    }

    @When("I send GET HTTP request for get doctor transactions by non exist ID")
    public void successSendGetDocTransByNonExistID(){
        transactionDoctor.sendGetDocTransByNonExistID();
    }

    @And("I receive valid message that failed to retrieve doctor transaction data")
    public void receiveMessageFailedRetrieveDocTransData(){
        transactionDoctor.validateMessageGetDocTransByNonExistID();
    }


    //    Scenario: Verify send POST request to get doctor transaction by valid ID
    @When("I send POST HTTP request for get doctor transactions by valid ID")
    public void successSendPostToGetDocTransByValidID(){
        transactionDoctor.sendPostToGetDocTransByID();
    }


}
