package Demo.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class PracticeTwo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Neharika\\IdeaProjects\\SeleniumSample\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Register.html");

//        List<WebElement> list= driver.findElements(By.xpath("//input[@type='checkbox']"));
//
//        WebElement x=driver.findElement(By.xpath("//label[text()='Movies ']/preceding-sibling::input"));

        driver.findElement(By.xpath("//label[text()='Movies ']/preceding-sibling::input")).click();
        driver.findElement(By.xpath("//label[text()='Movies ']"));

//        if(driver.findElement(By.xpath("//label[text()='Movies ']")).equals("Movies ")){
//            System.out.println("true");
//        }else{
//            System.out.println("false");
//        }

//        for(int i=0;i< list.size();i++){
//            if(x.equals(list.get(i))){
//                list.get(i).click();
//            }
//        }

//        driver.findElement(By.xpath("//label[contains(text(),'Full Name* ')]/following-sibling::div[1]/input")).sendKeys("Harry");
//        driver.findElement(By.xpath("//label[starts-with(text(),'Full')]/following-sibling::div[1]/input")).sendKeys(" Harry");
//        driver.findElement(By.xpath("//input[@type='text' and @ng-model='FirstName']")).sendKeys(" Harry");

//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//label[contains(text(),'Full Name* ')]/following-sibling::div[2]/input")).sendKeys(" Potter");


//        Thread.sleep(2000);
//        driver.close();
        System.out.println("Successfully executed");
    }
}
