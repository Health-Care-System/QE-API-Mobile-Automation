package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Consultation;

public class ConsultationSteps {

    @Steps
    Consultation consultation;

    //    Scenario: Verify send POST to create room chat by valid doctor transaction ID
    @Given("I set valid create room chat by valid doctor transaction ID API endpoint")
    public void setValidCreateRoomChatEndpoint(){
        consultation.setValidCreateRoomChatByValidDocTransID();
    }

    @When("I send POST HTTP request for create room chat by valid doctor transaction ID")
    public void successSendValidPostCreateRoomChat(){
        consultation.sendValidPostCreateRoomChat();
    }

    @And("I receive valid message that roomchat created successful")
    public void receiveMessageRoomChatCreatedSuccessful(){
        consultation.validateMessageSuccessCreateRoomChat();
    }


    //    Scenario: Verify send POST to create room chat by invalid doctor transaction ID
    @Given("I set valid create room chat by invalid doctor transaction ID API endpoint")
    public void setCreateRoomChatByInvalidDocTransIDEndpoint(){
        consultation.setCreateRoomChatByInvalidDoctorTransaction();
    }

    @When("I send POST HTTP request for create room chat by invalid doctor transaction ID")
    public void successSendPostCreateRoomChatByInvalidDocTransID(){
        consultation.sendPostCreateRoomChatByInvalidDocTransID();
    }

    @And("I receive valid message that failed create room chat by invalid doctor transaction ID")
    public void receiveMessageFailedCreateRoomChatByInvalidDocTransID(){
        consultation.validateMessageFailedCreateRoomChatByInvalidDocTransID();
    }

    //    Scenario: Verify send POST to create room chat by non existing doctor transaction ID
    @Given("I set valid create room chat by non existing doctor transaction ID API endpoint")
    public void setCreateRoomChatByNonExistDocTransIDEndpoint(){
        consultation.setCreateRoomChatByNonExistDocTransID();
    }

    @When("I send POST HTTP request for create room chat by non existing doctor transaction ID")
    public void successSendPostCreateRoomChatByNonExistDocTransID(){
        consultation.sendPostCreateRoomChatByNonExistDocTransID();
    }

    @And("I receive valid message that failed create room chat by non existing doctor transaction ID")
    public void receiveMessageFailedCreateRoomChatByNonExistDocTransID(){
        consultation.validateMessageFailedCreateRoomChatByNonExistDocTransID();
    }



//    Scenario: Verify send POST to create room chat by doctor transaction ID with the status is still pending
    @Given("I set valid create room chat by doctor transaction ID with status pending API endpoint")
    public void setCreateRoomChatByDocTransIDStatusPendingEndpoint(){
        consultation.setCreateRoomChatByDocTransIDStatusPending();
    }

    @When("I send POST HTTP request for create room chat by doctor transaction ID with status pending")
    public void successSendPostCreateRoomChatByDocTransIDStatusPending(){
        consultation.sendPostCreateRoomChatByDocTransIDStatusPending();
    }

    @And("I receive valid message that failed to retrieve doctor transaction data for create room chat")
    public void receiveMessageFailedRetrieveDocTransData(){
        consultation.validateMessageFailedRetrieveDocTransData();
    }



    //    Scenario: Verify send POST to create room chat by doctor transaction ID with the status is cancelled
    @Given("I set valid create room chat by doctor transaction ID with status cancelled API endpoint")
    public void setCreateRoomChatByDocTransIDStatusCancelledEndpoint(){
        consultation.setCreateRoomChatByDocTransIDStatusCancelled();
    }

    @When("I send POST HTTP request for create room chat by doctor transaction ID with status cancelled")
    public void successSendPostCreateRoomChatByDocTransIDStatusCancelled(){
        consultation.sendPostCreateRoomChatByDocTransStatusCancelled();
    }



    //    Scenario: Verify send POST to create room chat by doctor transaction ID that has been used
    @And("I receive valid message that failed create room chat by already used doctor transaction ID")
    public void receiveMessageRoomChatAlreadyExist(){
        consultation.validateMessageRoomChatAlreadyExist();
    }



    //    Scenario: Verify send POST to create complaint message by valid room chat ID and valid request body
    @Given("I set valid create complaint message by valid room chat ID API endpoint")
    public void setValidCreateComplaintMessageByValidRoomChatID(){
        consultation.setValidCreateComplaintMessageByValidRoomChatID();
    }

    @When("I send POST HTTP request for create complaint message by valid room chat ID")
    public void successSendPostCreateComplaintMessageByValidRoomChat(){
        consultation.sendPostCreateComplaintMessageByValidRoomChatID();
    }

    @And("I receive valid message that complaint message successful send")
    public void receiveMessageComplaintMessageSentSuccessfully(){
        consultation.validateMessageSuccessSentComplaintMessage();
    }



    //    Scenario: Verify send POST to create complaint message by valid room chat ID and sent image file
    @When("I send POST HTTP request for create complaint message by valid room chat ID and sent image file")
    public void successSendPostCreateComplaintMessageWithAttachValidImageFile(){
        consultation.sendPostCreateComplaintMessageWithAttachValidImageFile();
    }



    //    Scenario: Verify send POST to create complaint message by valid room chat ID and sent audio message
    @When("I send POST HTTP request for create complaint message by valid room chat ID and sent audio file")
    public void successSendPostCreateComplaintMessageWithAttachValidAudioFile(){
        consultation.sendPostCreateComplaintMessageWithAttachValidAudioFile();
    }


//    Scenario: Verify send POST to create complaint message by invalid room chat ID and valid request body
    @Given("I set valid create complaint message by invalid room chat ID API endpoint")
    public void setCreateComplaintMessageByInvalidRoomChatIDEndpoint(){
        consultation.setCreateComplaintMessageByInvalidRoomChatID();
    }

    @When("I send POST HTTP request for create complaint message by invalid room chat ID")
    public void successSendPostCreateComplaintMessageWithInvalidRoomChatID(){
        consultation.sendPostCreateComplaintMessageByInvalidRoomChatID();
    }

    @And("I receive valid message that invalid roomchat id")
    public void receiveMessageInvalidRoomChatID(){
        consultation.validateMessageInvalidRoomChatID();
    }



//    Scenario: Verify send POST to create complaint message by non existing room chat ID and valid request body
    @Given("I set valid create complaint message by non existing room chat ID API endpoint")
    public void setCreateComplaintMessageByNonExistingRoomChatIDEndpoint(){
        consultation.setCreateComplaintMessageByNonExistingRoomChatID();
    }

    @When("I send POST HTTP request for create complaint message by non existing room chat ID")
    public void successSendPostCreateComplaintMessageWithNonExistingRoomChatID(){
        consultation.sendPostCreateComplaintMessageByNonExistingRoomChatID();
    }

    @And("I receive valid message that failed to retrieve roomchat data")
    public void receiveMessageFailedRetrieveRoomChat(){
        consultation.validateMessageFailedRetrieveRoomChat();
    }




    //    Scenario: Verify send POST to create complaint message by valid room chat ID and sent invalid file format for image field
    @When("I send POST HTTP request for create complaint message by valid room chat ID and sent invalid file format for image field")
    public void successSendPostCreateComplaintMessageWithAttachInvalidImage(){
        consultation.sendPostCreateComplaintMessageWithAttachInvalidImage();
    }

    @And("I receive valid message that invalid image file format for consultation message")
    public void receiveMessageInvalidImageFileConsultationMessage(){
        consultation.validateMessageInvalidImageConsultationMessage();
    }


    //    Scenario: Verify send POST to create complaint message by valid room chat ID and sent exceed maximum image size
    @When("I send POST HTTP request for create complaint message by valid room chat ID and sent exceed image zize")
    public void successSendPostCreateComplaintMessageWithAttachExceedImageSize(){
        consultation.sendPostCreateComplaintMessageWithAttachExceedImage();
    }

    @And("I receive valid message that file size exceeds the maximum allowed size")
    public void receiveMessageExceedAttachmentFileSize(){
        consultation.validateMessageExceedAttachementFileSize();
    }



    //    Scenario: Verify send POST to create complaint message by valid room chat ID and sent invalid file format for audio field
    @When("I send POST HTTP request for create complaint message by valid room chat ID and sent invalid file format for audio field")
    public void successSendPostCreateComplaintMessageWithAttachInvalidAudio(){
        consultation.sendPostCreateComplaintMessageWithAttachInvalidAudio();
    }

    @And("I receive valid message that invalid audio file format")
    public void receiveMessageInvalidAudioFileFormat(){
        consultation.validateMessageInvalidAudioFile();
    }



    //    Scenario: Verify send POST to create complaint message by valid room chat ID and sent exceed maximum audio size
    @When("I send POST HTTP request for create complaint message by valid room chat ID and sent exceed audio zize")
    public void successSendPostCreateComplaintMessageWithAttachExceedAudioSize(){
        consultation.sendPostCreateComplaintMessageWithAttachExceedAudioFileSize();
    }


    //    Scenario: Verify send GET to get room chat by valid ID
    @Given("I set get room chat by valid ID API endpoint")
    public void setGetRoomChatByValidIDEndpoint(){
        consultation.setValidGetRoomChatByValidID();
    }

    @When("I send GET HTTP request for get room chat by valid ID")
    public void successSendGetRoomChatByValidID(){
        consultation.sendGetRoomChatByValidID();
    }

    @And("I receive valid message that roomchat data successfully retrieved")
    public void receiveMessageRoomChatSuccessfullyRetrieved(){
        consultation.validateMessageRoomChatSUccessfullyRetrieved();
    }



    //    Scenario: Verify send GET to get room chat by invalid ID
    @Given("I set get room chat by invalid ID API endpoint")
    public void setGetRoomChatByInvalidIDEndpoint(){
        consultation.setGetRoomChatByInvalidID();
    }

    @When("I send GET HTTP request for get room chat by invalid ID")
    public void successSendGetRoomChatByInvalidID(){
        consultation.sendGetRoomChatByInvalidID();
    }



//    Scenario: Verify send GET to get room chat by non existing ID
    @Given("I set get room chat by non existing ID API endpoint")
    public void setGetRoomChatByNonExistIDEndpoint(){
        consultation.setGetRoomChatByNonExistID();
    }

    @When("I send GET HTTP request for get room chat by non existing ID")
    public void successSendGetRoomChatByNonExistID(){
        consultation.sendGetRoomChatByNonExistID();
    }



}
