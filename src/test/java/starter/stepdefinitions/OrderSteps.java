package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Order;

public class OrderSteps {

    @Steps
    Order order;

    @Given("I set create order API endpoint")
    public void setValidCreateOrderEndpoint(){
        order.setCreateOrderEndpoint();
    }

    @When("I send POST HTTP request for create order with valid product_id and quantity")
    public void successSendPostCreateOrder(){
        order.sendPostToValidCreateOrder();
    }

    @When("I send POST HTTP request for create order with invalid product_id and valid quantity")
    public void successSendPostCreateOrderWithInvalidProductID(){
        order.sendPostCreateOrderWithInvalidProductID();
    }

    @When("I send POST HTTP request for create order with valid product_id and invalid quantity")
    public void successSendPostCreateOrderWithInvalidQuantity(){
        order.sendPostCreateOrderWithInvalidQuantity();
    }

    @When("I send POST HTTP request for create order with empty product_id and valid quantity")
    public void successSendPostCreateOrderWithEmptyProductID(){
        order.sendPostCreateOrderWithEmptyProductID();
    }

    @When("I send POST HTTP request for create order with valid product_id and empty quantity")
    public void successSendPostCreateOrderWithEmptyQuantity(){
        order.sendPostCreateOrderWithEmptyQuantity();
    }

    @When("I send DELETE HTTP request for create order with valid product_id and valid quantity")
    public void successSendDeleteToCreateOrderEndpoint(){
        order.sendDeleteToCreateOrderEndpoint();
    }

    @Given("I set invalid create order API endpoint")
    public void placeInvalidEndpointForCreateOrder(){
        order.setInvalidEndpointOfCreateOrder();
    }

    @When("I send POST HTTP request for create order with valid product_id and valid quantity")
    public void successSendPostForInvalidCreateOrderEndpoint(){
        order.sendPostCreateOrderWithInvalidEndpoint();
    }


    @Given("I set get all orders API endpoint")
    public void setValidGetAllEndpoint(){
        order.setGetAllOrdersEndpoint();
    }

    @When("I send GET HTTP request for get all orders")
    public void successSendGetAllOrders(){
        order.sendGetAllOrders();
    }

    @Given("I set invalid get all orders API endpoint")
    public void setInvalidEndpointOfGetAllOrders(){
        order.setInvalidGetALlOrder();
    }

    @When("I send GET HTTP request for invalid get all orders")
    public void successSendGetInvalidGetAllOrders(){
        order.sendGetInvalidGetAllEndpoint();
    }

    @When("I send POST HTTP request for get all orders")
    public void successSendPostToGetAllOrders(){
        order.sendPostToGetAllOrders();
    }


    @Given("I set get orders by ID API endpoint")
    public void setValidOrderByIdEndpoint(){
        order.setGetOrderByIdEndpoint();
    }

    @When("I send GET HTTP request for get orders by ID")
    public void successSendGetOrderByID(){
        order.sendGetOrderByID();
    }


    @Given("I set get orders by ID API endpoint with invalid ID")
    public void setInvalidEndpointOfGetOrdersInvalidID(){
        order.setGetOrdersWithInvalidID();
    }

    @When("I send GET HTTP request for get orders by ID with invalid ID")
    public void successSendGetOrdersWithInvalidID(){
        order.sendGetOrderByInvalidID();
    }


    @Given("I set get orders by ID API endpoint with ID exceeding the limit")
    public void setValidGetOrdersByExceedID(){
        order.setEndpointForGetOrderWithExceedID();
    }

    @When("I send GET HTTP request for get orders by ID with ID exceeding the limit")
    public void successSendGetOrdersWithExceedID(){
        order.sendGetOrderWithIdIsExceedLimit();
    }

    @When("I send DELETE HTTP request for get orders by ID")
    public void successSendDeleteToGetOrderByID(){
        order.sendDeleteToGetOrderByIDEndpoint();
    }

















}
