package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TC_002_Login_User_Correct {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //start testing the register user test case.
        driver.get("https://automationexercise.com/");
        String homePageName = driver.findElement(By.xpath("//img[@alt='Website for automation practice']")).getAttribute("alt");
        assert homePageName.equals("Website for automation practice");

        //verify the text of the homepage. (inside the carousel)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement headingOfSite = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".item.active h1")));
        String AutomationExercise = headingOfSite.getText();
        assert AutomationExercise.equals("AutomationExercise");

        //click signup button
        driver.findElement(By.xpath("//a[@href='/login'][contains(text(), 'Signup / Login')]")).click();
        //verify existing user signup is visible
        String existingUser = driver.findElement(By.xpath("//h2[text()=\"Login to your account\"]")).getText();
        assert existingUser.equals("Login to your account");

        //Enter the correct email and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).
                sendKeys("testUser2@yopmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1234");

        //Click 'Login' button
        driver.findElement(By.xpath("//button[text()=\"Login\"]")).click();

        //Verify that 'Logged in as username' is visible
        assert driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")).
                getText().equals("Logged in as testUsertestUser");

        //Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

        //Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        assert driver.findElement(By.xpath("//b[text()=\"Account Deleted!\"]")).getText().equals("ACCOUNT DELETED!");
        driver.findElement(By.xpath("//a[@data-qa='continue-button'][contains(text(),Continue)]")).click();

        //driver.close();
        driver.quit();
    }
}
