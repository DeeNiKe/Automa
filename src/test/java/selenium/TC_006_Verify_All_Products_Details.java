package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_006_Verify_All_Products_Details {
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
        //verifying product list is visible.
        WebElement listItemOne = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div"));
        boolean isListItemOneVisible = listItemOne.isDisplayed();
        System.out.println("List Item One is displayed : "+isListItemOneVisible);

        WebElement listItemTwo = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div"));
        boolean isListItemTwoVisible = listItemTwo.isDisplayed();
        System.out.println("List Item Two is displayed : "+isListItemTwoVisible);

        //Click on 'View Product' of first product
        driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a")).click();

        //User is landed to product detail page
        String currentUrl = "https://automationexercise.com/product_details/1";
        driver.getCurrentUrl().equals(currentUrl);

        //Verify that detail detail is visible: product name, category, price, availability, condition, brand
        boolean productNameVisibility, categoryVisibility, priceVisibility, availability, conditionVisibility, brandVisibility;

        WebElement pName = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2"));
        productNameVisibility = pName.isDisplayed();
        System.out.println("Product name is displayed : "+productNameVisibility+ "✔\uFE0F");

        WebElement category = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]"));
        categoryVisibility = category.isDisplayed();
        System.out.println("Product category is displayed : "+categoryVisibility+ "✔\uFE0F");

        WebElement price = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span"));
        priceVisibility = price.isDisplayed();
        System.out.println("Product price is displayed : "+priceVisibility+ "✔\uFE0F");

        WebElement available = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]"));
        availability = available.isDisplayed();
        System.out.println("Product available is displayed : "+availability+ "✔\uFE0F");

        WebElement condition = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]"));
        conditionVisibility = condition.isDisplayed();
        System.out.println("Product condition is displayed : "+conditionVisibility + "✔\uFE0F");

        WebElement brand = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]"));
        brandVisibility = brand.isDisplayed();
        System.out.println("Product brand is displayed : "+brandVisibility + "✔\uFE0F");

        //driver.close();
        driver.quit();
    }
}
