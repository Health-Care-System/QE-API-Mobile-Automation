package starter.user;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class Articles {

    protected String url = "https://dev.healthify.my.id";

//    Scenario: Verify send GET request to get all health articles endpoint
    @Step("I set get all health articles API endpoint")
    public  String setValidGetAllHealthArticles(){
        return url + "/users/articles?offset=0&limit=10";
    }

    @Step("I send GET HTTP request for get all health articles")
    public void sendValidGetAllHealthArticles(){
        SerenityRest.given().get(setValidGetAllHealthArticles());
    }

    @Step("I receive valid message that successfully get data articles")
    public void validateMessageSuccessGetAllHealthArticles(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("successfully get data articles")));
    }


//    Scenario: Verify send POST request to get all health articles endpoint
    @Step("I send POST HTTP request for get all health articles")
    public void sendPostToGetAllHealthArticles(){
        SerenityRest.given().post(setValidGetAllHealthArticles());
    }


//    Scenario: Verify send GET request to get health article by ID endpoint with valid article ID
    @Step("I set get health article by ID API endpoint with valid ID")
    public String setValidGetArticleByID(){
        return url + "/users/articles/2";
    }

    @Step("I send GET HTTP request for get health article by valid ID")
    public void sendValidGetHealthArticleByID(){
        SerenityRest.given().get(setValidGetArticleByID());
    }

    @Step("I receive valid message that successfully get data")
    public void validateMessageSuccessGetArticleByID(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("successfully get data ")));
    }


//    Scenario: Verify send GET request to get health article by ID endpoint with invalid article ID
    @Step("I set get health article by invalid ID API endpoint with invalid ID")
    public String setGetArticleByInvalidID(){
        return url + "/users/articles/abcde";
    }

    @Step("I send GET HTTP request for get health article by invalid ID")
    public void sendGetHealthArticleByInvalidID(){
        SerenityRest.given().get(setGetArticleByInvalidID());
    }

    @Step("I receive valid message that invalid id param")
    public void validateMessageGetArticleByInvalidID(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("invalid id param")));
    }



//    Scenario: Verify send GET request to get health article by ID endpoint with non existing article ID
    @Step("I set get health article by ID API endpoint with non existing ID")
    public String setGetArticleByNonExistID(){
        return url + "/users/articles/999";
    }

    @Step("I send GET HTTP request for get health article non existing ID")
    public void sendGetHealthArticleByNonExistID(){
        SerenityRest.given().get(setGetArticleByNonExistID());
    }

    @Step("I receive valid message that not found")
    public void validateMessageGetNonExistArticleID(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("not found")));
    }


//    Scenario: Verify send POST request to get health article by ID endpoint with valid article ID
    @Step("I send POST HTTP request for get health article by valid ID")
    public void sendPostToGetHealthArticleByID(){
        SerenityRest.given().post(setValidGetArticleByID());
    }


//    Scenario: Verify send GET request to get health article by ID endpoint with valid article title
    @Step("I set get health article by title API endpoint with valid title")
    public String setValidGetHealthArticleByTittle(){
        return url + "/users/article?offset=0&limit=3&title=stres";
    }

    @Step("I send GET HTTP request for get health article by valid title")
    public void sendValidGetArticleByTittle(){
        SerenityRest.given().get(setValidGetHealthArticleByTittle());
    }

    @Step("I receive valid message that successfully get data article")
    public void validateMessageSuccessGetAllHealthArticleByValidTitle(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("successfully get data article")));
    }


//    Scenario: Verify send GET request to get health article by ID endpoint with invalid article title
    @Step("I set get health article by title API endpoint with invalid title")
    public String setGetHealthArticleByInvalidTitle(){
        return url + "/users/article?offset=0&limit=3&title=habah";
    }

    @Step("I send GET HTTP request for get health article by invalid title")
    public void sendGetHealthArticleByInvalidTitle(){
        SerenityRest.given().get(setGetHealthArticleByInvalidTitle());
    }



//    Scenario: Verify send GET request to get health article by ID endpoint with empty parameter
    @Step("I set get health article by title API endpoint with empty title parameter")
    public String setGetHealthArticleWithEmptyTitleParam(){
        return url + "/users/article?offset=0&limit=3&title=";
    }

    @Step("I send GET HTTP request for get health article with empty title parameter")
    public void sendGetHealthArticleWithEmptyTitleParam(){
        SerenityRest.given().get(setGetHealthArticleWithEmptyTitleParam());
    }

    @Step("I receive valid message that title query param required")
    public void validateMessageEmptyTitle(){
        restAssuredThat(response -> response.body("'meta'.'message'", equalTo("title query param required")));
    }



//    Scenario: Verify send POST request to get health article by ID endpoint with valid article title
    @Step("I send POST HTTP request for get health article by valid title")
    public void sendPostToGetHealthArticleByTittle(){
        SerenityRest.given().post(setValidGetHealthArticleByTittle());
    }





}
