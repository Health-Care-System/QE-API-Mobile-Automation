package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONArray;
import org.json.JSONObject;

public class Order {

    protected String url = "https://altashop-api.fly.dev/api";

//    Scenario: POST - As a user i have be able to create order with valid product ID and quantity
    @Step("I set create order API endpoint")
    public String setCreateOrderEndpoint(){
        return url + "/orders";
    }

    @Step("I send POST HTTP request for create order with valid product_id and quantity")
    public void sendPostToValidCreateOrder(){
        JSONArray orderItems = new JSONArray();
        JSONObject orderItem = new JSONObject();
        orderItem.put("product_id", 85538);
        orderItem.put("quantity", 1);
        orderItems.put(orderItem);

        JSONArray requestBody = new JSONArray();
        JSONObject orderCreate = new JSONObject();
        orderCreate.put("order_items", orderItems);
        requestBody.put(orderCreate);

        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuZHJlYW4iLCJFbWFpbCI6ImRvaGM5MDkwQGdtYWlsLmNvbSJ9.zqsZ7AVEey4afO657sxkS8vr7Mik4xnpKUgmFZAoULE")
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setCreateOrderEndpoint());
    }


//    Scenario: POST - As a user should be failed to create order with invalid product ID and valid quantity
    @Step("I send POST HTTP request for create order with invalid product_id and valid quantity")
    public void sendPostCreateOrderWithInvalidProductID(){
        JSONArray orderItems = new JSONArray();
        JSONObject orderItem = new JSONObject();
        orderItem.put("product_id", 999999999);
        orderItem.put("quantity", 1);
        orderItems.put(orderItem);

        JSONArray requestBody = new JSONArray();
        JSONObject orderCreate = new JSONObject();
        orderCreate.put("order_items", orderItems);
        requestBody.put(orderCreate);

        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuZHJlYW4iLCJFbWFpbCI6ImRvaGM5MDkwQGdtYWlsLmNvbSJ9.zqsZ7AVEey4afO657sxkS8vr7Mik4xnpKUgmFZAoULE")
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setCreateOrderEndpoint());
    }

//    Scenario: POST - As a user should be failed to create order with valid product ID and invalid quantity
    @Step("I send POST HTTP request for create order with valid product_id and invalid quantity")
    public void sendPostCreateOrderWithInvalidQuantity(){
        JSONArray orderItems = new JSONArray();
        JSONObject orderItem = new JSONObject();
        orderItem.put("product_id", 85538);
        orderItem.put("quantity", -1);
        orderItems.put(orderItem);

        JSONArray requestBody = new JSONArray();
        JSONObject orderCreate = new JSONObject();
        orderCreate.put("order_items", orderItems);
        requestBody.put(orderCreate);

        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuZHJlYW4iLCJFbWFpbCI6ImRvaGM5MDkwQGdtYWlsLmNvbSJ9.zqsZ7AVEey4afO657sxkS8vr7Mik4xnpKUgmFZAoULE")
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setCreateOrderEndpoint());
    }

//    Scenario: POST - As a user should be failed to create order with empty product ID and valid quantity
    @Step("I send POST HTTP request for create order with empty product_id and valid quantity")
    public void sendPostCreateOrderWithEmptyProductID(){
        JSONArray orderItems = new JSONArray();
        JSONObject orderItem = new JSONObject();
        orderItem.put("quantity", -1);
        orderItems.put(orderItem);

        JSONArray requestBody = new JSONArray();
        JSONObject orderCreate = new JSONObject();
        orderCreate.put("order_items", orderItems);
        requestBody.put(orderCreate);

        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuZHJlYW4iLCJFbWFpbCI6ImRvaGM5MDkwQGdtYWlsLmNvbSJ9.zqsZ7AVEey4afO657sxkS8vr7Mik4xnpKUgmFZAoULE")
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setCreateOrderEndpoint());
    }

//    Scenario: POST - As a user should be failed to create order with valid product ID and empty quantity
    @Step("I send POST HTTP request for create order with valid product_id and empty quantity")
    public void sendPostCreateOrderWithEmptyQuantity(){
        JSONArray orderItems = new JSONArray();
        JSONObject orderItem = new JSONObject();
        orderItem.put("product_id", 85538);
        orderItems.put(orderItem);

        JSONArray requestBody = new JSONArray();
        JSONObject orderCreate = new JSONObject();
        orderCreate.put("order_items", orderItems);
        requestBody.put(orderCreate);

        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuZHJlYW4iLCJFbWFpbCI6ImRvaGM5MDkwQGdtYWlsLmNvbSJ9.zqsZ7AVEey4afO657sxkS8vr7Mik4xnpKUgmFZAoULE")
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setCreateOrderEndpoint());
    }

//    Scenario: DELETE - As a user should be failed to create order with invalid HTTP method
    @Step("I send DELETE HTTP request for create order with valid product_id and valid quantity")
    public void sendDeleteToCreateOrderEndpoint(){
        SerenityRest.given().delete(setCreateOrderEndpoint());
    }

//    Scenario: POST - As a user should be failed to create order with invalid API endpoint
    @Step("I set invalid create order API endpoint")
    public String setInvalidEndpointOfCreateOrder(){
        return url + "/orderssalah";
    }

    @Step("I send POST HTTP request for create order with valid product_id and valid quantity")
    public void sendPostCreateOrderWithInvalidEndpoint(){
        JSONArray orderItems = new JSONArray();
        JSONObject orderItem = new JSONObject();
        orderItem.put("product_id", 85538);
        orderItem.put("quantity", 1);
        orderItems.put(orderItem);

        JSONArray requestBody = new JSONArray();
        JSONObject orderCreate = new JSONObject();
        orderCreate.put("order_items", orderItems);
        requestBody.put(orderCreate);

        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuZHJlYW4iLCJFbWFpbCI6ImRvaGM5MDkwQGdtYWlsLmNvbSJ9.zqsZ7AVEey4afO657sxkS8vr7Mik4xnpKUgmFZAoULE")
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setInvalidEndpointOfCreateOrder());
    }


//    Scenario: GET - As a user i have be able to get all orders
    @Step("I set get all orders API endpoint")
    public String setGetAllOrdersEndpoint(){
        return url + "/orders";
    }

    @Step("I send GET HTTP request for get all orders")
    public void sendGetAllOrders(){
        SerenityRest.when().get(setGetAllOrdersEndpoint());
    }

//    Scenario: GET - As a user i should be failed to get order with invalid API endpoint
    @Step("I set invalid get all orders API endpoint")
    public String setInvalidGetALlOrder(){
        return url + "/orderssalah";
    }

    @Step("I send GET HTTP request for invalid get all orders")
    public void sendGetInvalidGetAllEndpoint(){
        SerenityRest.when().get(setInvalidGetALlOrder());
    }


//    Scenario: POST - As a user i should be failed to get all order with invalid HTTP method
    @Step("I send POST HTTP request for get all orders")
    public void sendPostToGetAllOrders(){
        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuZHJlYW4iLCJFbWFpbCI6ImRvaGM5MDkwQGdtYWlsLmNvbSJ9.zqsZ7AVEey4afO657sxkS8vr7Mik4xnpKUgmFZAoULE")
                .post(setGetAllOrdersEndpoint());
    }

//    Scenario: GET - As a user i have be able to get order by ID
    @Step("I set get orders by ID API endpoint")
    public String setGetOrderByIdEndpoint(){
        return url + "/orders/12670";
    }

    @Step("I send GET HTTP request for get orders by ID")
    public void sendGetOrderByID(){
        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuZHJlYW4iLCJFbWFpbCI6ImRvaGM5MDkwQGdtYWlsLmNvbSJ9.zqsZ7AVEey4afO657sxkS8vr7Mik4xnpKUgmFZAoULE")
                .get(setGetOrderByIdEndpoint());
    }

//    Scenario: GET - As a user i should be failed to get order by ID with invalid ID
    @Step("I set get orders by ID API endpoint with invalid ID")
    public String setGetOrdersWithInvalidID(){
        return url + "/orders/99999999";
    }

    @Step("I send GET HTTP request for get orders by ID with invalid ID")
    public void sendGetOrderByInvalidID(){
        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuZHJlYW4iLCJFbWFpbCI6ImRvaGM5MDkwQGdtYWlsLmNvbSJ9.zqsZ7AVEey4afO657sxkS8vr7Mik4xnpKUgmFZAoULE")
                .get(setGetOrdersWithInvalidID());
    }


//    Scenario: GET - As a user i should be failed to get order by ID with the ID is exceed
    @Step("I set get orders by ID API endpoint with ID exceeding the limit")
    public String setEndpointForGetOrderWithExceedID(){
        return url + "orders/12345678901";
    }

    @Step("I send GET HTTP request for get orders by ID with ID exceeding the limit")
    public void sendGetOrderWithIdIsExceedLimit(){
        SerenityRest.when().get(setEndpointForGetOrderWithExceedID());
    }


//    Scenario: DELETE - As a user i should be failed to get order by ID with invalid HTTP method
    @Step("I send DELETE HTTP request for get orders by ID")
    public void sendDeleteToGetOrderByIDEndpoint(){
        SerenityRest.when().delete(setGetOrderByIdEndpoint());
    }











}
