package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class Chatbots {

    protected String url = "https://www.healthify.my.id";


//    Scenario: Verify send POST request to chatbot endpoint with valid request (Cara Pembayaran Obat)
    @Step("I set customer service bot API endpoint")
    public String setValidCustomerService(){
        return  url + "/customerservice";
    }

    @Step("I send POST HTTP request for customer service with the request is Cara Pembayaran Obat")
    public void sendPostRequestCaraBayarObat(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("request", "cara pembayaran obat");

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setValidCustomerService());
    }

    @Step("I receive valid message that successfully get data recommendation")
    public void validateMessageSuccessUsingCustomerService(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("successfully get data recommendation")));
    }


//    Scenario: Verify send POST request to chatbot endpoint with valid request (Cara Beri Rating Dokter)
    @Step("I send POST HTTP request for customer service with the request is Cara Beri Rating Dokter")
    public void sendPostRequestCaraRatingDokter(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("request", "cara beri rating dokter");

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setValidCustomerService());
    }


//    Scenario: Verify send POST request to chatbot endpoint with valid request (Cara Lihat Riwayat Konsultasi)
    @Step("I send POST HTTP request for customer service with the request is Cara Lihat Riwayat Konsultasi")
    public void sendPostRequestCaraLihatRiwayatKonsultasi(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("request", "cara lihat riwayat konsultasi");

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setValidCustomerService());
    }


//    Scenario: Verify send POST request to chatbot endpoint with valid request (Get Health Advice and Diet Recommendation)
    @Step("I set chat bot API endpoint")
    public String setChatBotEndpoint(){
        return url + "/chatbot";
    }

    @Step("I send POST HTTP request for chat bot with the request is Health Advice")
    public void sendPostChatBotRequestHealthAdvice(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("request", "berikan saya rekomendasi atau saran mengenai penyakit panas dan demam");

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setChatBotEndpoint());
    }


//    Scenario: Verify send POST request to chatbot endpoint with empty request
    @Step("I send POST HTTP request for chat bot with empty request")
    public void sendPostChatBotWithEmptyRequest(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("request", "");

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setChatBotEndpoint());
    }

    @Step("I receive valid message that Failed on Request Validation")
    public void validateMessageChatbotEmptyRequest(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("Field 'Request' failed on 'required' validation")));
    }


//    Scenario: Verify send POST request to chatbot endpoint with invalid request
    @Step("I send POST HTTP request for chat bot with the request is asking for medicine prescription")
    public void sendPostChatbotInvalidRequest(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("request", "berikan resep obat untuk kondisi saya sekarang, saya sedang sakit demam dan sakit perut");

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setChatBotEndpoint());
    }


//    Scenario: Verify send GET request to chatbot endpoint with valid request
    @Step("I send GET HTTP request for chat bot with the request is Health Advice")
    public void sendGetToChatBotEndpoint(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("request", "berikan saya rekomendasi atau saran mengenai penyakit panas dan demam");

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .get(setChatBotEndpoint());
    }

}
