/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo;
import java.net.MalformedURLException;


public class App {
    public void getGreeting() throws InterruptedException, MalformedURLException {
       // Initialize your test class

       // TODO: call your test case functions one after other here
      // SearchAmazon searchAmazon = new SearchAmazon(); // Initialize your SearchAmazon class

        // // Call the testCase01 method
        // searchAmazon.testCase01();
        // searchAmazon.endTest();
        // //END Tests


        //  CountHyperlinks countHyperlinks = new CountHyperlinks();  
        // countHyperlinks.testCase01();
        // // End Tests
        // countHyperlinks.endTest(); 


            // Call the LinkedIn automation methods here
             // Call the LinkedIn automation methods here
        LinkedInAutomation linkedInAutomation = new LinkedInAutomation();
        linkedInAutomation.signInAndPrintCounts();
        linkedInAutomation.createLinkedInPost();
        linkedInAutomation.endTest();   

        // ImageURLsAutomation imageAutomation = new ImageURLsAutomation(); // Initialize your ImageURLsAutomation class

        // // Call the testCase01 method
        // imageAutomation.testCase01();

        // // End the test
        // imageAutomation.endTest();
    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        new App().getGreeting();
        
    }
}
