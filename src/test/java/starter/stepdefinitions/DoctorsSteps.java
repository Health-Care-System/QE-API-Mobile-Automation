package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Doctors;

public class DoctorsSteps {

    @Steps
    Doctors doctors;


    //    Scenario: Verify send GET request to get all available doctors endpoint
    @Given("I set get all available doctors API endpoint")
    public void setValidGetALlAvailableDoctors(){
        doctors.setValidGetAllAvailableDoctors();
    }

    @When("I send GET HTTP request for get all available doctors")
    public void successSendValidGetAllAvailableDoctors(){
        doctors.sendValidGetAllAvailableDoctors();
    }

    @And("I receive valid message that Data Dokter Berhasil Diambil")
    public void receiveMessageDataSuccessfullyRetrieved(){
        doctors.validateMessageGetAllAvailableDoctors();
    }



    //    Scenario: Verify send POST request to get all available doctors endpoint
    @When("I send POST HTTP request for get all available doctors")
    public void successSendPostToGetAllHealthArticle(){
        doctors.sendPostToGetAllAvailableDoctors();
    }



    //    Scenario: Verify send GET request to get all doctors based on specialization endpoint
    @Given("I set get doctors by specialization API endpoint with valid specialization name")
    public void setValidGetAllDoctorBySpecializationEndpoint(){
        doctors.setValidGetDoctorBySpecialization();
    }

    @When("I send GET HTTP request for get all available doctors by valid specialization name")
    public void successSendGetDoctorBySpecialization(){
        doctors.sendValidGetDoctorBySpecialization();
    }

    @And("I receive valid message that data successfully retrieved")
    public void receiveMessageSuccessGetDoctorBySpecialization(){
        doctors.validateMessageGetDoctorBySpecialization();
    }


//    Scenario: Verify send GET request to get all doctors based on specialization endpoint with invalid specialization name
    @Given("I set get doctors by specialization API endpoint with invalid specialization name")
    public void setGetDoctorByInvalidSpecializationEndpoint(){
        doctors.setGetDoctorByInvalidSpecialization();
    }

    @When("I send GET HTTP request for get all available doctors by invalid specialization name")
    public void successSendGetDoctorByInvalidSpecialization(){
        doctors.sendGetDoctorByInvalidSpecialization();
    }

    @And("I receive valid message that data not found")
    public void receiveMessageForGetDoctorByInvalidSpecialization(){
        doctors.validateMessageGetDoctorByInvalidSpecialization();
    }


    //    Scenario: Verify send POST request to get all doctors based on specialization endpoint
    @When("I send POST HTTP request for get all available doctors by valid specialization name")
    public void successSendPostToGetDoctorBySpecialization(){
        doctors.sendPostToGetDoctorBySpecialization();
    }


}
