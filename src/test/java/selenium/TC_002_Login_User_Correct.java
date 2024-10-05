package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TC_002_Login_User_Correct {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //start testing the register user test case.
        driver.get("https://automationexercise.com/");
        String homePageName = driver.findElement(By.xpath("//*[@id=\"header\"]//img")).getText();
        homePageName.equals("Automation Exercise");

        //click signup button
        driver.findElement(By.xpath("//*[@id=\"header\"]//ul/li[4]/a")).click();
        //verify new user signup is visible
        String existingUser = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2")).getText();
        existingUser.equals("Login to your account");

        //Enter the correct email and password
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).
                sendKeys("testUser@yopmail.com");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).
                sendKeys("1234");

        //Click 'Login' button
        driver.findElement(By.xpath("//button[@data-qa=\"login-button\"]")).click();

        //Verify that 'Logged in as username' is visible
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")).
                getText().equals("Logged in as testUsertestUser");

        //Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")).click();

        //Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b")).getText().equals("ACCOUNT DELETED!");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a")).click();

        //driver.close();
        driver.quit();
    }
}
