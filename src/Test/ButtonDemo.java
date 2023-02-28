package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ButtonDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/Neharika/IdeaProjects/SeleniumSample/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='card-up']/following-sibling::div//h5[text()='Elements']")).click();
        driver.findElement(By.xpath("//li[@id='item-4']/span[contains(text(),'Buttons')]")).click();


        WebElement element = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
        WebElement element1 = driver.findElement(By.xpath("//button[@id='rightClickBtn']"));

        Thread.sleep(2000);

        Actions clickAction=new Actions(driver);
        clickAction.moveToElement(element).doubleClick().build().perform();
        clickAction.contextClick(element1).build().perform();
        driver.findElement(By.xpath("//button[text()='Click Me']")).click();

        System.out.println("doubleClickMessage displayed: "+driver.findElement(By.xpath("//p[@id='doubleClickMessage']")).isDisplayed());
        System.out.println("rightClickMessage displayed: "+driver.findElement(By.xpath("//p[@id='rightClickMessage']")).isDisplayed());
        System.out.println("dynamicClickMessage displayed: "+driver.findElement(By.xpath("//p[@id='dynamicClickMessage']")).isDisplayed());

        Thread.sleep(5000);
        driver.quit();
        System.out.println("Done");
    }
}
