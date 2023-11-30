package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.ProductCategories;

public class ProductCategoriesSteps {

    @Steps
    ProductCategories productCategories;

    @Given("I set create categories API endpoint")
    public void setValidCreateCategory(){
        productCategories.setCreateCategoryEndpoint();
    }

    @When("I send POST HTTP request for create categories with valid name and description")
    public void successSendPostCreateCategory(){
        productCategories.sendValidPostCreateCategory();
    }


    @When("I send POST HTTP request for create categories with invalid request body that empty name")
    public void successSendEmptyNamePostCreateCategory(){
        productCategories.sendEmptyNamePostCategory();
    }

    @Then("I receive HTTP response status code 500 Internal Server Error")
    public void validateStatus500ISE(){
        productCategories.receiveResponseStatusCode500ISE();
    }

    @When("I send POST HTTP request for create categories with invalid request body that name is numeric")
    public void successSendNumericNamePostCategory(){
        productCategories.sendNumericNamePostCreateCategory();
    }

    @Then("I receive HTTP response status code 400 Bad Request")
    public void validateStatus400BadRequest(){
        productCategories.receiveResponseStatusCodde400BadRequest();
    }

    @When("I send DELETE HTTP request for create categories with valid name and description")
    public void successSendDeleteForCreateCategory(){
        productCategories.sendDeleteToCreateCategory();
    }

    @Given("I set invalid create categories API endpoint")
    public void setCreateCategoryInvalidEndpoint(){
        productCategories.setInvalidCreateCategoryEndpoint();
    }

    @When("I send POST HTTP request for create categories with invalid endpoint")
    public void successSendPostToInvalidEndpoint(){
        productCategories.sendPostToInvalidCreateCategoryEndpoint();
    }

    @Then("I receive HTTP response status code 404 Not Found")
    public void validateStatus404NotFound(){
        productCategories.receiveStatusCode404NotFound();
    }

    @Given("I set get all categories API endpoint")
    public void setValidGetAllCategories(){
        productCategories.setGetAllCategoriesEndpoint();
    }

    @When("I send GET HTTP request for get all categories")
    public void successSendGetAllCategories(){
        productCategories.sendGetForAllCategories();
    }

    @When("I send DELETE HTTP request for get all categories")
    public void successSendDeleteToGetAllCategories(){
        productCategories.sendDeleteToGetAllCategories();
    }

    @Then("I receive HTTP response status code 405 Method Not Allowed")
    public void validateStatus405MNA(){
        productCategories.receiveStatusCode405MNA();
    }

    @Given("I set invalid get all categories API endpoint")
    public void setInvalidGetALlCategoriesEndpoint(){
        productCategories.setInvalidGetAllCategoriesEndpoint();
    }

    @When("I send GET HTTP request for invalid get all categories")
    public void sendGetToInvalidGetAllEndpoint(){
        productCategories.sendGetToInvalidGetAllEndpoint();
    }

    @Given("I set get categories by ID API endpoint")
    public void setValidGetCategoryById(){
        productCategories.setGetCategoryByIdEndpoint();
    }

    @When("I send GET HTTP request for get categories by ID")
    public void successSendGetCategoryByID(){
        productCategories.sendGetCategoryByIDEndpoint();
    }

    @Given("I set get categories by ID API endpoint with invalid ID")
    public void setInvalidCategoriesIDEndpoint(){
        productCategories.setGetCategoryWithInvalidIDEndpoint();
    }

    @When("I send GET HTTP request for get categories by invalid ID")
    public void successSendGetToInvalidCategoriesID(){
        productCategories.sendGetToInvalidCategoriesID();
    }


    @Given("I set get categories by ID API endpoint with ID exceeding the limit")
    public void setGetExceedCategoriesID(){
        productCategories.setGetCategoryIDWithExceedLimit();
    }

    @When("I send GET HTTP request for get categories by ID exceeding the limit")
    public void successSendGetExceedCategoriesID(){
        productCategories.sendGetToExceedIDEndpoint();
    }


    @When("I send POST HTTP request for get categories by ID")
    public void successSendPostToGetCategoryByID(){
        productCategories.sendPostToGetCategoryByID();
    }

    @Given("I set delete category ID API endpoint")
    public void setValidDeleteCategoryByID(){
        productCategories.setDeleteCategoryEndpoint();
    }

    @When("I send DELETE HTTP request for delete category")
    public void successSendDeleteCategoryByID(){
        productCategories.sendDeleteCategory();
    }

    @Given("I set delete category API endpoint with ID exceeding the limit")
    public void setDeleteToCategoryIdExceeded(){
        productCategories.setDeleteCategoryWithIdIsExceed();
    }

    @When("I send DELETE HTTP request for delete category by ID exceeding the limit")
    public void successSendDeleteToExceededCategoryId(){
        productCategories.sendDeleteToExceedCategoryID();
    }


    @Given("I set invalid delete category API endpoint")
    public void setInvalidEndpointOfDeleteCategoryByID(){
        productCategories.setInvalidDeleteCategoryByIdEndpoint();
    }

    @When("I send DELETE HTTP request for invalid delete category")
    public void successSendDeleteForInvalidDeleteCategoryEndpoint(){
        productCategories.sendDeleteToInvalidDeleteCategoryEndpoint();
    }

    @When("I send POST HTTP request for delete category")
    public void successSendPostToEndpointOfDeleteCategoryById(){
        productCategories.sendPostToDeleteCategoryEndpoint();
    }



}
