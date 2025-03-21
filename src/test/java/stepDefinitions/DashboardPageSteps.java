package stepDefinitions;

import drivers.DriverSingleton;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import pages.DashboardPage;

public class DashboardPageSteps {
    private final DashboardPage dashboardPage = new DashboardPage(DriverSingleton.getDriver());

    @Then("I should be redirected to the dashboard")
    public void iShouldBeRedirectedToTheDashboard() {
        Assertions.assertThat(dashboardPage.openPage());
    }

    @Then("the page title should be {string}")
    public void thePageTitleShouldBe(String expectedTitle) {
        Assertions.assertThat(dashboardPage.isTitlePresent()).isEqualTo(expectedTitle);
    }
}
