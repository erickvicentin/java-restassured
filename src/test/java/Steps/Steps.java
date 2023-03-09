package Steps;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Steps {

  private static RequestSpecification request;
  private static Response response;
  private static ValidatableResponse json;

  @Given("I send a GET request to the {string} URI")
  public void sendGETRequest(String uri) {
    request = given().baseUri(uri).contentType(ContentType.JSON);
  }

  @Then("I get a {int} status code")
  public void expectedStatusCode(int expectedStatusCode) {
    response = request.when().get("/users/erickvicentin/repos");
    json = response.then().statusCode(expectedStatusCode);
  }

  @Then("I validate there are {int} items on the {string} enpoint")
  public void expectedItems(int items, String path){
    response = request.when().get(path);
    
    List<String> jsonResponse = response.jsonPath().getList("$");
    int actualSize = jsonResponse.size();
    assertEquals(items, actualSize);
  }

  
  @Then("I validate there is a value: {string} in the response at {string} endpoint")
  public void validateValue(String expectedName, String path){
    response = request.when().get(path);
    
    List<String> jsonResponse = response.jsonPath().getList("username");
    assertTrue("No se encontro el valor "+expectedName, jsonResponse.contains(expectedName));
  }

  @Then("I can validate the nested: {string} on the response at {string} endpoint")
  public void validateNestedValue(String expectedStreet, String path){
    response = request.when().get(path);
    
    String jsonResponse = response.jsonPath().getString("address.street");
    
    assertTrue("La calle "+expectedStreet+" no pertenecee a ningun usuario.", jsonResponse.contains(expectedStreet));
  }
}
