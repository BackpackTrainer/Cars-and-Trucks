package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
    @Given("I send a get request to cars")
    public void iSendAGetRequestToCars() {
        System.out.println("Found the step definitions!");
    }

    @When("I parse the response")
    public void iParseTheResponse() {
    }

    @Then("I get a list of cars")
    public void iGetAListOfCars() {
    }
}
