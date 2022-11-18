package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTestCase {
    protected ChromeDriver driver;
    protected WebDriverWait wait;

    @BeforeClass
    public void setup() {
        //set chromedriver path
        System.setProperty("webdriver.chrome.driver", "/home/subhamk/Downloads/chromedriver_linux64/chromedriver");

        //set browser driver options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "incognito", "--disable-cache");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AfterClass
    public void tearDown() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.close();
    }

    //    @AfterTest
    public void waitAfterTest() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Parameters({"url"})
    @Test
    public void get(String url) {
        driver.get(url);
    }

    @Parameters({"email", "password"})
    @Test
    public void login(String email, String password) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form//input[@id='email']")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form//input[@id='pass']")));
        } finally {
            driver.findElement(By.xpath("//form//input[@id='email']")).sendKeys(email);
            driver.findElement(By.xpath("//form//input[@id='pass']")).sendKeys(password);
            driver.findElement(By.xpath("//form//button[@type='submit']")).click();
        }
    }

    @Test
    public void getProfile() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='banner']")));
        } finally {
            WebElement ele = driver.findElement(By.xpath("//div[@role='banner']"));
            System.out.println("Ele::"+ele);
        }
    }


}
