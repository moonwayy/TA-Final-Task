package stepDefinitions;

import constants.Username;
import drivers.DriverSingleton;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.LoginPage;

public class LoginPageSteps {
    private final LoginPage loginPage = new LoginPage(DriverSingleton.getDriver());

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage.openPage();
    }

    @When("I enter {string} in the username field")
    public void iEnterUsername(String username) {
        loginPage.enterUsername(username);
    }

    @When("I enter a valid username in the username field")
    public void iEnterAValidUsernameInTheUsernameField() {
        loginPage.enterValidUsername();
    }

    @When("I enter {string} in the password field")
    public void iEnterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("I clear the username and password fields")
    public void iClearInputs() {
        loginPage.clearInputs();
    }

    @When("I clear the password field")
    public void iClearPasswordField() {
        loginPage.clearPasswordField();
    }

    @When("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLogin();
    }

    @Then("I should see an error message {string}")
    public void iSeeAnErrormessage(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessage();
        Assertions.assertThat(actualMessage).contains(expectedMessage);
    }
}
