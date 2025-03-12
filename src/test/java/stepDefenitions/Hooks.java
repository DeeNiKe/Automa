package stepDefenitions;

import org.junit.After;

public class Hooks {
    @After
    public void tearDown(){
        DriverManager.quitDriver();
        System.out.println("Browser closed after tests.....");
    }
}
