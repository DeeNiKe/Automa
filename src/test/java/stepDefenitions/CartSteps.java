package stepDefenitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CartSteps {

    WebDriver driver = DriverManager.getDriver();

    @Given("open browser")
    public void openBrowser() {
        System.out.println("Browser is opened.");
    }

    @Given("user is on homepage")
    public void user_is_on_homepage() {
        driver.get("https://automationexercise.com/");
        String homePageName = driver.findElement(By.xpath("//img[@alt='Website for automation practice']")).getAttribute("alt");
        assert homePageName.equals("Website for automation practice");
    }

    @When("user click on cart button")
    public void userClickOnCartButton() {
        driver.findElement(By.xpath("//a[@href=\"/view_cart\"][contains(text(),'Cart')]")).click();
    }

    @And("user verify subscription text")
    public void userVerifySubscriptionText() {
        String cartPageSubscription = driver.findElement(By.xpath("//h2[text()='Subscription']")).getText();
        assert cartPageSubscription.equals("SUBSCRIPTION");
    }

    @When("user enter email address")
    public void userEnterEmailAddress() {
        driver.findElement(By.id("subscribe_email")).sendKeys("testUser2@yopmail.com");
    }

    @And("user click on arrow button")
    public void userClickOnArrowButton() {
        driver.findElement(By.xpath("//button[@id=\"subscribe\"]")).click();
    }

    @When("user close browser")
    public void userCloseBrowser() {
        driver.quit();
    }
}
