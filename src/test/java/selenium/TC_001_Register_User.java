package selenium;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TC_001_Register_User {
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
        String newUser = driver.findElement(By.xpath("//*[@id=\"form\"]//div[3]/div/h2")).getText();
        newUser.equals("New User Signup!");

        //Enter name and email address
        driver.findElement(By.xpath("//input[@data-qa=\"signup-name\"]")).sendKeys("testUser");
        driver.findElement(By.xpath("//input[@data-qa=\"signup-email\"]")).sendKeys("testUser@yopmail.com");

        //Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa=\"signup-button\"]")).click();

        //Verify that 'ENTER ACCOUNT INFORMATION' is visible
        String enterAccountInfo = "ENTER ACCOUNT INFORMATION";
        String enterAccountInfoSignUp = driver.findElement(By.xpath("//div/div[1]/h2/b")).getText();
        enterAccountInfo.equals(enterAccountInfoSignUp);

        //Fill details: Title, Name, Email (Non editable), Password, Date of birth

        //click on title Mr. or Mrs.
        driver.findElement(By.id("id_gender1")).click();
        //fill name field
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("testUser");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("1234");
        Select yearSelect = new Select(driver.findElement(By.name("years")));
        yearSelect.selectByVisibleText("1999"); //*[@id="years"]/option[4]

        Select monthSelect = new Select(driver.findElement(By.name("months")));
        monthSelect.selectByVisibleText("April");
        //*[@id="months"]/option[6]
        Select DaySelect = new Select(driver.findElement(By.name("days")));
        DaySelect.selectByVisibleText("10");
        //*[@id="days"]/option[4]

        //Select checkbox 'Sign up for our newsletter!' ***optional***
        //Select checkbox 'Receive special offers from our partners!'  ***optional***

        //Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

        driver.findElement(By.name("first_name")).sendKeys("test");
        driver.findElement(By.name("last_name")).sendKeys("User");
        driver.findElement(By.name("company")).sendKeys("NASA");
        driver.findElement(By.name("address1")).sendKeys("No. 31, Street road, NY");
        driver.findElement(By.xpath("//*[@id=\"country\"]/option[2]")).click(); //*[@id="country"]/option[2]
        driver.findElement(By.name("state")).sendKeys("NASA");
        driver.findElement(By.name("city")).sendKeys("Colombo");
        driver.findElement(By.name("zipcode")).sendKeys("12345");
        driver.findElement(By.name("mobile_number")).sendKeys("071456789");

        //Click 'Create Account button'
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//button[text()=\"Create Account\"]")).click();


        //Verify that 'ACCOUNT CREATED!' is visible
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b")).getText().equals("ACCOUNT CREATED!");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/p[1]")).getText()
              .equals("Congratulations! Your new account has been successfully created!");


        //Click 'Continue' button
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a")).click();

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
