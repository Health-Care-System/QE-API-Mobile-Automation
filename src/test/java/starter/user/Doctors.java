package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class Doctors {

    protected String url = "";


//    Scenario: Verify send GET request to get all available doctors endpoint
    @Step("I set get all available doctors API endpoint")
    public String setValidGetAllAvailableDoctors(){
        return url + "/users/doctors/available?offset=0&limit=3";
    }

    @Step("I send GET HTTP request for get all available doctors")
    public void sendValidGetAllAvailableDoctors(){
        SerenityRest
                .given()
                .get(setValidGetAllAvailableDoctors());
    }

    @Step("I receive valid message that Data Dokter Berhasil Diambil")
    public void validateMessageGetAllAvailableDoctors(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("data successfully retrieved")));
    }


//    Scenario: Verify send POST request to get all available doctors endpoint
    @Step("I send POST HTTP request for get all available doctors")
    public void sendPostToGetAllAvailableDoctors(){
        SerenityRest.given().post(setValidGetAllAvailableDoctors());
    }


//    Scenario: Verify send GET request to get all doctors based on specialization endpoint
    @Step("I set get doctors by specialization API endpoint with valid specialization name")
    public String setValidGetDoctorBySpecialization(){
        return url + "/users/doctors?specialist=gigi&offset=0&limit=3";
    }

    @Step("I send GET HTTP request for get all available doctors by valid specialization name")
    public void sendValidGetDoctorBySpecialization(){
        SerenityRest.given().get(setValidGetDoctorBySpecialization());
    }

    @Step("I receive valid message that data successfully retrieved")
    public void validateMessageGetDoctorBySpecialization(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("data successfully retrieved")));
    }


//    Scenario: Verify send GET request to get all doctors based on specialization endpoint with invalid specialization name
    @Step("I set get doctors by specialization API endpoint with invalid specialization name")
    public String setGetDoctorByInvalidSpecialization(){
        return url + "/users/doctors?specialist=salah&offset=0&limit=3";
    }

    @Step("I send GET HTTP request for get all available doctors by invalid specialization name")
    public void sendGetDoctorByInvalidSpecialization(){
        SerenityRest.given().get(setGetDoctorByInvalidSpecialization());
    }

    @Step("I receive valid message that data not found")
    public void validateMessageGetDoctorByInvalidSpecialization(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("data not found")));
    }


//    Scenario: Verify send POST request to get all doctors based on specialization endpoint
    @Step("I send POST HTTP request for get all available doctors by valid specialization name")
    public void sendPostToGetDoctorBySpecialization(){
        SerenityRest.given().post(setValidGetDoctorBySpecialization());
    }

}
