package Demo.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class QADemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neharika\\IdeaProjects\\SeleniumSample\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/checkbox");

        driver.findElement(By.xpath("//label[@for='tree-node-home']//span[@class='rct-checkbox']")).click();
        driver.findElement(By.xpath("//label[@for='tree-node-home']/preceding-sibling::button")).click();
        driver.findElement(By.xpath("//label[@for='tree-node-desktop']/preceding-sibling::button")).click();
        driver.findElement(By.xpath("//label[@for='tree-node-documents']/preceding-sibling::button")).click();
        driver.findElement(By.xpath("//label[@for='tree-node-workspace']/preceding-sibling::button")).click();
        driver.findElement(By.xpath("//label[@for='tree-node-office']/preceding-sibling::button")).click();
        driver.findElement(By.xpath("//label[@for='tree-node-downloads']/preceding-sibling::button")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//label[@for='tree-node-notes']//span[@class='rct-checkbox']")).click();
        driver.findElement(By.xpath("//label[@for='tree-node-commands']//span[@class='rct-checkbox']")).click();
        driver.findElement(By.xpath("//label[@for='tree-node-react']//span[@class='rct-checkbox']")).click();
        driver.findElement(By.xpath("//label[@for='tree-node-angular']//span[@class='rct-checkbox']")).click();
        driver.findElement(By.xpath("//label[@for='tree-node-veu']//span[@class='rct-checkbox']")).click();
        driver.findElement(By.xpath("//label[@for='tree-node-public']//span[@class='rct-checkbox']")).click();
        driver.findElement(By.xpath("//label[@for='tree-node-private']//span[@class='rct-checkbox']")).click();
        driver.findElement(By.xpath("//label[@for='tree-node-classified']//span[@class='rct-checkbox']")).click();
        driver.findElement(By.xpath("//label[@for='tree-node-general']//span[@class='rct-checkbox']")).click();
        driver.findElement(By.xpath("//label[@for='tree-node-wordFile']//span[@class='rct-checkbox']")).click();
        driver.findElement(By.xpath("//label[@for='tree-node-excelFile']//span[@class='rct-checkbox']")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//label[@for='tree-node-office']/preceding-sibling::button")).click();
        driver.findElement(By.xpath("//label[@for='tree-node-workspace']/preceding-sibling::button")).click();
        driver.findElement(By.xpath("//label[@for='tree-node-downloads']/preceding-sibling::button")).click();
        driver.findElement(By.xpath("//label[@for='tree-node-documents']/preceding-sibling::button")).click();
        driver.findElement(By.xpath("//label[@for='tree-node-desktop']/preceding-sibling::button")).click();
        driver.findElement(By.xpath("//label[@for='tree-node-home']/preceding-sibling::button")).click();

        Thread.sleep(2000);
        driver.quit();
        System.out.println("Executed");

    }
}
