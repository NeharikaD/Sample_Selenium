package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Seleniumtest {
    public static void main(String[] args) throws InterruptedException {
        //System.out.println("Hello");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Neharika\\IdeaProjects\\SeleniumSample\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("http://www.google.com");
        driver.navigate().refresh();
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Techpundits inc");

//       Thread.sleep(5000);
//        driver.quit();
//      System.out.println("closing chrome");


    }


}
