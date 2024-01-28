package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

//        WebDriverManager.chromedriver().driverVersion("121.0.6167.86").setup();
//        driver = new ChromeDriver();

        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver = new ChromeDriver();

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-extensions"); // Disabling extensions
//        options.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems
//        options.setExperimentalOption("useAutomationExtension", false);
//        options.addArguments("--no-sandbox"); // Bypass OS security model
//
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver(options);

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
