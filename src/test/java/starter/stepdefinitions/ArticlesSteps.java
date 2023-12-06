package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Articles;

public class ArticlesSteps {

    @Steps
    Articles articles;



    //    Scenario: Verify send GET request to get all health articles endpoint
    @Given("I set get all health articles API endpoint")
    public void setValidGetAllHealthArticlesEndpoint(){
        articles.setValidGetAllHealthArticles();
    }

    @When("I send GET HTTP request for get all health articles")
    public void successSendGetAllHealthArticles(){
        articles.sendValidGetAllHealthArticles();
    }

    @And("I receive valid message that successfully get data articles")
    public void receiveMessageSuccessfullyGetDataArticle(){
        articles.validateMessageSuccessGetAllHealthArticles();
    }



    //    Scenario: Verify send POST request to get all health articles endpoint
    @When("I send POST HTTP request for get all health articles")
    public void successSendPostToGetAllHealthArticles(){
        articles.sendPostToGetAllHealthArticles();
    }


    //    Scenario: Verify send GET request to get health article by ID endpoint with valid article ID
    @Given("I set get health article by ID API endpoint with valid ID")
    public void setValidGetArticleByIDEndpoint(){
        articles.setValidGetArticleByID();
    }

    @When("I send GET HTTP request for get health article by valid ID")
    public void successSendGetHealthArticleByID(){
        articles.sendValidGetHealthArticleByID();
    }

    @And("I receive valid message that successfully get data")
    public void receiveMessageSuccessfullyGetData(){
        articles.validateMessageSuccessGetArticleByID();
    }


//    Scenario: Verify send GET request to get health article by ID endpoint with invalid article ID
    @Given("I set get health article by invalid ID API endpoint with invalid ID")
    public void setGetArticleByInvalidIDEndpoint(){
        articles.setGetArticleByInvalidID();
    }

    @When("I send GET HTTP request for get health article by invalid ID")
    public void successSendGetArticleByInvalidID(){
        articles.sendGetHealthArticleByInvalidID();
    }

    @And("I receive valid message that invalid id param")
    public void receiveMessageInvalidIDParam(){
        articles.validateMessageGetArticleByInvalidID();
    }


//    Scenario: Verify send GET request to get health article by ID endpoint with non existing article ID
    @Given("I set get health article by ID API endpoint with non existing ID")
    public void setGetHealthArticleByNonExistID(){
        articles.setGetArticleByNonExistID();
    }

    @When("I send GET HTTP request for get health article non existing ID")
    public void successSendGetHealthArticleByNonExistID(){
        articles.sendGetHealthArticleByNonExistID();
    }

    @And("I receive valid message that not found")
    public void receiveMessageArticleNotFound(){
        articles.validateMessageGetNonExistArticleID();
    }



//    Scenario: Verify send POST request to get health article by ID endpoint with valid article ID
    @When("I send POST HTTP request for get health article by valid ID")
    public void successSendPostToGetHealthArticleByID(){
        articles.sendPostToGetHealthArticleByID();
    }


    //    Scenario: Verify send GET request to get health article by ID endpoint with valid article title
    @Given("I set get health article by title API endpoint with valid title")
    public void setValidGetArticleByTitle(){
        articles.setValidGetHealthArticleByTittle();
    }

    @When("I send GET HTTP request for get health article by valid title")
    public void successSendGetHealthArticleByTittle(){
        articles.sendValidGetArticleByTittle();
    }

    @And("I receive valid message that successfully get data article")
    public void receiveMessageSuccessfullyGetDataArticleWithValidTitle(){
        articles.validateMessageSuccessGetAllHealthArticleByValidTitle();
    }


//    Scenario: Verify send GET request to get health article by ID endpoint with invalid article title
    @Given("I set get health article by title API endpoint with invalid title")
    public void setGetArticleByInvalidTitle(){
        articles.setGetHealthArticleByInvalidTitle();
    }

    @When("I send GET HTTP request for get health article by invalid title")
    public void successSendGetArticleByInvalidTitle(){
        articles.sendGetHealthArticleByInvalidTitle();
    }


    //    Scenario: Verify send GET request to get health article by ID endpoint with empty parameter
    @Given("I set get health article by title API endpoint with empty title parameter")
    public void setValidGetArticleWithEmptyParam(){
        articles.setGetHealthArticleWithEmptyTitleParam();
    }

    @When("I send GET HTTP request for get health article with empty title parameter")
    public void successSendGetHealthArticleWithEmptyParamTitle(){
        articles.sendGetHealthArticleWithEmptyTitleParam();
    }


    @And("I receive valid message that title query param required")
    public void receiveMessageTitleQueryParamRequired(){
        articles.validateMessageEmptyTitle();
    }


    //    Scenario: Verify send POST request to get health article by ID endpoint with valid article title
    @When("I send POST HTTP request for get health article by valid title")
    public void successSendPostToGetArticleByValidTitle(){
        articles.sendPostToGetHealthArticleByTittle();
    }

}
