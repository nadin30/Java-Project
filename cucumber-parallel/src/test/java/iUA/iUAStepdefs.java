package iUA;

import com.automationrhapsody.cucumber.parallel.tests.wikipedia.BaseSteps;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class iUAStepdefs extends BaseSteps {

    @Before
    public void before() {
        startWebDriver();
    }
//
//    protected WebDriver driver;
//
//    private void startWebDriver() {
//        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        driver.navigate().to("http://www.i.ua/");
//    }
//
    @After
    public void after() {
        stopWebDriver();
    }
//
//
        protected void stopWebDriver() {
            driver.quit();
        }


    @Given("^Enter login '(.*?)'$")
    public void enterLogin(String searchTerm) throws InterruptedException {
       // Thread.sleep(5000);
        WebElement loginField = driver.findElement(By.name("login"));
        loginField.sendKeys(searchTerm);
       // Thread.sleep(5000);

    }

    @And("^Enter passworg '(.*?)'$")
    public void enterPass(String pass) {
        WebElement passField = driver.findElement(By.name("pass"));
        passField.sendKeys(pass);
    }

    @When("^I click login button$")
    public void iClickLoginButton() {
        WebElement logButton = driver.findElement(By.cssSelector("div.content.clear > form > p > input[type=\"submit\"]"));
        logButton.click();
    }

    @Then("^i check that user name is '(.*?)'$")
    public void iCheckThatUserName(String UserNAme) throws InterruptedException {
       WebElement trueUserName = driver.findElement(By.className("sn_menu_title"));
        Thread.sleep(5000);
        assertEquals(UserNAme, trueUserName.getText());
    }


}
