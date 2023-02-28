package Java.Sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class EnClass {
    public WebDriver driver = new ChromeDriver();
    private String userName, userEmail;
    public void setUserName(String userName1) {
        this.userName = userName1;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserEmail(String userEmail1) {
        this.userEmail = userEmail1;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void textMethod() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/Neharika/IdeaProjects/SeleniumSample/chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='card-up']/following-sibling::div//h5[text()='Elements']")).click();
    }
    public void test(){
        System.out.println("Test Method");
    }

}
