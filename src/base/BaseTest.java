package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.io.File;

public class BaseTest {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    protected WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    @BeforeMethod
    public void setUp() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        File htmlFile = new File("src/data/QA Programming Exercise.html");
        driver.get("file:///" + htmlFile.getAbsolutePath());
        driverThreadLocal.set(driver);
    }

    @AfterMethod
    public void tearDown() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }
}