package stepDefenitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsSteps {

    WebDriver driver = DriverManager.getDriver();
    Actions actions = new Actions(driver);

    @When("user click on Products")
    public void user_click_on_products() {
        driver.findElement(By.xpath("//a[contains(text(),\"Products\")]")).click();
    }

    @Then("user verify ALL PRODUCTS text")
    public void userVerifyALLPRODUCTSText() {
        String allProducts = driver.findElement(By.xpath("//h2[text()='All Products']")).getText();
        assert allProducts.equals("ALL PRODUCTS");
    }

    @When("user hover over {int} and click Add to cart")
    public void userHoverOverAndClickAddToCart(int productNumber) throws InterruptedException {
        productNumber++;
        WebElement productItem = driver.findElement(By.xpath("//section[2]/div/div/div[2]/div/div["+productNumber+"]"));
        actions.moveToElement(productItem).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div["+productNumber+"]/div/div[1]/div[2]/div/a"))
                .click();
    }

    @And("user click continue Shopping button")
    public void userClickContinueShoppingButton() {
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
    }

    @When("user click on view cart button")
    public void userClickOnViewCartButton() {
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();
    }

    @Then("user verify {int} is added as {string}")
    public void userVerifyIsAddedAs(int productNumber, String productName) {
        String verifyProductText = driver.findElement(By.xpath("//*[@id=\"product-"+productNumber+"\"]/td[2]/h4/a"))
                .getText();
        assert verifyProductText.equals(productName);
    }

    @And("user verify {int} price as {string}")
    public void userVerifyPriceAs(int productNumber, String productPrice) {
        String verifyProductPrice = driver.findElement(By.xpath("//*[@id=\"product-"+productNumber+"\"]/td[3]/p"))
                .getText();
        assert verifyProductPrice.equals(productPrice);
    }

    @And("user verify {int} quantity as {int}")
    public void userVerifyQuantityAs(int productNumber, int productQty) {
        int verifyProductQty = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"product-"+productNumber+"\"]/td[4]/button"))
                .getText());
        Assert.assertEquals(verifyProductQty, productQty);
    }
}
