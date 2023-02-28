package Demo.SeleniumOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class BigQADemo {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","C:/Users/Neharika/IdeaProjects/SeleniumSample/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        List<String> list = new ArrayList<>();
        list.add("Elements");
        list.add("Forms");
        list.add("Alerts, Frame & Windows");
        list.add("Widgets");
        list.add("Interactions");
        list.add("Book Store");

        for(int x=0; x<list.size(); x++){
            driver.findElement(By.xpath("//div[@class='card-up']/following-sibling::div//h5[contains(text(),'"+list.get(x)+"')]")).click();
            System.out.println(driver.findElement(By.xpath("//div[@class='main-header' and contains(text(),'"+list.get(x)+"')]")).isDisplayed());
            Thread.sleep(2000);
            if(list.get(x).equals("Elements")){

                driver.findElement(By.xpath("//li[@id='item-2']/span[contains(text(),'Radio Button')]")).click();

                List<String> RadioButtons = new ArrayList<>();
                RadioButtons.add("Yes");
                RadioButtons.add("Impressive");
                RadioButtons.add("No");

                for(int i=0; i<RadioButtons.size(); i++) {
                    WebElement RadioBtn = driver.findElement(By.xpath("//label[text()='" + RadioButtons.get(i) + "']"));
                    RadioBtn.click();
                    Thread.sleep(2000);
                    System.out.println(RadioButtons.get(i) + " Button is Enabled: " + driver.findElement(By.xpath("//label[text()='" + RadioButtons.get(i) + "']/preceding-sibling::input")).isEnabled());
                    Thread.sleep(2000);
                }

                Thread.sleep(2000);
                break;
            }
            driver.findElement(By.xpath("//a[contains(@href,'https://demoqa.com')]/img")).click();
            Thread.sleep(2000);
        }

        Thread.sleep(2000);
        driver.quit();
        System.out.println("Mission Accomplished");
    }
}
