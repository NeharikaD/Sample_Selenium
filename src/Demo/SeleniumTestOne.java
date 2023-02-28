package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestOne {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Neharika\\IdeaProjects\\SeleniumSample\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.gmail.com/");
        driver.navigate().to("https://www.gmail.com/");

        driver.manage().window().maximize();

        driver.findElement(By.id("identifierId")).sendKeys("neharikadanigond@gmail.com");
        Thread.sleep(5000);
        driver.findElement(By.id("identifierNext")).click();
//        driver.findElement(By.className("r7XTUb")).click();
        Thread.sleep(5000);

        String actualTitle=driver.getTitle();
        String expectedTitle="gmail";
        driver.close();
        if(actualTitle.equalsIgnoreCase(expectedTitle)){
            System.out.println("test is successful");
        }else{
            System.out.println("test failed");
        }

    }
}
