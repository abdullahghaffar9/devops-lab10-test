package lab;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    @Test
    void test_login_with_incorrect_credentials() {
        // We REMOVED the Windows System.setProperty line here.
        // The Docker image already has ChromeDriver in its system path.
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");               // Run in headless mode [cite: 9]
        options.addArguments("--no-sandbox");             // Bypass OS security model (needed for Docker)
        options.addArguments("--disable-dev-shm-usage");  // Overcome limited resource problems in Docker
        options.addArguments("--remote-allow-origins=*"); // Prevent connection reset issues

        WebDriver driver = new ChromeDriver(options);
        
        try {
            driver.navigate().to("http://103.139.122.250/"); [cite: 11]
            driver.findElement(By.name("email")).sendKeys("qasim@malik.com"); [cite: 12]
            driver.findElement(By.name("password")).sendKeys("abcdefg"); [cite: 13]
            driver.findElement(By.id("m_login_signin_submit")).click(); [cite: 14]
            
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); [cite: 15]
            
            String errorText = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div/div[2]/form/div[1]")).getText(); [cite: 16]
            assertTrue(errorText.contains("Incorrect email or password")); [cite: 17]
        } finally {
            driver.quit(); [cite: 18]
        }
    }
}
