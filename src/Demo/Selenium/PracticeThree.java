package Demo.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class PracticeThree {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Neharika\\IdeaProjects\\SeleniumSample\\chromedriver.exe");
        WebDriver drive=new ChromeDriver();
        drive.manage().window().maximize();
        drive.get("https://demo.automationtesting.in/Register.html");

        drive.findElement(By.xpath("//label[text()='Full Name* ']/following-sibling::div[1]/input")).sendKeys("Narayana");
        drive.findElement(By.xpath("//label[text()='Full Name* ']/following-sibling::div[2]/input")).sendKeys("Swami");
        drive.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys("Bagalkot");
        drive.findElement(By.xpath("//input[@ng-model='EmailAdress']")).sendKeys("narayana@gmail.com");
        drive.findElement(By.xpath("//input[@ng-model='Phone']")).sendKeys("8895676791");

        drive.findElement(By.xpath("//input[@value='Male']")).click();

        List<WebElement> list = drive.findElements(By.xpath("//input[@type='checkbox']"));

        for(int i=0; i<list.size(); i++){
            list.get(i).click();
        }

        drive.findElement(By.xpath("//input[@ng-model='Password']")).sendKeys("nopassword");
        drive.findElement(By.xpath("//input[@ng-model='CPassword']")).sendKeys("nopassword");

        drive.findElement(By.xpath("//label[text()='Languages']/following-sibling::div[1]//div[1]")).click();
        drive.findElement(By.xpath("//label[text()='Languages']/following-sibling::div[1]//div[2]/ul/li[7]/a")).click();

        drive.findElement(By.xpath("//label[text()='Languages']")).click();

        drive.findElement(By.xpath("//select[@ng-model='Skill']/option[7]")).click();

        drive.findElement(By.xpath("//label[text()='Languages']")).click();

        drive.findElement(By.xpath("//select[@id='country']/option[6]")).click();

        drive.findElement(By.xpath("//label[text()='Languages']")).click();

        drive.findElement(By.xpath("//label[text()='Date Of Birth']/following-sibling::div/select/option[86]")).click();
        drive.findElement(By.xpath("//label[text()='Date Of Birth']/following-sibling::div[2]/select/option[12]")).click();
        drive.findElement(By.xpath("//label[text()='Date Of Birth']/following-sibling::div[3]/select/option[29]")).click();

        drive.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);
        drive.findElement(By.xpath("//button[@type='button']")).click();

        drive.close();
        System.out.println("Run Successfully");
    }
}
