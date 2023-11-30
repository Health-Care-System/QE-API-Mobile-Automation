package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Product;

public class ProductSteps {

    @Steps
    Product product;

    @Given("I set create product API endpoint")
    public void setValidCreateProduct(){
        product.setCreateProductEndpoint();
    }

    @When("I send POST HTTP request for create product with valid request body")
    public void successSendValidPostCreateProduct(){
        product.sendPostCreateProductValid();
    }

    @When("I send POST HTTP request for create product with invalid request body that empty name")
    public void successSendPostCreateProductEmptyName(){
        product.sendPostCreateProductWithEmptyName();
    }

    @When("I send POST HTTP request for create product with invalid request body that name is numeric")
    public void successSendPostCreateProductWithNumericName(){
        product.sendPostCreateProductWithNumericName();
    }

    @When("I send POST HTTP request for create product with invalid request body that price is alphabetical")
    public void successSendPostCreateProductWithAlphabeticalPrice(){
        product.sendPostCreateProductWithAlphabeticalPrice();
    }

    @When("I send POST HTTP request for create product with invalid request body that categories is alphabetical")
    public void successSendPostCreateProductWithAlphabeticalCategories(){
        product.sendPostCreateProductWithAlphabeticalCaegories();
    }

    @When("I send POST HTTP request for create product with multiple categories")
    public void successSendPostCreateProductWithMultipleCategories(){
        product.sendPostCreateProductWithMultipleCategories();
    }

    @When("I send DELETE HTTP request for create product with valid request body")
    public void successSendDeleteToCreateProductEndpoint(){
        product.sendDeleteToCreateProductEndpoint();
    }

    @Given("I set get all products API endpoint")
    public void setValidGetAllProductsEndpoint(){
        product.setGetAllProductEndpoint();
    }

    @When("I send GET HTTP request for get all products")
    public void successSendGetAllProducts(){
        product.sendGetAllProductValid();
    }

    @When("I send POST HTTP request for get all products")
    public void successSendPostToGetAllProducts(){
        product.sendPostToGetAllProductsEndpoint();
    }

    @Given("I set invalid get all products API endpoint")
    public void setInvalidEndpointOfGetAllProduct(){
        product.setInvalidGetAllProductsEndpoint();
    }

    @When("I send GET HTTP request for invalid get all products API endpoint")
    public void successSendGetToInvalidGetALlProducts(){
        product.sendGetToInvalidGetAllProductsEndpoint();
    }

    @Given("I set get product by ID API endpoint")
    public void setValidGetProductByID(){
        product.setGetProductByIdEndpoint();
    }

    @When("I send GET HTTP request for get product by ID")
    public void successSendGetProductByID(){
        product.sendGetProductById();
    }

    @When("I send POST HTTP request for get product by ID")
    public void successSendPostToGetProductByIdEndpoint(){
        product.sendPostToGetProductByIdEndpoint();
    }

    @Given("I set get product by ID API endpoint with non existence ID")
    public void setInvalidGetProductByNonExistenceID(){
        product.setGetProductByNonExistenceId();
    }

    @When("I send GET HTTP request for get product by non existence ID")
    public void successSendGetProductByNonExistenceID(){
        product.sendGetProductByIdWithNonExistenceID();
    }

    @Given("I set invalid get product by ID API endpoint")
    public void setInvalidGetProductByIDEndpoint(){
        product.setInvalidGetProductByIDEndpoint();
    }

    @When("I send GET HTTP request for invalid get product by ID")
    public void successSendGetToInvalidGetProductByIdEndpoint(){
        product.sendInvalidGetProductById();
    }

    @Given("I set get product by ID API endpoint with ID is exceeding the limit")
    public void setValidGetProductWithExceedId(){
        product.setGetProductByIdExceed();
    }

    @When("I send GET HTTP request for get product by ID is exceeding the limit")
    public void successSendGetProductByExceedId(){
        product.sendGetProductByExceedId();
    }

    @Given("I set delete product API endpoint")
    public void setValidDeleteProductEndpoint(){
        product.setDeleteProductEndpoint();
    }

    @When("I send DELETE HTTP request for delete product with valid product ID")
    public void successSendValidDeleteProduct(){
        product.sendDeleteProductValidId();
    }


    @Given("I set delete product API endpoint with exceed ID")
    public void setInvalidDeleteProductWithExceedId(){
        product.setDeleteProductWithExceedId();
    }

    @When("I send DELETE HTTP request for delete product with exceed ID")
    public void successSendDeleteProductWithExceedId(){
        product.sendDeleteProductWithExceedId();
    }

    @When("I send POST HTTP request for delete product with valid product ID")
    public void successSendPostToDeleteProductEndpoint(){
        product.sendPostToDeleteProductEndpoint();
    }


    @Given("I set invalid delete product API endpoint")
    public void setInvalidDeleteProductEndpoint(){
        product.setWrongEndpointForDeleteProduct();
    }

    @When("I send DELETE HTTP request to invalid delete product endpoint")
    public void successSendDeleteToInvalidDeleteProductEndpoint(){
        product.sendPostToInvalidDeleteProductEndpoint();
    }

    @Given("I set asign product rating API endpoint")
    public void setValidAsignRatingEndpoint(){
        product.setAsignRatingEndpoint();
    }

    @When("I send POST HTTP request for asign product rating with valid request body")
    public void successSendValidPostAsignRating(){
        product.sendPostAsignRating();
    }

    @Given("I set asign product rating API endpoint with invalid ID")
    public void setInvalidAsignProductWithInvalidId(){
        product.setAsignRatingWithInvalidProductID();
    }

    @When("I send POST HTTP request for asign product rating with invalid ID")
    public void successSendPostAsignRatingWithInvalidId(){
        product.sendPostToAsignProductWithInvalidId();
    }

    @When("I send DELETE HTTP request for asign product rating with valid request body")
    public void successSendDeleteToAsignRatingEndpoint(){
        product.sendDeleteToAsignRatingEndpoint();
    }

    @Given("I set invalid asign product rating API endpoint")
    public void setInvalidEndpointForAsignRating(){
        product.setInvalidAsignRatingEndpoint();
    }

    @When("I send POST HTTP request for asign product rating to invalid API endpoint")
    public void successSendPostToInvalidEndpointAsignRating(){
        product.sendPostAsignRatingWithInvalidEndpoint();
    }

    @Given("I set valid get product rating API endpoint with valid product ID")
    public void setValidGetProductRatingEndpoint(){
        product.setGetRatingWithValidID();
    }

    @When("I send GET HTTP request for get product rating with valid product ID")
    public void successSendGetProductRatingWithValidProductId(){
        product.sendGetProductRatingWithValidId();
    }

    @Given("I set invalid get product rating API endpoint")
    public void setInvalidEndpointOfGetProductRating(){
        product.setInvalidGetProductRatingEndpoint();
    }

    @When("I send GET HTTP request for get product rating with invalid endpoint")
    public void successSendGetProductRatingWithInvalidEndpoint(){
        product.sendGetToInvalidEndpointOfProductRating();
    }

    @Given("I set create comment API endpoint")
    public void setValidCreateComment(){
        product.setCreateCommentEndpoint();
    }

    @When("I send POST HTTP request for create comment with valid request body")
    public void successSendPostCreateCommentValid(){
        product.sendPostCreateCommentValid();
    }

    @When("I send POST HTTP request for create comment with invalid request body that content is numeric")
    public void successSendPostCreateCommentWithContentIsNumeric(){
        product.sendPostCreateCommentWithContentIsNumeric();
    }

    @When("I send DELETE HTTP request for create comment with valid request body")
    public void successSendDeleteToCreateCommentEndpoint(){
        product.sendDeleteToCreateComment();
    }

    @Given("I set invalid create comment API endpoint")
    public void setInvalidEndpointOfCreateComment(){
        product.setInvalidCreateCommentEndpoint();
    }

    @When("I send POST HTTP request for create comment with invalid API endpoint")
    public void successSendPostCreateCommentToInvalidEndpoint(){
        product.sendPostCreateCommentToInvalidEndpoint();
    }

    @Given("I set get comment API endpoint")
    public void setValidGetCommentEndpoint(){
        product.setGetCommentEndpoint();
    }

    @When("I send GET HTTP request for get comment with valid product ID")
    public void successSendGetCommentWithValidProductID(){
        product.sendGetCommentWithValidID();
    }

    @Given("I set invalid get comment API endpoint")
    public void setInvalidEndpointOfGetComment(){
        product.setInvalidGetCommentEndpoint();
    }

    @When("I send GET HTTP request for invalid get comment")
    public void successSendGetCommentToInvalidEndpoint(){
        product.sendGetCommentToInvalidEndpoint();
    }


    @Given("I set get comment API endpoint with invalid product ID")
    public void setInvalidProductIdForGetComment(){
        product.setGetCommentWithInvalidProductID();
    }

    @When("I send GET HTTP request for get comment with invalid product ID")
    public void successSendGetCommentWithInvalidID(){
        product.sendGetCommentWithInvalidProductID();
    }



}
