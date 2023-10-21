package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageURLsAutomation {
    private WebDriver driver;

    public ImageURLsAutomation() {
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

    }

    public void testCase01() {
        try {
            driver.get("https://in.bookmyshow.com/explore/home/chennai");

            // Find the "Recommended Movies" section
            System.out.println("Before finding 'Recommended Movies' section");
            WebElement recommendedMoviesContainer = driver.findElement(By.cssSelector("div[class^='commonStyles__FullWidgetWrapper']"));
            System.out.println("After finding 'Recommended Movies' section");
            System.out.println("Image URLs for 'Recommended Movies':");


            java.util.List<WebElement> imgElements = recommendedMoviesContainer.findElements(By.tagName("img"));
        for (WebElement imgElement : imgElements) {
            String imageURL = imgElement.getAttribute("src");
            if (imageURL != null && !imageURL.isEmpty()) {
                System.out.println(imageURL);
            }
        }

      Thread.sleep(45000);

        System.out.println("Before finding 'Premieres' section");
        WebElement premieresSection = null;
        Thread.sleep(45000);
        
        // Find all elements with class names containing 'sc-lnhrs7-'
        List<WebElement> elementsWithDynamicClass = driver.findElements(By.xpath("//*[contains(@class, 'sc-lnhrs7-')]"));
        
        // Iterate through the found elements
        for (WebElement element : elementsWithDynamicClass) {
            // Check if this element is the 'Premieres' section based on its content or position
            if (element.getText().contains("Premieres")) {
                premieresSection = element;
                break; // Stop searching once found
            }
        }
        Thread.sleep(3000);
        
        if (premieresSection != null) {
            System.out.println("After finding 'Premieres' section");
            System.out.println("Image URLs for 'Premieres':");
        
            List<WebElement> imgElementsPremieres = premieresSection.findElements(By.tagName("img"));
            for (WebElement imgElement : imgElementsPremieres) {
                String imageURL = imgElement.getAttribute("src");
                if (imageURL != null && !imageURL.isEmpty()) {
                    System.out.println(imageURL);
                }
            }
        } else {
            System.err.println("Premieres section not found.");
        }
    }        



    
    catch (Exception e) {
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

    public static void main(String[] args) {
        ImageURLsAutomation imageURLsAutomation = new ImageURLsAutomation();
        imageURLsAutomation.testCase01();
        imageURLsAutomation.endTest();
    }
}
