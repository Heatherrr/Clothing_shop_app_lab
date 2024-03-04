import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ClothingStoreTest {

    private AppiumDriver<MobileElement> driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        // Set up desired capabilities for the Android device
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "your_device_name");
        caps.setCapability("udid", "your_device_udid");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "Android_version");
        caps.setCapability("appPackage", "your_app_package");
        caps.setCapability("appActivity", "your_app_activity");

        // Initialize the driver
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(url, caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testUserRegistration() {
        //Steps for user registration

        driver.findElement(By.id("registration_button")).click();
        driver.findElement(By.id("username_input")).sendKeys("testuser");
        driver.findElement(By.id("email_input")).sendKeys("testuser@example.com");
        driver.findElement(By.id("password_input")).sendKeys("testpassword");
        driver.findElement(By.id("confirm_password_input")).sendKeys("testpassword");
        driver.findElement(By.id("submit_button")).click();

        // Add assertions to verify the successful registration
        Assert.assertTrue(driver.findElement(By.id("success_message")).isDisplayed());
    }

    @Test
    public void testLoginFunctionality() {
        //Steps for login functionality

        driver.findElement(By.id("login_button")).click();
        driver.findElement(By.id("username_input")).sendKeys("testuser");
        driver.findElement(By.id("password_input")).sendKeys("testpassword");
        driver.findElement(By.id("login_submit_button")).click();

        // Assertions to verify successful login
        Assert.assertTrue(driver.findElement(By.id("welcome_message")).isDisplayed());
    }

    @Test
    public void testSearchFunctionality() {
        //Steps for search functionality

        driver.findElement(By.id("search_input")).sendKeys("t-shirt");
        driver.findElement(By.id("search_button")).click();

        // Assertions to verify the search results
        Assert.assertTrue(driver.findElement(By.id("search_result_item")).isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
