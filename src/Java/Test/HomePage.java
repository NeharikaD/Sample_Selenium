package Java.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;

    HomePage() {
        System.setProperty("webdriver.chrome.driver","C:/Users/Neharika/IdeaProjects/SeleniumSample/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.automationtesting.in/Index.html");
        driver.findElement(By.tagName("input")).sendKeys("narayanswami@gmail.com");
        driver.findElement(By.xpath("//img[@id='enterimg']")).click();
    }

    private String email, password;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

}
