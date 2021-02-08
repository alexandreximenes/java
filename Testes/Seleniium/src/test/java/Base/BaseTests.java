package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BaseTests {

    private WebDriver driver;

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://doctors-development.dandelin.io/");

        driver.manage().window().maximize();
//        driver.manage().window().setSize(new Dimension(350,700));
        List<WebElement> inputs = driver.findElements(By.tagName("input"));

        inputs.get(0).sendKeys("alexandre.ximenes@livetouch.com.br");
        inputs.get(1).sendKeys("123456");

        WebElement entrar = driver.findElements(By.tagName("button")).get(0);
        entrar.click();


    }

    public static void main(String[] args) {
        BaseTests tests = new BaseTests();
        tests.setUp();
    }
}
