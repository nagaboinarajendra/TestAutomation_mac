package seleniumGrid;

 import org.openqa.selenium.*;
 import org.openqa.selenium.remote.DesiredCapabilities;
 import java.net.MalformedURLException;
 import java.net.URL;
 import org.openqa.selenium.remote.RemoteWebDriver;
 import org.testng.Assert;
 import org.testng.annotations.*;

 public class GridSample {

     WebDriver driver;
     String baseURL, nodeURL;

     @BeforeTest
     public void setUp() throws MalformedURLException {
         baseURL = "https://google.com";
         nodeURL = "http://192.168.0.137:4444/wd/hub";
         DesiredCapabilities capability = DesiredCapabilities.chrome();
         capability.setBrowserName("chrome");
         capability.setPlatform(Platform.MAC);
         driver = new RemoteWebDriver(new URL(nodeURL), capability);
     }

     @AfterTest
     public void afterTest() {
         driver.quit();
     }
     @Test
     public void sampleTest() {
         driver.get(baseURL);
         driver.get(baseURL);

         if (driver.getPageSource().contains("google")) {
             Assert.assertTrue(true, "google Link Found");
         } else {
             Assert.assertTrue(false, "Failed: Link not found");
         }

     }

 }
