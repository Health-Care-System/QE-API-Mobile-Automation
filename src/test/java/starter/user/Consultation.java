package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.json.JSONObject;

import java.io.File;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class Consultation {

    protected String url = "https://dev.healthify.my.id";

    protected String tokenLoginUser = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6InBhc2llbmhlYWx0aGlmeUBnbWFpbC5jb20iLCJleHAiOjE3MDMzNzY2ODEsImlkIjoxNzUsInJvbGUiOiJ1c2VyIn0.GYCC7t2SR9yx3og9zZoe_s2TF3DpAGKigCfZfLh_i-s";

    protected String docTransID = "269"; // success id = 260 - 265

    protected String roomChatID = "95"; // untuk skenario kirim pesan


//    Scenario: Verify send POST to create room chat by valid doctor transaction ID
    @Step("I set valid create room chat by valid doctor transaction ID API endpoint")
    public String setValidCreateRoomChatByValidDocTransID(){
        return url + "/users/chats/" + docTransID;
    }

    @Step("I send POST HTTP request for create room chat by valid doctor transaction ID")
    public void sendValidPostCreateRoomChat(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .post(setValidCreateRoomChatByValidDocTransID());
    }

    @Step("I receive valid message that roomchat created successful")
    public void validateMessageSuccessCreateRoomChat(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("roomchat created successful")));
    }


//    Scenario: Verify send POST to create room chat by invalid doctor transaction ID
    @Step("I set valid create room chat by invalid doctor transaction ID API endpoint")
    public String setCreateRoomChatByInvalidDoctorTransaction(){
        return url + "/users/chats/abcde";
    }

    @Step("I send POST HTTP request for create room chat by invalid doctor transaction ID")
    public void sendPostCreateRoomChatByInvalidDocTransID(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .post(setCreateRoomChatByInvalidDoctorTransaction());
    }

    @Step("I receive valid message that failed create room chat by invalid doctor transaction ID")
    public void validateMessageFailedCreateRoomChatByInvalidDocTransID(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("invalid transaction id")));
    }


//    Scenario: Verify send POST to create room chat by non existing doctor transaction ID
    @Step("I set valid create room chat by non existing doctor transaction ID API endpoint")
    public String setCreateRoomChatByNonExistDocTransID(){
        return url + "/users/chats/999";
    }

    @Step("I send POST HTTP request for create room chat by non existing doctor transaction ID")
    public void sendPostCreateRoomChatByNonExistDocTransID(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .post(setCreateRoomChatByNonExistDocTransID());
    }

    @Step("I receive valid message that failed create room chat by non existing doctor transaction ID")
    public void validateMessageFailedCreateRoomChatByNonExistDocTransID(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("failed to retrieve doctor transaction data")));
    }



//    Scenario: Verify send POST to create room chat by doctor transaction ID with the status is still pending
    @Step("I set valid create room chat by doctor transaction ID with status pending API endpoint")
    public String setCreateRoomChatByDocTransIDStatusPending(){
        return url + "/users/chats/84";
    }

    @Step("I send POST HTTP request for create room chat by doctor transaction ID with status pending")
    public void sendPostCreateRoomChatByDocTransIDStatusPending(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .post(setCreateRoomChatByDocTransIDStatusPending());
    }

    @Step("I receive valid message that failed to retrieve doctor transaction data for create room chat")
    public void validateMessageFailedRetrieveDocTransData(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("failed to retrieve doctor transaction data")));
    }



//    Scenario: Verify send POST to create room chat by doctor transaction ID with the status is cancelled
    @Step("I set valid create room chat by doctor transaction ID with status cancelled API endpoint")
    public String setCreateRoomChatByDocTransIDStatusCancelled(){
        return url + "/users/chats/64";
    }

    @Step("I send POST HTTP request for create room chat by doctor transaction ID with status cancelled")
    public void sendPostCreateRoomChatByDocTransStatusCancelled(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .post(setCreateRoomChatByDocTransIDStatusCancelled());
    }



//    Scenario: Verify send POST to create room chat by doctor transaction ID that has been used
    @Step("I receive valid message that failed create room chat by already used doctor transaction ID")
    public void validateMessageRoomChatAlreadyExist(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("roomchat for this transaction id already exists")));
    }



//    Scenario: Verify send POST to create complaint message by valid room chat ID and valid request body
    @Step("I set valid create complaint message by valid room chat ID API endpoint")
    public String setValidCreateComplaintMessageByValidRoomChatID(){
        return url + "/users/chats/" + roomChatID + "/message";
    }

    @Step("I send POST HTTP request for create complaint message by valid room chat ID")
    public void sendPostCreateComplaintMessageByValidRoomChatID(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .multiPart("message", "halo dok")
                .post(setValidCreateComplaintMessageByValidRoomChatID());
    }

    @Step("I receive valid message that complaint message successful send")
    public void validateMessageSuccessSentComplaintMessage(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("complaint message successful send")));
    }


//    Scenario: Verify send POST to create complaint message by valid room chat ID and sent image file
    @Step("I send POST HTTP request for create complaint message by valid room chat ID and sent image file")
    public void sendPostCreateComplaintMessageWithAttachValidImageFile(){
        File imageFile = new File("E:\\!SIB\\!capstone-project\\API_Mobile_Automation\\src\\test\\java\\starter\\user\\emojipng.com-1738931.png");

        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
//                .formParams("message", "Kirim gambar")
                .multiPart("image", imageFile, "image/jpeg")
                .post(setValidCreateComplaintMessageByValidRoomChatID());
    }



//    Scenario: Verify send POST to create complaint message by valid room chat ID and sent audio message
    @Step("I send POST HTTP request for create complaint message by valid room chat ID and sent audio file")
    public void sendPostCreateComplaintMessageWithAttachValidAudioFile(){
        File audioFile = new File("C:\\Users\\ferna\\Dropbox\\PC\\Downloads\\roomid30.mp3");

        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .multiPart("audio", audioFile, "audio/mp3")
                .post(setValidCreateComplaintMessageByValidRoomChatID());
    }



//    Scenario: Verify send POST to create complaint message by invalid room chat ID and valid request body
    @Step("I set valid create complaint message by invalid room chat ID API endpoint")
    public String setCreateComplaintMessageByInvalidRoomChatID(){
        return url + "/users/chats/abcde/message";
    }

    @Step("I send POST HTTP request for create complaint message by invalid room chat ID")
    public void sendPostCreateComplaintMessageByInvalidRoomChatID(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .formParams("message", "halo dok")
                .post(setCreateComplaintMessageByInvalidRoomChatID());
    }

    @Step("I receive valid message that invalid roomchat id")
    public void validateMessageInvalidRoomChatID(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("invalid roomchat id")));
    }


//    Scenario: Verify send POST to create complaint message by non existing room chat ID and valid request body
    @Step("I set valid create complaint message by non existing room chat ID API endpoint")
    public String setCreateComplaintMessageByNonExistingRoomChatID(){
        return url + "/users/chats/999/message";
    }

    @Step("I send POST HTTP request for create complaint message by non existing room chat ID")
    public void sendPostCreateComplaintMessageByNonExistingRoomChatID(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .formParams("message", "halo dok")
                .post(setCreateComplaintMessageByNonExistingRoomChatID());
    }

    @Step("I receive valid message that failed to retrieve roomchat data")
    public void validateMessageFailedRetrieveRoomChat(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("failed to retrieve roomchat data")));
    }



//    Scenario: Verify send POST to create complaint message by valid room chat ID and sent invalid file format for image field
    @Step("I send POST HTTP request for create complaint message by valid room chat ID and sent invalid file format for image field")
    public void sendPostCreateComplaintMessageWithAttachInvalidImage(){
        File imageFile = new File("C:\\Users\\ferna\\Dropbox\\PC\\Downloads\\Hasil Diskusi BE dan UI_UX.pdf");

        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
//                .formParams("message", "Kirim gambar")
                .multiPart("image", imageFile, "file/pdf")
                .post(setValidCreateComplaintMessageByValidRoomChatID());
    }

    @Step("I receive valid message that invalid image file format for consultation message")
    public void validateMessageInvalidImageConsultationMessage(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("invalid image file format. supported formats: .jpg, .jpeg, .png")));
    }



//    Scenario: Verify send POST to create complaint message by valid room chat ID and sent exceed maximum image size
    @Step("I send POST HTTP request for create complaint message by valid room chat ID and sent exceed image zize")
    public void sendPostCreateComplaintMessageWithAttachExceedImage() {
        File imageFile = new File("C:\\Users\\ferna\\Dropbox\\PC\\Downloads\\image11mb.jpg");

        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
//                .formParams("message", "Kirim gambar")
                .multiPart("image", imageFile, "image/jpeg")
                .post(setValidCreateComplaintMessageByValidRoomChatID());
    }

    @Step("I receive valid message that file size exceeds the maximum allowed size")
    public void validateMessageExceedAttachementFileSize(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("file size exceeds the maximum allowed size")));
    }



//    Scenario: Verify send POST to create complaint message by valid room chat ID and sent invalid file format for audio field
    @Step("I send POST HTTP request for create complaint message by valid room chat ID and sent invalid file format for audio field")
    public void sendPostCreateComplaintMessageWithAttachInvalidAudio(){
        File imageFile = new File("C:\\Users\\ferna\\Dropbox\\PC\\Downloads\\Hasil Diskusi BE dan UI_UX.pdf");

        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
//                .formParams("message", "Kirim gambar")
                .multiPart("audio", imageFile, "file/pdf")
                .post(setValidCreateComplaintMessageByValidRoomChatID());
    }

    @Step("I receive valid message that invalid audio file format")
    public void validateMessageInvalidAudioFile(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("invalid audio file format. supported formats: .mp3, .wav, .flac")));
    }



//    Scenario: Verify send POST to create complaint message by valid room chat ID and sent exceed maximum audio size
    @Step("I send POST HTTP request for create complaint message by valid room chat ID and sent exceed audio zize")
    public void sendPostCreateComplaintMessageWithAttachExceedAudioFileSize(){
        File audioFile = new File("C:\\Users\\ferna\\Dropbox\\PC\\Downloads\\Free_Test_Data_1OMB_MP3.mp3");

        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
//                .formParams("message", "Kirim gambar")
                .multiPart("audio", audioFile, "audio/mp3")
                .post(setValidCreateComplaintMessageByValidRoomChatID());
    }




    //    Scenario: Verify send GET to get room chat by valid ID
    @Step("I set get room chat by valid ID API endpoint")
    public String setValidGetRoomChatByValidID(){
        return url + "/users/chats/" + roomChatID;
    }

    @Step("I send GET HTTP request for get room chat by valid ID")
    public void sendGetRoomChatByValidID(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .get(setValidGetRoomChatByValidID());
    }

    @Step("I receive valid message that roomchat data successfully retrieved")
    public void validateMessageRoomChatSUccessfullyRetrieved(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("roomchat data successfully retrieved")));
    }



//    Scenario: Verify send GET to get room chat by invalid ID
    @Step("I set get room chat by invalid ID API endpoint")
    public String setGetRoomChatByInvalidID(){
        return url + "/users/chats/abcde";
    }

    @Step("I send GET HTTP request for get room chat by invalid ID")
    public void sendGetRoomChatByInvalidID(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .get(setGetRoomChatByInvalidID());
    }



//    Scenario: Verify send GET to get room chat by non existing ID
    @Step("I set get room chat by non existing ID API endpoint")
    public String setGetRoomChatByNonExistID(){
        return url + "/users/chats/999";
    }

    @Step("I send GET HTTP request for get room chat by non existing ID")
    public void sendGetRoomChatByNonExistID(){
        SerenityRest.given()
                .header("Authorization", tokenLoginUser)
                .get(setGetRoomChatByNonExistID());
    }


}
