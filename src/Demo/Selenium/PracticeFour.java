package Demo.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PracticeFour {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Neharika\\IdeaProjects\\SeleniumSample\\chromedriver.exe");
        WebDriver drive=new ChromeDriver();
        drive.manage().window().maximize();
        drive.get("https://demo.automationtesting.in/Register.html");

//        drive.findElement(By.id("Skills")).click();
        Thread.sleep(2000);
        WebElement dropDown = drive.findElement(By.id("Skills"));
        Select selectObject = new Select(dropDown);

        selectObject.selectByIndex(1);
        Thread.sleep(4000);
        selectObject.selectByValue("Android");
        Thread.sleep(4000);
        selectObject.selectByVisibleText("APIs");

//        List<WebElement> list = drive.findElements(By.)



        Thread.sleep(2000);
        drive.quit();
        System.out.println("Run Successfully");
    }
}
