package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_003_Login_User_Incorrect {
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

        //entering incorrect email and password.
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).
                sendKeys("notanexistinguser@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).
                sendKeys("incorrect");

        //Click 'Login' button
        driver.findElement(By.xpath("//button[@data-qa=\"login-button\"]")).click();

        //Verify error message.
        String passwordError = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p")).getText();
        passwordError.equals("Your email or password is incorrect!");

        //driver.close();
        driver.quit();
    }
}
