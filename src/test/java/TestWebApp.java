import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class TestWebApp {
    @Test
    void testlogin() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--user-data-dir=/tmp/chrome-" + System.currentTimeMillis());
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("http://103.139.122.250/");
        driver.findElement(By.name("email")).sendKeys("1234567@gmail.com");
        driver.findElement(By.name("password")).sendKeys("abcdefg");
        driver.findElement(By.id("m_login_signin_submit")).click();
        //*[@id="form_login"]/div[5]/div
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assert(driver.findElement(By.className("alert-danger")).isDisplayed());
        driver.quit();
    }
}
// Final cached trigger
// Final verified submission from main account - Sat Apr 25 08:59:46 UTC 2026
