package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_008_Logout_User {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //start testing the register user test case.
        driver.get("https://automationexercise.com/");
        String homePageName = driver.findElement(By.xpath("//*[@id=\"header\"]//img")).getText();
        homePageName.equals("Automation Exercise");

        //click signup button
        driver.findElement(By.xpath("//*[@id=\"header\"]//ul/li[4]/a")).click();
        //verify Login to your account
        String existingUser = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2")).getText();
        existingUser.equals("Login to your account");

        //Enter correct email address and password
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).sendKeys("testUser@yopmail.com");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys("1234");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).click();

        //Verify that 'Logged in as username' is visible
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")).
                getText().equals("Logged in as testUsertestUser");

        //Verify that user is navigated to login page
        //NOTE: not navigating to the login page SERVER ERROR KeyError at /logout
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();

        /*      not navigating to the login page */


        //driver.close();
        driver.quit();
    }
}
