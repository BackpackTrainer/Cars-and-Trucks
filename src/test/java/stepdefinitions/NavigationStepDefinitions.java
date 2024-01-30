package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NavigationStepDefinitions {

    WebDriver driver;

    @Before
    public void setUp()  {
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();

        WebDriverManager.chromedriver().driverVersion("121.0.6167.140").setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @After
    public void teardown()  {
    driver.quit();
    }

    @Given("I have a browser open")
    public void iHaveABrowserOpen() {

    }

    @When("I navigate to {string}")
    public void iNavigateTo(String url) {
        driver.get(url);
    }

    @Then("I see the {string} page")
    public void iSeeThePage(String pageTitle) {
        String tabTitle = driver.getTitle();
        assertTrue(tabTitle.contains(pageTitle));
    }
}
