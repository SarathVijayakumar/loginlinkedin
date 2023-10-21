package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkedInAutomation {
    private ChromeDriver driver;

    public LinkedInAutomation() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public void signInAndPrintCounts() {
        try {
            driver.get("https://in.linkedin.com/");
            // Add code to sign in to your LinkedIn account here.

            // Print the count of 'Who's viewed your profile' and 'Impressions of your post'
            String profileViewsCount = driver.findElement(By.className("feed-identity-module__stat")).getText();
            String postImpressionsCount = driver.findElement(By.className("v-align-middle")).getText();

            System.out.println("Who's viewed your profile: " + profileViewsCount);
            System.out.println("Impressions of your post: " + postImpressionsCount);
        } catch (Exception e) {
            System.err.println("Error in signInAndPrintCounts: " + e.getMessage());
        }
    }

    public void createLinkedInPost() {
        try {
            // Add code to create a LinkedIn post here (e.g., sharing with 'Connections only').

            // Confirm if the post gets posted.
            // You can add code to check for the confirmation message or any other indicators.
        } catch (Exception e) {
            System.err.println("Error in createLinkedInPost: " + e.getMessage());
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
        LinkedInAutomation linkedInAutomation = new LinkedInAutomation();
        linkedInAutomation.signInAndPrintCounts();
        linkedInAutomation.createLinkedInPost();
        linkedInAutomation.endTest();
    }
}

