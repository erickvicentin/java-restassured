package Steps;

import static io.restassured.RestAssured.given;

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

  @Given("I send a GET request to the endpoint")
  public void sendGETRequest() {

    request = given().baseUri("https://api.github.com").contentType(ContentType.JSON);
  }

  @Then("I get a {int} status code")
  public void expectedStatusCode(int expectedStatusCode) {

    response = request.when().get("/users/erickvicentin/repos");

    json = response.then().statusCode(expectedStatusCode);
  }
}
