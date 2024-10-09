package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_005_Verify_Test_Cases {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //start testing the register user test case.
        driver.get("https://automationexercise.com/");
        String homePageName = driver.findElement(By.xpath("//*[@id=\"header\"]//img")).getText();
        homePageName.equals("Automation Exercise");

        //click on Test Cases.
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")).click();
        //verify Test cases page.
        String testCases = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[1]/div/h2/b")).getText();
        testCases.equals("TEST CASES");
        //verifying the test case 1 is available.
        String testCase1 = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[2]/div/div[1]/h4/a/u")).getText();
        testCase1.equals("Test Case 1: Register User");

        //driver.close();
        driver.quit();
    }
}
