package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.TransactionMedicine;

public class TransactionMedicineSteps {

    @Steps
    TransactionMedicine transactionMedicine;

    //    Scenario: Verify send POST request to create medicine transaction endpoint with valid request body
    @Given("I set valid create medicine transaction API endpoint")
    public void setValidCreateMedTransEndpoint(){
        transactionMedicine.setValidCreateMedTrans();
    }

    @When("I send POST HTTP request for create medicine transaction with valid request body")
    public void successSendValidPostCreateMedTrans(){
        transactionMedicine.sendValidPostCreateMedTrans();
    }

    @And("I receive valid message that successfully created medicine transaction")
    public void receiveMessageSuccessfullyCreatedMedTrans(){
        transactionMedicine.validateMessageSuccessCreateMedTrans();
    }

    //    Scenario: Verify send POST request to create medicine transaction endpoint with multiple diferent product
    @When("I send POST HTTP request for create medicine transaction with multiple diferent product")
    public void successSendPostCreateMedTransWithMultipleDiffProduct(){
        transactionMedicine.sendPostCreateMedTransWithMultipleDiffProduct();
    }


    //    Scenario: Verify send POST request to create medicine transaction endpoint with empty name
    @When("I send POST HTTP request for create medicine transaction with empty name")
    public void successSendPostCreateMedTransWithEmptyName(){
        transactionMedicine.sendPostCreateMedTransWithEmptyName();
    }

    @And("I receive valid message that failed create medicine transaction with empty name")
    public void receiveMessageNameFieldRequiredValidation(){
        transactionMedicine.validateMessageNameFieldRequiredValidation();
    }


    //    Scenario: Verify send POST request to create medicine transaction endpoint with empty address
    @When("I send POST HTTP request for create medicine transaction with empty address")
    public void successSendPostCreateMedTransWithEmptyID(){
        transactionMedicine.sendPostCreateMedTransWithEmptyAddress();
    }

    @And("I receive valid message that failed create medicine transaction with empty address")
    public void receiveMessageAddressFieldRequiredValidation(){
        transactionMedicine.validateMessageAddressFieldRequiredValidation();
    }



    //    Scenario: Verify send POST request to create medicine transaction endpoint with empty phone number
    @When("I send POST HTTP request for create medicine transaction with empty phone number")
    public void successSendPostCreateMedTransWithEmptyPhoneNumber(){
        transactionMedicine.sendPostCreateMedTransWithEmptyPhoneNumber();
    }

    @And("I receive valid message that failed create medicine transaction with empty phone number")
    public void receiveMessageHpFieldRequiredValidation(){
        transactionMedicine.validateMessageHpFieldRequiredValidation();
    }



    //    Scenario: Verify send POST request to create medicine transaction endpoint with empty payment method
    @When("I send POST HTTP request for create medicine transaction with empty payment method")
    public void successSendPostCreateMedTransWithEmptyPaymentMethod(){
        transactionMedicine.sendPostCreateMedTransWithEmptyPaymentMethod();
    }

    @And("I receive valid message that failed create medicine transaction with empty payment method")
    public void receiveMessagePaymentMethodFieldRequiredValidation(){
        transactionMedicine.validateMessagePaymentMethodFieldRequiredValidation();
    }



    //    Scenario: Verify send POST request to create medicine transaction endpoint with non exist medicine ID
    @When("I send POST HTTP request for create medicine transaction with non exist medicine ID")
    public void successSendPostCreateMedWithNonExistID(){
        transactionMedicine.sendPostCreateMedTransWithNonExistMedicineID();
    }

    @And("I receive valid message that failed create medicine transaction with non exist medicine ID")
    public void receiveMessageInvalidMedicineID(){
        transactionMedicine.validateMessageInvalidMedicineID();
    }



    //    Scenario: Verify send POST request to create medicine transaction endpoint with invalid medicine id
    @When("I send POST HTTP request for create medicine transaction with invalid medicine ID")
    public void successSendPostCreateMedTransWithInvalidMedicineID(){
        transactionMedicine.sendPostCreateMedTransWithInvalidID();
    }

    @And("I receive valid message that failed create medicine transaction with invalid medicine ID")
    public void receiveMessageInvalidRequestBody(){
        transactionMedicine.validateMessageInvalidRequestBody();
    }



    //    Scenario: Verify send POST request to create medicine transaction endpoint with empty quantity
    @When("I send POST HTTP request for create medicine transaction with empty quantity")
    public void successSendPostCreateMedTransWithEmptyQuantity(){
        transactionMedicine.sendPostCreateMedTransWithEmptyQuantity();
    }

    @And("I receive valid message that failed create medicine transaction with empty quantity")
    public void receiveMessageQuantityCannotBeEmpty(){
        transactionMedicine.validateMessageQuantityCannotBeEmpty();
    }



    //    Scenario: Verify send POST request to create medicine transaction endpoint with invalid quantity
    @When("I send POST HTTP request for create medicine transaction with invalid quantity")
    public void successSendPostCreateMedTransWithInvalidQuantity(){
        transactionMedicine.sendPostCreateMedTransWithInvalidQuantity();
    }

    @And("I receive valid message that failed create medicine transaction with invalid quantity")
    public void receiveMessageFailedCreateMedTransWithInvalidQuantity(){
        transactionMedicine.validateMessageFailedCreateMedTransWithInvalidQuantity();
    }



    //    Scenario: Verify send DELETE request to create medicine transaction endpoint with valid request body
    @When("I send DELETE HTTP request for create medicine transaction with valid request body")
    public void successSendDeleteToCreateMedTrans(){
        transactionMedicine.sendDeleteToCreateMedTrans();
    }



    //    Scenario: Verify send GET request to get all medicine transactions endpoint
    @Given("I set valid get all medicine transactions API endpoint")
    public void setValidGetAllMedTransEndpoint(){
        transactionMedicine.setValidGetALlMedTrans();
    }

    @When("I send GET HTTP request for get all medicine transactions")
    public void successSendValidGetAllMedTrans(){
        transactionMedicine.sendValidGetAllMedTrans();
    }

    @And("I receive valid message that successfully get data medicine transactions")
    public void receiveMessageSuccessGetAllMedTrans(){
        transactionMedicine.validateMessageSuccessfullyGetAllMedTrans();
    }



    //    Scenario: Verify send POST request to get all medicine transactions endpoint
    @When("I send POST HTTP request for get all medicine transactions")
    public void successSendPostToGetAllMedTrans(){
        transactionMedicine.sendPostToGetAllMedTrans();
    }



    //    Scenario: Verify send GET request to get medicine transaction by status endpoint (belum dibayar)
    @Given("I set valid get medicine transactions by status belum dibayar API endpoint")
    public void setValidGetMedTransByStatusUnpaidEndpoint(){
        transactionMedicine.setValidGetMedTransByStatusUnpaid();
    }

    @When("I send GET HTTP request for get medicine transactions by status belum dibayar")
    public void successSendGetMedTransByStatusUnpaid(){
        transactionMedicine.sendValidGetMedTransByStatusUnpaid();
    }



    //    Scenario: Verify send GET request to ge medicine transaction by status endpoint (sudah dibayar)
    @Given("I set valid get medicine transactions by status sudah dibayar API endpoint")
    public void setValidGetMedTransByStatusPaidEndpoint(){
        transactionMedicine.setValidGetMedTransByStatusPaid();
    }

    @When("I send GET HTTP request for get medicine transactions by status sudah dibayar")
    public void successSendValidGetMedTransByStatusPaid(){
        transactionMedicine.sendValidGetMedTransByStatusPaid();
    }



    //    Scenario: Verify send GET request to get medicine transaction by status endpoint with invalid status
    @Given("I set valid get medicine transactions by invalid API endpoint")
    public void setGetMedTransByInvalidStatus(){
        transactionMedicine.setGetMedTransByInvalidStatus();
    }

    @When("I send GET HTTP request for get medicine transactions by invalid status")
    public void successSendGetMedTransByInvalidStatus(){
        transactionMedicine.sendGetMedTransByInvalidStatus();
    }

    @And("I receive valid message that failed get medicine transaction with invalid status")
    public void receiveMessageFailedGetMedTransByInvalidStatus(){
        transactionMedicine.validateMessageFailedGetMedTransByInvalidStatus();
    }



    //    Scenario: Verify send DELETE request to get transaction by status endpoint
    @When("I send DELETE HTTP request for get medicine transactions by status belum dibayar")
    public void successSendDeleteToGetMedTransByStatusUnpaid(){
        transactionMedicine.sendDeleteToGetMedTransByStatus();
    }



    //    Scenario: Verify send GET request to get medicine transactions by ID endpoint
    @Given("I set valid get medicine transactions by ID API endpoint")
    public void setValidGetMedTransByIDEndpoint(){
        transactionMedicine.setGetMedTransByValidID();
    }

    @When("I send GET HTTP request for get medicine transactions by ID")
    public void successSendGetMedTransByValidID(){
        transactionMedicine.sendGetMedTransByValidID();
    }

    @And("I receive valid message that successfully get data medicine transaction")
    public void receiveMessageSuccessGetMedTransByID(){
        transactionMedicine.validateMessageSuccessfullyGetMedTransByID();
    }


    //    Scenario: Verify send GET request to get medicine transactions by invalid ID endpoint
    @Given("I set get medicine transactions by invalid ID API endpoint")
    public void setGetMedTransByInvalidIDEndpoint(){
        transactionMedicine.setGetMedTransByInvalidID();
    }

    @When("I send GET HTTP request for get medicine transactions by invalid ID")
    public void successSendGetMedTransByInvalidID(){
        transactionMedicine.sendGetMedTransByInvalidID();
    }

    @And("I receive valid message that failed to get medicine transaction by invalid ID")
    public void receiveMessageInvalidMedTransID(){
        transactionMedicine.validateMessageFailedGetMedTransByInvalidID();
    }


    //    Scenario: Verify send GET request to get medicine transactions by non existing ID endpoint
    @Given("I set get medicine transactions by non existing ID API endpoint")
    public void setGetMedTransByNonExistingIDEndpoint(){
        transactionMedicine.setGetMedTransByNonExistingID();
    }

    @When("I send GET HTTP request for get medicine transactions by non existing ID")
    public void successSendGetMedTransByNonExistID(){
        transactionMedicine.sendGetMedTransByNonExistID();
    }

    @And("I receive valid message that failed to get medicine transaction by non existing ID")
    public void receiveMessageFailedGetMedTransByNonExistID(){
        transactionMedicine.validateMessageFailedGetMedTransByNonExistID();
    }



    //    Scenario: Verify send DELETE request to delete medicine transactions by valid ID endpoint
    @Given("I set valid delete medicine transactions API endpoint with valid ID")
    public void setValidDeleteMedTransEndpoint(){
        transactionMedicine.setValidDeleteMedTransByValidID();
    }

    @When("I send DELETE HTTP request for delete medicine transactions with valid ID")
    public void successSendValidDeleteMedTrans(){
        transactionMedicine.sendValidDeleteMedTrans();
    }

    @And("I receive valid message that successfully deleted medicine transaction")
    public void receiveMessageSuccessDeleteMedTrans(){
        transactionMedicine.validateMessageSuccessDeleteMedTrans();
    }


    //    Scenario: Verify send DELETE request to delete medicine transactions by invalid ID endpoint
    @Given("I set valid delete medicine transactions API endpoint with invalid ID")
    public void setDeleteMedTransByInvalidIDEndpoint(){
        transactionMedicine.setDeleteMedTransByInvalidID();
    }

    @When("I send DELETE HTTP request for delete medicine transactions with invalid ID")
    public void successSendDeleteMedTransByInvalidID(){
        transactionMedicine.sendDeleteMedTransByInvalidID();
    }

    @And("I receive valid message that failed to delete medicine transaction with invalid ID")
    public void receiveMessageFailedDeleteMedTransByInvalidID(){
        transactionMedicine.validateMessageFailedDeleteMedTransWithInvalidID();
    }



    //    Scenario: Verify send DELETE request to delete medicine transactions by non existing ID endpoint
    @Given("I set valid delete medicine transactions API endpoint with non existing ID")
    public void setDeleteMedTransByNonExistIDEndpoint(){
        transactionMedicine.setDeleteMedTransByNonExistID();
    }

    @When("I send DELETE HTTP request for delete medicine transactions with non existing ID")
    public void successSendDeleteMedTransByNonExistID(){
        transactionMedicine.sendDeleteMedTransByNonExistID();
    }

    @Then("I receive HTTP response status code 403 Forbidden")
    public void validateResponseCode403(){
        transactionMedicine.receiveResponseStatusCode403();
    }

    @And("I receive valid message that failed to delete medicine transaction with non existing ID")
    public void receiveMessageFailedDeleteMedTransByNonExistID(){
        transactionMedicine.validateMessageFailedDeleteMedTransByNonExistID();
    }



    //    Scenario: Verify send POST request to create checkout with valid request body and medicine transaction ID
    @Given("I set valid create checkout API endpoint with valid medicine transaction ID")
    public void setValidCreateCheckoutEndpoint(){
        transactionMedicine.setCreateCheckoutWithValidID();
    }

    @When("I send POST HTTP request for create checkout with valid medicine transaction ID")
    public void successSendValidPostCreateCheckout(){
        transactionMedicine.sendValidPostCreateCheckout();
    }

    @And("I receive valid message that successfully created checkout")
    public void receiveMessageSuccessfullyCreateCheckout(){
        transactionMedicine.validateMessageSuccessCreateCheckout();
    }



    //    Scenario: Verify send POST request to create checkout with valid request body and invalid medicine transaction ID
    @Given("I set valid create checkout API endpoint with invalid medicine transaction ID")
    public void  setCreateCheckoutWithInvalidMedTransIDEndpoint(){
        transactionMedicine.setCreateCheckoutWithInvalidMEdTransID();
    }

    @When("I send POST HTTP request for create checkout with invalid medicine transaction ID")
    public void successSendPostCreateCheckoutWithInvalidMedTransID(){
        transactionMedicine.sendPostCreateCheckoutWithInvalidMedTransID();
    }

    @And("I receive valid message that failed to create checkout with invalid medicine transaction")
    public void receiveMessageFailedCreateCheckoutWithInvalidMedTransID(){
        transactionMedicine.validateMessageFailedCreateCheckoutWithInvalidMedTransID();
    }



    //    Scenario: Verify send POST request to create checkout with valid request body and non existing medicine transaction ID
    @Given("I set valid create checkout API endpoint with non esxisting medicine transaction ID")
    public void setCreateCheckoutWithNonExistMedTransID(){
        transactionMedicine.setCreateCheckoutWithNonExistMedTransID();
    }

    @When("I send POST HTTP request for create checkout with non existing medicine transaction ID")
    public void successSendPostCreateCheckoutWithNonExistMedTransID(){
        transactionMedicine.sendPostCreateCheckoutWithNonExistMedTransID();
    }

    @And("I receive valid message that failed to create checkout with non existing medicine transaction ID")
    public void receiveMessageFailedCreateCheckoutWithNonExistMedTransID(){
        transactionMedicine.validateMessageFailedCreateCheckoutWithNonExistMedTransID();
    }



    //    Scenario: Verify send POST request to create checkout with invalid payment confirmation and valid medicine transaction ID
    @When("I send POST HTTP request for create checkout with valid medicine transaction ID and invalid payment confirmation")
    public void successSendPostCreateCheckoutWithInvalidPaymentConfirmation(){
        transactionMedicine.sendPostCreateCheckoutWithInvalidPaymentConfirmation();
    }

    @And("I receive valid message that failed to create checkout with invalid payment confirmation")
    public void receiveMessageFailedCreateCheckoutWithInvalidPaymentConfirmation(){
        transactionMedicine.validateMessageFailedCreateCheckoutWithInvalidPaymentConfirmation();
    }



    //    Scenario: Verify send POST request to create checkout with empty payment confirmation and valid medicine transaction ID
    @When("I send POST HTTP request for create checkout with valid medicine transaction ID and empty payment confirmation")
    public void successSendPostCreateCheckoutWithEmptyPaymentConfirmation(){
        transactionMedicine.sendPostCreateCheckoutWithEmptyPaymentConfirmation();
    }

    @And("I receive valid message that failed to create checkout with empty payment confirmation")
    public void receiveMessageFailedCreateCheckoutWithEmptyPaymentConfirmation(){
        transactionMedicine.validateMessageFailedCreateCheckoutWithEmptyPaymentConfirmation();
    }



    //    Scenario: Verify send GET request to get all checkout endpoint
    @Given("I set valid get all checkout API endpoint")
    public void setValidGetAllCheckoutEndpoint(){
        transactionMedicine.setValidGetAllCheckout();
    }

    @When("I send GET HTTP request for get all checkout")
    public void successSendValidGetAllCheckout(){
        transactionMedicine.sendValidGetAllCheckout();
    }

    @And("I receive valid message that successfully get data checkouts")
    public void receiveMessageSuccessGetAllCheckout(){
        transactionMedicine.validateMessageSuccessGetAllCheckout();
    }



    //    Scenario: Verify send GET request to get checkout by status pending endpoint
    @Given("I set valid get checkout by status pending API endpoint")
    public void setValidGetCheckoutByStatusPendingEndpoint(){
        transactionMedicine.setValidGetCheckoutByStatusPending();
    }

    @When("I send GET HTTP request for get checkout by status pending")
    public void successSendGetCheckoutByStatusPending(){
        transactionMedicine.sendValidGetCheckoutByStatusPending();
    }



    //    Scenario: Verify send GET request to get checkout by status success endpoint
    @Given("I set valid get checkout by status success API endpoint")
    public void setValidGetCheckoutByStatusSuccessEndpoint(){
        transactionMedicine.setValidGetCheckoutByStatusSuccess();
    }

    @When("I send GET HTTP request for get checkout by status success")
    public void successSendGetCheckoutByStatusSuccess(){
        transactionMedicine.sendValidGetCheckoutByStatusSuccess();
    }



    //    Scenario: Verify send GET request to get checkout by status cancelled endpoint
    @Given("I set valid get checkout by status cancelled API endpoint")
    public void setValidGetCheckoutByStatusCancelledEndpoint(){
        transactionMedicine.setValidGetCheckoutByStatusCancelled();
    }

    @When("I send GET HTTP request for get checkout by status cancelled")
    public void successSendGetCheckoutByStatusCancelled(){
        transactionMedicine.sendValidGetCheckoutByStatusCancelled();
    }



    //    Scenario: Verify send GET request to get checkout by invalid status endpoint
    @Given("I set valid get checkout by invalid status API endpoint")
    public void setValidGetCheckoutByInvalidStatusEndpoint(){
        transactionMedicine.setValidGetCheckoutByInvalidStatus();
    }

    @When("I send GET HTTP request for get checkout by invalid status")
    public void successSendGetCheckoutByInvalidStatus(){
        transactionMedicine.sendValidGetCheckoutByInvalidStatus();
    }

    @And("I receive valid message that failed get checkout with invalid status")
    public void receiveMessageFailedGetCheckoutByInvalidStatus(){
        transactionMedicine.validateMessageFailedGetCheckoutByInvalidStatus();
    }



    //    Scenario: Verify send GET request to get checkout by ID endpoint
    @Given("I set valid get checkout by valid ID API endpoint")
    public void setValidGetCheckoutByIDEndpoint(){
        transactionMedicine.setValidGetCheckoutByID();
    }

    @When("I send GET HTTP request for get checkout by valid ID")
    public void receiveMessageSuccessGetCheckoutByID(){
        transactionMedicine.sendValidGetCheckoutByID();
    }

    @And("I receive valid message that successfully get data checkout")
    public void receiveMessageSuccessGetCheckoutByValidID(){
        transactionMedicine.validateMessageSuccessGetCheckoutByID();
    }



    //    Scenario: Verify send GET request to get checkout by invalid ID endpoint
    @Given("I set valid get checkout by invalid ID API endpoint")
    public void setValidGetCheckoutByInvalidID(){
        transactionMedicine.setInvalidGetCheckoutByID();
    }

    @When("I send GET HTTP request for get checkout by invalid ID")
    public void successSendGetCheckoutByInvalidID(){
        transactionMedicine.sendGetCheckoutByInvalidID();
    }

    @And("I receive valid message that failed to get checkout by invalid ID")
    public void receiveMessageFailedGetCheckoutByInvalidID(){
        transactionMedicine.validateMessageFailedGetCheckoutByInvalidCheckoutID();
    }



    //    Scenario: Verify send GET request to get checkout by non existing ID endpoint
    @Given("I set valid get checkout by non existing ID API endpoint")
    public void setValidGetCheckoutByNonExistID(){
        transactionMedicine.setGetCheckoutByNonExistID();
    }

    @When("I send GET HTTP request for get checkout by non existing ID")
    public void successSendGetCheckoutByNonExistID(){
        transactionMedicine.sendGetCheckoutByNonExistID();
    }

    @And("I receive valid message that failed to get checkout by non existing ID")
    public void receiveMessageFailedGetCheckoutByNonExistID(){
        transactionMedicine.validateMessageFailedGetCheckoutByNonExistID();
    }














}
