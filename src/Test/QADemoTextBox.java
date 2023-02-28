package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class QADemoTextBox {
    public void method() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/Neharika/IdeaProjects/SeleniumSample/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='card-up']/following-sibling::div//h5[text()='Elements']")).click();

        driver.findElement(By.xpath("//li[@id='item-0']//span[text()='Text Box']")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//div[@class='main-header' and contains(text(),'Text Box')]")).isDisplayed());


        List<String> name=new ArrayList<>();
        name.add("userName");
        name.add("userEmail");

        for(int i=0; i<name.size(); i++){
            if(name.get(i).equals("userName")) {
                driver.findElement(By.xpath("//input[@id='" + name.get(i) + "']")).sendKeys("Narayana");
            }else {
                driver.findElement(By.xpath("//input[@id='" + name.get(i) + "']")).sendKeys("Narayana@email.com");
            }
        }

        List<String> address=new ArrayList<>();
        address.add("currentAddress");
        address.add("permanentAddress");

        for(int i=0; i<address.size(); i++){
            driver.findElement(By.xpath("//textarea[@id='"+address.get(i)+"']")).sendKeys("Gadag");
        }

        driver.findElement(By.xpath("//button[text()='Submit' and @id='submit']")).click();
        Thread.sleep(5000);
        driver.quit();
        System.out.println("Completed");

    }
}

























/*
List<String> header=new ArrayList<>();
        header.add("Text Box");
        header.add("Check Box");
        header.add("Radio Button");
        for (int k=0;k<header.size();k++){
            if(header.get(k).equals("Text Box")) {
                System.out.println(driver.findElement(By.xpath("//div[@class='main-header' and contains(text(),'"+header.get(0)+"')]")).isDisplayed());
            } else if(header.get(k).equals("Check Box")) {
                System.out.println(driver.findElement(By.xpath("//div[@class='main-header' and contains(text(),'"+header.get(1)+"')]")).isDisplayed());
            } else{
                System.out.println(driver.findElement(By.xpath("//div[@class='main-header' and contains(text(),'"+header.get(2)+"')]")).isDisplayed());
            }
        }
 */