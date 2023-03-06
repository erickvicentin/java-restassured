package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Steps {
    @Given("I send a GET request to the endpoint")
    public void sendGetRequest(){
        System.out.println("Sending GET request...");
    }

    @Then("I get a list with  10 users")
    public void getUserList(){
        System.out.println("Getting user list...");
    }
}
