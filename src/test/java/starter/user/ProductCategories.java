package starter.user;


import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class ProductCategories {

    protected String url = "https://altashop-api.fly.dev/api";

//    Scenario: POST - As a user i have be able to create new product category
    @Step("I set create categories API endpoint")
    public String setCreateCategoryEndpoint(){
        return url + "/categories";
    }

    @Step("I send POST HTTP request for create categories with valid name and description")
    public void sendValidPostCreateCategory(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "Alat Tulis");
        requestBody.put("description", "Untuk anak sekolah");

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setCreateCategoryEndpoint());
    }

//    Scenario: POST - As a user i should be failed to create new product category with empty name
    @Step("I send POST HTTP request for create categories with invalid request body that empty name")
    public void sendEmptyNamePostCategory(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "");
        requestBody.put("description", "Untuk anak sekolah");

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setCreateCategoryEndpoint());
    }

    @Step("I receive HTTP response status code 500 Internal Server Error")
    public void receiveResponseStatusCode500ISE(){
        restAssuredThat(response -> response.statusCode(500));
    }

//    Scenario: POST - As a user i should be failed to create new product category with the name is numeric
    @Step("I send POST HTTP request for create categories with invalid request body that name is numeric")
    public void sendNumericNamePostCreateCategory(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", 12345);
        requestBody.put("description", "Untuk anak sekolah");

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setCreateCategoryEndpoint());
    }

    @Step("I receive HTTP response status code 400 Bad Request")
    public void receiveResponseStatusCodde400BadRequest(){
        restAssuredThat(response -> response.statusCode(400));
    }

//    Scenario: DELETE - As a user i should be failed to create new product category with invalid HTTP method
    @Step("I send DELETE HTTP request for create categories with valid name and description")
    public void sendDeleteToCreateCategory(){
        SerenityRest.when().delete(setCreateCategoryEndpoint());
    }

//    Scenario: POST - As a user i should be failed to create new product category with invalid endpoint
    @Step("I set invalid create categories API endpoint")
    public String setInvalidCreateCategoryEndpoint(){
        return url + "/categoriessalah";
    }

    @Step("I send POST HTTP request for create categories with invalid endpoint")
    public void sendPostToInvalidCreateCategoryEndpoint(){
        SerenityRest.when().post(setInvalidCreateCategoryEndpoint());
    }

    @Step("I receive HTTP response status code 404 Not Found")
    public void receiveStatusCode404NotFound(){
        restAssuredThat(response -> response.statusCode(404));
    }

//    Scenario: GET - As a user i have be able to get all product categories
    @Step("I set get all categories API endpoint")
    public  String setGetAllCategoriesEndpoint(){
        return url + "/categories";
    }

    @Step("I send GET HTTP request for get all categories")
    public void sendGetForAllCategories(){
        SerenityRest.when().get(setGetAllCategoriesEndpoint());
    }

//    Scenario: DELETE - As a user i should be failed to get all categories with invalid HTTP method
    @Step("I send DELETE HTTP request for get all categories")
    public void sendDeleteToGetAllCategories(){
        SerenityRest.when().delete(setGetAllCategoriesEndpoint());
    }

    @Step("I receive HTTP response status code 405 Method Not Allowed")
    public void receiveStatusCode405MNA(){
        restAssuredThat(response -> response.statusCode(405));
    }

//    Scenario: GET - As a user i should be failed to get all categories with invalid API endpoint
    @Step("I set invalid get all categories API endpoint")
    public String setInvalidGetAllCategoriesEndpoint(){
        return  url + "/categoriessalah";
    }

    @Step("I send GET HTTP request for invalid get all categories")
    public void sendGetToInvalidGetAllEndpoint(){
        SerenityRest.when().get(setInvalidGetAllCategoriesEndpoint());
    }

//    Scenario: GET - As a user i have be able to get category by ID with valid category ID
    @Step("I set get categories by ID API endpoint")
    public String setGetCategoryByIdEndpoint(){
        return url + "/categories/30444";
    }

    @Step("I send GET HTTP request for get categories by ID")
    public void sendGetCategoryByIDEndpoint(){
        SerenityRest.when().get(setGetCategoryByIdEndpoint());
    }

//    Scenario: GET - As a user i should be failed to get category by ID with invalid ID
    @Step("I set get categories by ID API endpoint with invalid ID")
    public String setGetCategoryWithInvalidIDEndpoint(){
        return url +"/categories/9999999999";
    }

    @Step("I send GET HTTP request for get categories by invalid ID")
    public void sendGetToInvalidCategoriesID(){
        SerenityRest.when().get(setGetCategoryWithInvalidIDEndpoint());
    }

//    Scenario: GET - As a user i should be failed to get category by ID with the ID is exceed
    @Step("I set get categories by ID API endpoint with ID exceeding the limit")
    public String setGetCategoryIDWithExceedLimit(){
        return url + "categories/12345678901";
    }

    @Step("I send GET HTTP request for get categories by ID exceeding the limit")
    public void sendGetToExceedIDEndpoint(){
        SerenityRest.when().get(setGetCategoryIDWithExceedLimit());
    }


//    Scenario: POST - As a user i should be failed to get category by ID with invalid HTTP method
    @Step("I send POST HTTP request for get categories by ID")
    public void sendPostToGetCategoryByID(){
        SerenityRest.when().post(setGetCategoryByIdEndpoint());
    }

//    Scenario: DELETE - As a user i have be able to delete product category with valid product ID
    @Step("I set delete category ID API endpoint")
    public String setDeleteCategoryEndpoint(){
        return url + "/categories/29750";
    }

    @Step("I send DELETE HTTP request for delete category")
    public void sendDeleteCategory(){
        SerenityRest.when().delete(setDeleteCategoryEndpoint());
    }

//    Scenario: DELETE - As a user i should be failed to delete product category with product ID is exceed
    @Step("I set delete category API endpoint with ID exceeding the limit")
    public String setDeleteCategoryWithIdIsExceed(){
        return url + "/categories/12345678901";
    }

    @Step("I send DELETE HTTP request for delete category by ID exceeding the limit")
    public void sendDeleteToExceedCategoryID(){
        SerenityRest.when().delete(setDeleteCategoryWithIdIsExceed());
    }


//    Scenario: DELETE - As a user i should be failed to delete product category with invalid delete category endpoint
    @Step("I set invalid delete category API endpoint")
    public String setInvalidDeleteCategoryByIdEndpoint(){
        return url + "/categoriessalah";
    }

    @Step("I send DELETE HTTP request for invalid delete category")
    public void sendDeleteToInvalidDeleteCategoryEndpoint(){
        SerenityRest.when().delete(setInvalidDeleteCategoryByIdEndpoint());
    }

//    Scenario: POST - As a user i should be failed to delete product category with invalid HTTP method
    @Step("I send POST HTTP request for delete category")
    public void sendPostToDeleteCategoryEndpoint(){
        SerenityRest.when().post(setInvalidDeleteCategoryByIdEndpoint());
    }







}
