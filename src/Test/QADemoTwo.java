package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class QADemoTwo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Neharika\\IdeaProjects\\SeleniumSample\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/select-menu");

        List<WebElement> list = driver.findElements(By.xpath("//select[@id='oldSelectMenu']/option"));
        list.get(3).click();
        System.out.println(list.get(3).getText());
        System.out.println(list.get(2).getAttribute("value"));
        System.out.println(list.size());



        Thread.sleep(2000);
        driver.quit();
        System.out.println("Done");
    }
}
