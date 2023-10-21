package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchAmazon {
    WebDriver driver;

    public SearchAmazon() {
        
       

        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }

    public void testCase01() {
        // Step 1: Open Google
        driver.get("https://www.google.com");

        // Wait until the search bar is ready
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));

        // Step 2: Enter 'amazon' into the search bar and press Enter
        driver.findElement(By.name("q")).sendKeys("amazon", Keys.RETURN);

        // Wait for the search results to load (you may need to add more explicit waits here)

        // Step 3: Check if "amazon.in" or "amazon.com" is in the search results
        boolean amazonInFound = driver.getPageSource().contains("amazon.in");
        boolean amazonComFound = driver.getPageSource().contains("amazon.com");

        if (amazonInFound || amazonComFound) {
            System.out.println("Test Passed: 'amazon.in' or 'amazon.com' is found in the search results.");
        } else {
            System.out.println("Test Failed: 'amazon.in' or 'amazon.com' is not found in the search results.");
        }
    }

   
}
