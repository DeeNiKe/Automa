package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_007_Search_Product {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //start testing the register user test case.
        driver.get("https://automationexercise.com/");
        String homePageName = driver.findElement(By.xpath("//*[@id=\"header\"]//img")).getText();
        homePageName.equals("Automation Exercise");

        //click on Products button
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")).click();
        //verify user navigate to all products page.
        String testCases = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/h2")).getText();
        testCases.equals("ALL PRODUCTS");
        //Enter product name in search input and click search button
        String searchText = "Men";
        driver.findElement(By.xpath("//*[@id=\"search_product\"]")).sendKeys(searchText);
        driver.findElement(By.xpath("//*[@id=\"submit_search\"]")).click();

        //verify "Searched Products"
        String actualSearchedProducts = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/h2")).getText();
        String expectedSearchedProducts = "SEARCHED PRODUCTS";
        actualSearchedProducts.equals(expectedSearchedProducts);

        //verify all products available.
        for(int i=2; i<6; i++){
            String text;
            text = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div["+i+"]/div/div[1]/div[1]/p")).getText();
            text.equals(searchText);
        }
        //driver.close();
        driver.quit();
    }
}
