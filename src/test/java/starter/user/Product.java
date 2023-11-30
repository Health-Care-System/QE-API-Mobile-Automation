package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONArray;
import org.json.JSONObject;

public class Product {

    protected String url = "https://altashop-api.fly.dev/api";

//    Scenario: POST - As a user i have be able to create new product
    @Step("I set create product API endpoint")
    public String setCreateProductEndpoint(){
        return url + "/products";
    }

    @Step("I send POST HTTP request for create product with valid request body")
    public void sendPostCreateProductValid(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "Alat Tulis");
        requestBody.put("description", "Untuk anak sekolah");
        requestBody.put("price", 299);

        JSONArray categories = new JSONArray();
        categories.put(1);

        requestBody.put("categories", categories);


        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setCreateProductEndpoint());
    }

//    Scenario: POST - As a user i should be failed to create new product with empty name
    @Step("I send POST HTTP request for create product with invalid request body that empty name")
    public void sendPostCreateProductWithEmptyName(){
        JSONObject requestBody = new JSONObject();

//        requestBody.put("name", "Alat Tulis");
        requestBody.put("description", "Untuk anak sekolah");
        requestBody.put("price", 299);
        requestBody.put("categories", 1);

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setCreateProductEndpoint());
    }

//    Scenario: POST - As a user i should be failed to create new product with the name is numeric
    @Step("I send POST HTTP request for create product with invalid request body that name is numeric")
    public void sendPostCreateProductWithNumericName(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", 12345);
        requestBody.put("description", "Untuk anak sekolah");
        requestBody.put("price", 299);
        requestBody.put("categories", 1);

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setCreateProductEndpoint());
    }

//    Scenario: POST - As a user i should be failed to create new product with the price is alphabetical
    @Step("I send POST HTTP request for create product with invalid request body that price is alphabetical")
    public void sendPostCreateProductWithAlphabeticalPrice(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "Alat Tulis");
        requestBody.put("description", "Untuk anak sekolah");
        requestBody.put("price", "abcde");
        requestBody.put("categories", 1);

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setCreateProductEndpoint());
    }

//    Scenario: POST - As a user i should be failed to create new product with the categories is alphabetical
    @Step("I send POST HTTP request for create product with invalid request body that categories is alphabetical")
    public void sendPostCreateProductWithAlphabeticalCaegories(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "Alat Tulis");
        requestBody.put("description", "Untuk anak sekolah");
        requestBody.put("price", 299);
        requestBody.put("categories", "29714");

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setCreateProductEndpoint());
    }


//    Scenario: POST - As a user i have be able to create new product with multiple category
    @Step("I send POST HTTP request for create product with multiple categories")
    public void sendPostCreateProductWithMultipleCategories(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "Alat Tulis");
        requestBody.put("description", "Untuk anak sekolah");
        requestBody.put("price", 299);
        JSONArray categories = new JSONArray();
        categories.put(1, 2);

        requestBody.put("categories", categories);

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setCreateProductEndpoint());
    }


//    Scenario: DELETE - As a user i should be failed to create new product with invalid HTTP method
    @Step("I send DELETE HTTP request for create product with valid request body")
    public void sendDeleteToCreateProductEndpoint(){
        SerenityRest.given().delete(setCreateProductEndpoint());
    }

//    Scenario: GET - As a user i have be able to get all products
    @Step("I set get all products API endpoint")
    public String setGetAllProductEndpoint(){
        return url + "/products";
    }

    @Step("I send GET HTTP request for get all products")
    public void sendGetAllProductValid(){
        SerenityRest.given().get(setGetAllProductEndpoint());
    }


//    Scenario: GET - As a user i should be failed to get all products  with invalid HTTP method
    @Step("I send POST HTTP request for get all products")
    public void sendPostToGetAllProductsEndpoint(){
        SerenityRest.given().post(setGetAllProductEndpoint());
    }

//    Scenario: GET - As a user i should be failed to get all products  with invalid API endpoint
    @Step("I set invalid get all products API endpoint")
    public String setInvalidGetAllProductsEndpoint(){
        return url + "/productssalah";
    }

    @Step("I send GET HTTP request for invalid get all products API endpoint")
    public void sendGetToInvalidGetAllProductsEndpoint(){
        SerenityRest.given().get(setInvalidGetAllProductsEndpoint());
    }


//    Scenario: GET - As a user i have be able to get product by ID with valid product ID
    @Step("I set get product by ID API endpoint")
    public String setGetProductByIdEndpoint(){
        return url + "/products/85982";
    }

    @Step("I send GET HTTP request for get product by ID")
    public void sendGetProductById(){
        SerenityRest.given().get(setGetProductByIdEndpoint());
    }

//    Scenario: POST - As a user i should be failed to get product by ID with invalid HTTP method

    @Step("I send POST HTTP request for get product by ID")
    public void sendPostToGetProductByIdEndpoint(){
        SerenityRest.given().post(setGetProductByIdEndpoint());
    }

//    Scenario: GET - As a user i should be failed to get product by ID with non existence ID
    @Step("I set get product by ID API endpoint with non existence ID")
    public String setGetProductByNonExistenceId(){
        return url + "/products/999999999";
    }

    @Step("I send GET HTTP request for get product by non existence ID")
    public void sendGetProductByIdWithNonExistenceID(){
        SerenityRest.given().get(setGetProductByNonExistenceId());
    }


//    Scenario: GET - As a user i should be failed to get product by ID with invalid API endpoint
    @Step("I set invalid get product by ID API endpoint")
    public String setInvalidGetProductByIDEndpoint(){
        return url + "/products/85982salah";
    }

    @Step("I send GET HTTP request for invalid get product by ID")
    public void sendInvalidGetProductById(){
        SerenityRest.given().get(setInvalidGetProductByIDEndpoint());
    }

//    Scenario: GET - As a user i should be failed to get product by ID with the product ID is exceed
    @Step("I set get product by ID API endpoint with ID is exceeding the limit")
    public String setGetProductByIdExceed(){
        return  url + "/products/12345678901";
    }

    @Step("I send GET HTTP request for get product by ID is exceeding the limit")
    public void sendGetProductByExceedId(){
        SerenityRest.when().get(setGetProductByIdExceed());
    }


//    Scenario: DELETE - As a user i have be able to delete product with valid product ID
    @Step("I set delete product API endpoint")
    public String setDeleteProductEndpoint(){
        return  url + "/products/85533";
    }

    @Step("I send DELETE HTTP request for delete product with valid product ID")
    public void sendDeleteProductValidId(){
        SerenityRest.when().delete(setDeleteProductEndpoint());
    }

//    Scenario: DELETE - As a user i should be failed to delete product with the product ID is exceed
    @Step("I set delete product API endpoint with exceed ID")
    public String setDeleteProductWithExceedId(){
        return url + "/products/12345678901";
    }

    @Step("I send DELETE HTTP request for delete product with exceed ID")
    public void sendDeleteProductWithExceedId(){
        SerenityRest.when().delete(setDeleteProductWithExceedId());
    }


//    Scenario: POST - As a user i should be failed to delete product with invalid HTTP method
    @Step("I send POST HTTP request for delete product with valid product ID")
    public void sendPostToDeleteProductEndpoint(){
        SerenityRest.when().post(setDeleteProductEndpoint());
    }

//    Scenario: DELETE - As a user i should be failed to delete product with invalid API endpoint
    @Step("I set invalid delete product API endpoint")
    public String setWrongEndpointForDeleteProduct(){
        return url + "/products/85533salah";
    }

    @Step("I send DELETE HTTP request to invalid delete product endpoint")
    public void sendPostToInvalidDeleteProductEndpoint(){
        SerenityRest.when().delete(setWrongEndpointForDeleteProduct());
    }


//    Scenario: POST - As a user i have be able to asign product ratings with valid product ID and valid rating count
    @Step("I set asign product rating API endpoint")
    public String setAsignRatingEndpoint(){
//        need to check product available or not before run
        return url + "/products/85543/ratings";
    }

    @Step("I send POST HTTP request for asign product rating with valid request body")
    public void sendPostAsignRating(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("count", 4);

        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuZHJlYW4iLCJFbWFpbCI6ImRvaGM5MDkwQGdtYWlsLmNvbSJ9.zqsZ7AVEey4afO657sxkS8vr7Mik4xnpKUgmFZAoULE")
                .post(setAsignRatingEndpoint());
    }


//    Scenario: POST - As a user i should be failed to asign product ratings with invalid product ID and valid rating count
    @Step("I set asign product rating API endpoint with invalid ID")
    public String setAsignRatingWithInvalidProductID(){
        return url + "/products/999999999/ratings";
    }

    @Step("I send POST HTTP request for asign product rating with invalid ID")
    public void sendPostToAsignProductWithInvalidId(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("count", 3);

        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuZHJlYW4iLCJFbWFpbCI6ImRvaGM5MDkwQGdtYWlsLmNvbSJ9.zqsZ7AVEey4afO657sxkS8vr7Mik4xnpKUgmFZAoULE")
                .post(setAsignRatingWithInvalidProductID());
    }


//    Scenario: DELETE - As a user i should be failed to asign product ratings with invalid HTTP method
    @Step("I send DELETE HTTP request for asign product rating with valid request body")
    public void sendDeleteToAsignRatingEndpoint(){
        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuZHJlYW4iLCJFbWFpbCI6ImRvaGM5MDkwQGdtYWlsLmNvbSJ9.zqsZ7AVEey4afO657sxkS8vr7Mik4xnpKUgmFZAoULE")
                .delete(setAsignRatingEndpoint());
    }

//    Scenario: POST - As a user i should be failed to asign product ratings with invalid API endpoint
    @Step("I set invalid asign product rating API endpoint")
    public String setInvalidAsignRatingEndpoint(){
        return url + "/products/85533/ratingssalah";
    }

    @Step("I send POST HTTP request for asign product rating to invalid API endpoint")
    public void sendPostAsignRatingWithInvalidEndpoint(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("count", 3);

        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuZHJlYW4iLCJFbWFpbCI6ImRvaGM5MDkwQGdtYWlsLmNvbSJ9.zqsZ7AVEey4afO657sxkS8vr7Mik4xnpKUgmFZAoULE")
                .post(setInvalidAsignRatingEndpoint());
    }


//    Scenario: GET - As a user i have be able to get product ratings with valid product ID
    @Step("I set valid get product rating API endpoint with valid product ID")
    public String setGetRatingWithValidID(){
        return url + "/products/85533/ratings";
    }

    @Step("I send GET HTTP request for get product rating with valid product ID")
    public void sendGetProductRatingWithValidId(){
        SerenityRest.when().get(setGetRatingWithValidID());
    }

//    Scenario: GET - As a user i should be failed to get product ratings with invalid API endpoint
    @Step("I set invalid get product rating API endpoint")
    public String setInvalidGetProductRatingEndpoint(){
        return url + "/products/85533/ratingssalah";
    }

    @Step("I send GET HTTP request for get product rating with invalid endpoint")
    public void sendGetToInvalidEndpointOfProductRating(){
        SerenityRest.when().get(setInvalidGetProductRatingEndpoint());
    }


//    Scenario: POST - As a user i have be able to create comment with valid product ID
    @Step("I set create comment API endpoint")
    public String setCreateCommentEndpoint(){
        return url + "/products/85533/comments";
    }

    @Step("I send POST HTTP request for create comment with valid request body")
    public void sendPostCreateCommentValid(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("content", "Comment");

        SerenityRest.given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuZHJlYW4iLCJFbWFpbCI6ImRvaGM5MDkwQGdtYWlsLmNvbSJ9.zqsZ7AVEey4afO657sxkS8vr7Mik4xnpKUgmFZAoULE")
                .body(requestBody.toString())
                .post(setCreateCommentEndpoint());
    }

//    Scenario: POST - As a user i should be failed to create comment with valid product ID and the content is numeric

    @Step("I send POST HTTP request for create comment with invalid request body that content is numeric")
    public void sendPostCreateCommentWithContentIsNumeric(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("content", 12345);

        SerenityRest.given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuZHJlYW4iLCJFbWFpbCI6ImRvaGM5MDkwQGdtYWlsLmNvbSJ9.zqsZ7AVEey4afO657sxkS8vr7Mik4xnpKUgmFZAoULE")
                .body(requestBody.toString())
                .post(setCreateCommentEndpoint());
    }

//    Scenario: DELETE - As a user i should be failed to create comment with invalid http method
    @Step("I send DELETE HTTP request for create comment with valid request body")
    public void sendDeleteToCreateComment() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("content", "Comment");

        SerenityRest.given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuZHJlYW4iLCJFbWFpbCI6ImRvaGM5MDkwQGdtYWlsLmNvbSJ9.zqsZ7AVEey4afO657sxkS8vr7Mik4xnpKUgmFZAoULE")
                .body(requestBody.toString())
                .delete(setCreateCommentEndpoint());
    }


//    Scenario: POST - As a user i should be failed to create comment with invalid API endpoint
    @Step("I set invalid create comment API endpoint")
    public String setInvalidCreateCommentEndpoint(){
        return url + "/products/85533/commentssalah";
    }

    @Step("I send POST HTTP request for create comment with invalid API endpoint")
    public void sendPostCreateCommentToInvalidEndpoint(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("content", 12345);

        SerenityRest.given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuZHJlYW4iLCJFbWFpbCI6ImRvaGM5MDkwQGdtYWlsLmNvbSJ9.zqsZ7AVEey4afO657sxkS8vr7Mik4xnpKUgmFZAoULE")
                .body(requestBody.toString())
                .post(setInvalidCreateCommentEndpoint());
    }


//    Scenario: GET - As a user i have be able to get comment with valid product ID
    @Step("I set get comment API endpoint")
    public String setGetCommentEndpoint(){
        return url + "/products/2/comments";
    }

    @Step("I send GET HTTP request for get comment with valid product ID")
    public void sendGetCommentWithValidID(){
        SerenityRest.when().get(setGetCommentEndpoint());
    }


//    Scenario: GET - As a user i should be failed to get comment with invalid API endpoint
    @Step("I set invalid get comment API endpoint")
    public String setInvalidGetCommentEndpoint(){
        return url + "/products/2/commentssalah";
    }

    @Step("I send GET HTTP request for invalid get comment")
    public void sendGetCommentToInvalidEndpoint(){
        SerenityRest.when().get(setInvalidGetCommentEndpoint());
    }


//    Scenario: GET - As a user i should be failed to get comment with invalid product ID
    @Step("I set get comment API endpoint with invalid product ID")
    public String setGetCommentWithInvalidProductID() {
        return url + "/products/999999999/commentssalah";
    }

    @Step("I send GET HTTP request for get comment with invalid product ID")
    public void sendGetCommentWithInvalidProductID(){
        SerenityRest.when().get(setGetCommentWithInvalidProductID());
    }













}
