package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_010_Verify_Subscription_HomePage {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //start testing the register user test case.
        driver.get("https://automationexercise.com/");
        String homePageName = driver.findElement(By.xpath("//*[@id=\"header\"]//img")).getText();
        homePageName.equals("Automation Exercise");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scroll down till the bottom of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        //Verify text 'SUBSCRIPTION'
        String actualText = driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2")).getText();
        String subscriptionText = "SUBSCRIPTION";
        actualText.equals(subscriptionText);

        //entering Enter name, email, subject and message
        driver.findElement(By.id("susbscribe_email")).sendKeys("testUser2@yopmail.com");
        driver.findElement(By.xpath("//*[@id=\"subscribe\"]")).click();

        //verify subscription
        driver.findElement(By.xpath("//*[@id=\"success-subscribe\"]")).getText().
                equals("You have been successfully subscribed!");

        //driver.close();
        driver.quit();
    }
}
