package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Chatbots;

public class ChatbotsSteps {

    @Steps
    Chatbots chatbots;


    //    Scenario: Verify send POST request to chatbot endpoint with valid request (Cara Pembayaran Obat)
    @Given("I set customer service bot API endpoint")
    public void setValidCustomerServiceEndpoint(){
        chatbots.setValidCustomerService();
    }

    @When("I send POST HTTP request for customer service with the request is Cara Pembayaran Obat")
    public void successSendValidPostRequestCaraPembayaranObat(){
        chatbots.sendPostRequestCaraBayarObat();
    }

    @And("I receive valid message that successfully get data recommendation")
    public void receiveMessageSuccessGetDataRecommendation(){
        chatbots.validateMessageSuccessUsingCustomerService();
    }


    //    Scenario: Verify send POST request to chatbot endpoint with valid request (Cara Beri Rating Dokter)
    @When("I send POST HTTP request for customer service with the request is Cara Beri Rating Dokter")
    public void successSendPostRequestCaraBeriratingDokter(){
        chatbots.sendPostRequestCaraRatingDokter();
    }


    //    Scenario: Verify send POST request to chatbot endpoint with valid request (Cara Lihat Riwayat Konsultasi)
    @When("I send POST HTTP request for customer service with the request is Cara Lihat Riwayat Konsultasi")
    public void successSendPostRequestCaraLihatRiwayatKonsultasi(){
        chatbots.sendPostRequestCaraLihatRiwayatKonsultasi();
    }



    //    Scenario: Verify send POST request to chatbot endpoint with valid request (Get Health Advice and Diet Recommendation)
    @Given("I set chat bot API endpoint")
    public void setValidChatBotEndpoint(){
        chatbots.setChatBotEndpoint();
    }

    @When("I send POST HTTP request for chat bot with the request is Health Advice")
    public void successSendValidPostChatBotRequestHealthAdvice(){
        chatbots.sendPostChatBotRequestHealthAdvice();
    }


    //    Scenario: Verify send POST request to chatbot endpoint with empty request
    @When("I send POST HTTP request for chat bot with empty request")
    public void successSendPostChatbotWithEmptyRequest(){
        chatbots.sendPostChatBotWithEmptyRequest();
    }

    @And("I receive valid message that Failed on Request Validation")
    public void receiveMessageFailedRequestValidation(){
        chatbots.validateMessageChatbotEmptyRequest();
    }


    //    Scenario: Verify send POST request to chatbot endpoint with invalid request
    @When("I send POST HTTP request for chat bot with the request is asking for medicine prescription")
    public void successSendPostChatbotInvalidRequest(){
        chatbots.sendPostChatbotInvalidRequest();
    }



    //    Scenario: Verify send GET request to chatbot endpoint with valid request
    @When("I send GET HTTP request for chat bot with the request is Health Advice")
    public void successSendGetToChatbot(){
        chatbots.sendGetToChatBotEndpoint();
    }


}
