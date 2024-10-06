package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TC_004_Contact_Us_Form {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //start testing the register user test case.
        driver.get("https://automationexercise.com/");
        String homePageName = driver.findElement(By.xpath("//*[@id=\"header\"]//img")).getText();
        homePageName.equals("Automation Exercise");

        //click Contact Us button
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a")).click();
        //verify new user signup is visible
        String getInTouch = driver.findElement(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2")).getText();
        getInTouch.equals("GET IN TOUCH");

        //entering Enter name, email, subject and message
        driver.findElement(By.xpath("//input[@data-qa='name']")).sendKeys("Test User");
        driver.findElement(By.xpath("//input[@data-qa='email']")).sendKeys("testUser@yopmail.com");
        driver.findElement(By.xpath("//input[@data-qa='subject']")).sendKeys("Testing!");
        driver.findElement(By.xpath("//*[@id=\"message\"]")).sendKeys("testUser@yopmail.com");

        //file upload
        WebElement uploadElement = driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[5]/input"));
        uploadElement.sendKeys("D:\\Tutorials\\Selenium\\Projects\\Automa Exercise Project\\Automa Exercise Project\\usefull\\files\\sample.pdf");
        driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[6]/input")).click();

        //click on ok button google popup
        driver.switchTo().alert().accept();

        //verify success message "Success! Your details have been submitted successfully."
        driver.findElement(By.xpath("//div[@class=\"status alert alert-success\"]")).getText().equals("Success! Your details have been submitted successfully.");

        //click on home button
        driver.findElement(By.xpath("//a[@class=\"btn btn-success\"]")).click();
        homePageName.equals("Automation Exercise");

        //driver.close();
        driver.quit();
    }
}
