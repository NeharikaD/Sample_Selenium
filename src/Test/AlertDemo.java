package Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AlertDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/Neharika/IdeaProjects/SeleniumSample/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");

        WebElement element=driver.findElement(By.xpath("//div[@class='card-up']/following-sibling::div//h5[text()='Alerts, Frame & Windows']"));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        driver.findElement(By.xpath("//li[@id='item-1']//span[text()='Alerts']")).click();

        List<String> alertButtons = new ArrayList<>();
        alertButtons.add("alertButton");
        alertButtons.add("timerAlertButton");
        alertButtons.add("confirmButton");
        alertButtons.add("promtButton");

        for(int i=0; i<alertButtons.size(); i++){
            driver.findElement(By.xpath("//button[@id='"+alertButtons.get(i)+"']")).click();
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            if(alertButtons.get(i).equals("alertButton")){
                Thread.sleep(3000);
                alert.accept();
            } else if (alertButtons.get(i).equals("timerAlertButton")) {
                Thread.sleep(3000);
                alert.accept();
            }else if (alertButtons.get(i).equals("confirmButton")) {
                alert.dismiss();
                System.out.println(driver.findElement(By.xpath("//span[@id='confirmResult']")).getText());
            }else if (alertButtons.get(i).equals("promtButton")) {
                Thread.sleep(3000);
                alert.sendKeys("Hello");
                alert.accept();
                System.out.println(driver.findElement(By.xpath("//span[@id='promptResult']")).getText());
            }else {
                System.out.println("Some Thing Went Wrong");
                break;
            }
        }

        driver.quit();
        System.out.println(" -- Executed -- ");
    }
}






























/*

//        driver.findElement(By.xpath("//button[@id='alertButton']")).click();
//        Thread.sleep(2000);
//        Alert alert= driver.switchTo().alert();
//        Thread.sleep(2000);
//        System.out.println(alert.getText());
//        alert.accept();
//
//        driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();
//        wait.until(ExpectedConditions.alertIsPresent());
//        Alert alertOne= driver.switchTo().alert();
//        System.out.println(alertOne.getText());
//        alertOne.accept();
//
//        driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
//        Thread.sleep(2000);
//        Alert alertTwo= driver.switchTo().alert();
//        Thread.sleep(2000);
//        System.out.println(alertTwo.getText());
//        alertTwo.dismiss();
//        Thread.sleep(2000);
//        System.out.println(driver.findElement(By.xpath("//span[@id='confirmResult']")).getText());
//
//        driver.findElement(By.xpath("//button[@id='promtButton']")).click();
//        Thread.sleep(2000);
//        Alert alertThree= driver.switchTo().alert();
//        Thread.sleep(2000);
//        System.out.println(alertThree.getText());
//        alertThree.sendKeys("Hello");
//        Thread.sleep(2000);
//        alertThree.accept();
//        System.out.println(driver.findElement(By.xpath("//span[@id='promptResult']")).getText());

 */