package Demo.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class PracticeOne {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Neharika\\IdeaProjects\\SeleniumSample\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Register.html");


//        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys("Satya");
//        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).sendKeys("Swami");
//
//        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).sendKeys("Gadag");
//
//        driver.findElement(By.xpath("//*[@id=\"eid\"]/input")).sendKeys("satyaswami@gmail.com");
//        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")).sendKeys("9226540035");
//
//        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[1]/input")).click();
//
//        driver.findElement(By.id("checkbox1")).click();
//        driver.findElement(By.id("checkbox2")).click();
//        driver.findElement(By.id("checkbox3")).click();
//        driver.findElement(By.id("firstpassword")).sendKeys("Swami@2023");
//        driver.findElement(By.id("secondpassword")).sendKeys("Swami@2023");



        driver.findElement(By.tagName("textarea")).sendKeys("address");
        List<WebElement> l=driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i=0; i<l.size(); i++){
            l.get(i).click();
        }
        driver.findElement(By.id("firstpassword")).sendKeys("ha!ha!ha!");

        driver.findElement(By.id("msdd")).click();
        driver.findElement(By.linkText("Arabic")).click();

//        driver.findElement(By.name())
//        driver.findElement(By.xpath())
//        driver.findElement(By.partialLinkText())
//        driver.findElement(By.cssSelector())



//        driver.findElement(By.id("submitbtn")).click();
//        Thread.sleep(5000);
//        driver.findElement(By.id("Button1")).click();
//
//        Thread.sleep(5000);
//        driver.close();
        System.out.println("\"Successfully Completed\"");
    }
}
