package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_009_User_Registration_Existing_Email {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //start testing the register user test case.
        driver.get("https://automationexercise.com/");
        String homePageName = driver.findElement(By.xpath("//*[@id=\"header\"]//img")).getText();
        homePageName.equals("Automation Exercise");

        //click signup button
        driver.findElement(By.xpath("//*[@id=\"header\"]//ul/li[4]/a")).click();
        //verify new user signup is visible
        String newUser = driver.findElement(By.xpath("//*[@id=\"form\"]//div[3]/div/h2")).getText();
        newUser.equals("New User Signup!");

        //Enter name and email address
        driver.findElement(By.xpath("//input[@data-qa=\"signup-name\"]")).sendKeys("testUser2");
        driver.findElement(By.xpath("//input[@data-qa=\"signup-email\"]")).sendKeys("testUser2@yopmail.com");

        //Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa=\"signup-button\"]")).click();
        //verify error message
        String errorMessage = "Email Address already exist!";
        String userAlreadyExistingErrorMessage = driver.findElement(By.xpath("//p[@style='color: red;']")).getText();
        errorMessage.equals(userAlreadyExistingErrorMessage);

        //driver.close();
        driver.quit();
    }
}
