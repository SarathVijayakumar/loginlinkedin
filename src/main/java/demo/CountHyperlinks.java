package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CountHyperlinks {
    private ChromeDriver driver;

    public CountHyperlinks() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public void testCase01() {
        try {
            driver.get("https://in.bookmyshow.com/explore/home/chennai");
            // Find all hyperlinks on the page
            java.util.List<WebElement> hyperlinks = driver.findElements(By.tagName("a"));
            int numberOfHyperlinks = hyperlinks.size();
            System.out.println("Number of hyperlinks on the page: " + numberOfHyperlinks);
        } catch (Exception e) {
            System.err.println("Error in testCase01: " + e.getMessage());
        }
    }

    public void endTest() {
        try {
            driver.quit();
        } catch (Exception e) {
            System.err.println("Error in endTest: " + e.getMessage());
        }
    }

    
}
