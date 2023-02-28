package WebSite;

import org.openqa.selenium.By;

import java.util.Iterator;
import java.util.Set;

public class Flipkart extends  AWebPage {

    public void methodFlipkart() {
        driver.get("https://www.flipkart.com/");
    }

    public void flipkartFashionMethod() throws  InterruptedException{
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
        String mainWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//img[@alt='Mobiles']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='_2kgArB _2CP_Bu']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@class='h1Fvn6']/div[@class='_HYyiu']/img[@class='_1aPR5_'])[7]")).click();
        driver.findElement(By.xpath("(//img[@alt='Redmi 9A Sport (Metallic Blue, 32 GB)'])[1]")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> window = windows.iterator();
        while (window.hasNext()){
            String childWindow = window.next();
            if(!mainWindow.equals(childWindow)){
                driver.switchTo().window(childWindow);
                driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
                Thread.sleep(2000);

            }
        }driver.switchTo().window(mainWindow);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='_3SkBxJ']/span[contains(text(),'Cart')]")).click();
        Thread.sleep(2000);





    }

}
