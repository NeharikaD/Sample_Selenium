package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Element {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","C:/Users/Neharika/IdeaProjects/SeleniumSample/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");
        driver.findElement(By.xpath("//div[@class='card-up']/following-sibling::div//h5[text()='Elements']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[contains(@href,'https://demoqa.com')]/img")).click();

        driver.navigate().to("https://demoqa.com/");
        driver.findElement(By.xpath("//div[@class='card-up']/following-sibling::div//h5[text()='Forms']")).click();
        Thread.sleep(2000);

        driver.quit();
        System.out.println("Mission Accomplished");
    }
}
