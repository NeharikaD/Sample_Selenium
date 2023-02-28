package WebSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AWebPage {
    public WebDriver driver;

    AWebPage(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/Neharika/IdeaProjects/SeleniumSample/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

    }
}
