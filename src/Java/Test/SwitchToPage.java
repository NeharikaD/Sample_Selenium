package Java.Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class SwitchToPage extends HomePage {
    public void alertMethod() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'SwitchTo')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Alerts')]")).click();
        Thread.sleep(3000);

        List<String> alertButton=new ArrayList<>();
        alertButton.add("Alert with OK");
        alertButton.add("Alert with OK & Cancel");
        alertButton.add("Alert with Textbox");

        List<String> alertBtn=new ArrayList<>();
        alertBtn.add("alertbox()");
        alertBtn.add("confirmbox()");
        alertBtn.add("promptbox()");

        for(int i=0; i<alertButton.size(); i++){
            driver.findElement(By.xpath("//a[contains(text(),'"+alertButton.get(i)+"')]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//button[@onclick='"+alertBtn.get(i)+"']")).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert=driver.switchTo().alert();
            if(alertBtn.get(i).equals("alertbox()")){
                alert.accept();
            }else if(alertBtn.get(i).equals("confirmbox()")){
                alert.dismiss();
                System.out.println(driver.findElement(By.xpath("//p[@id='demo']")).getText());
            }else if(alertBtn.get(i).equals("promptbox()")){
                alert.sendKeys("Harry Potter");
                Thread.sleep(5000);
                alert.accept();
                System.out.println(driver.findElement(By.xpath("//p[@id='demo1']")).getText());
            }else{
                System.out.println("not acceptable");
            }
        }
    }

    public void windowMethod() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'SwitchTo')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Windows')]")).click();
        Thread.sleep(3000);

        String parentWindow=driver.getWindowHandle();

        List<String> windowKey=new ArrayList<>();
        windowKey.add("Open New Tabbed Windows");
        windowKey.add("Open New Seperate Windows");
        windowKey.add("Open Seperate Multiple Windows");

        List<String> windowButton=new ArrayList<>();
        windowButton.add("Tabbed");
        windowButton.add("Seperate");
        windowButton.add("Multiple");

        for(int i=0; i<windowKey.size(); i++) {
            driver.findElement(By.xpath("//a[contains(text(),'" + windowKey.get(i) + "')]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[contains(@id,'" + windowButton.get(i) + "')]//button")).click();
            Thread.sleep(2000);
            Set<String> windows = driver.getWindowHandles();
            Iterator<String> window = windows.iterator();
            while (window.hasNext()){
                String childWindow=window.next();
                if(!parentWindow.equals(childWindow)){
                    driver.switchTo().window(childWindow);
                    Thread.sleep(2000);
                    System.out.println(driver.switchTo().window(childWindow).getTitle());
                    driver.close();
                }
            }
            driver.switchTo().window(parentWindow);
        }
    }

    public void frameMethod() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'SwitchTo')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Frames')]")).click();
        String frameWindow=driver.getWindowHandle();

        List<String> frames=new ArrayList<>();
        frames.add("Single Iframe");
        frames.add("Iframe with in an Iframe");

        for(int i=0; i<frames.size(); i++){
            driver.findElement(By.xpath("//a[contains(text(),'"+frames.get(i)+"')]")).click();
            if(frames.get(i).equals("Single Iframe")){
                driver.switchTo().frame(driver.findElement(By.id("singleframe")));
                System.out.println(driver.findElement(By.xpath("//div[@class='container']/h5")).getText());
                Thread.sleep(3000);
                driver.findElement(By.xpath("//div[@class='col-xs-6 col-xs-offset-5']/input")).sendKeys("Harry Potter");
                Thread.sleep(3000);
            }else if(frames.get(i).equals("Iframe with in an Iframe")){
                driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']")));//.switchTo().frame(driver.findElement(By.xpath("//h5/following-sibling::iframe[@src='SingleFrame.html']")));
                Thread.sleep(3000);
                System.out.println(driver.findElement(By.xpath("//div[@class='iframe-container']/h5")).getText());
                driver.switchTo().frame(driver.findElement(By.xpath("//h5[contains(text(),'Nested iFrames')]/following-sibling::iframe")));
                System.out.println(driver.findElement(By.xpath("//div[@class='container']/h5")).getText());
                driver.findElement(By.xpath("//div[@class='col-xs-6 col-xs-offset-5']/input")).sendKeys("Hermione Granger");
                Thread.sleep(3000);
            }else{
                System.out.println("Not Accepting");
            }
            driver.switchTo().window(frameWindow);
        }
    }

}
