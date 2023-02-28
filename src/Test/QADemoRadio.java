package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class QADemoRadio {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Neharika\\IdeaProjects\\SeleniumSample\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='card-up']/following-sibling::div//h5[text()='Elements']")).click();
        driver.findElement(By.xpath("//li[@id='item-2']//span[text()='Radio Button']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@class='main-header' and contains(text(),'Radio Button')]")).isDisplayed());

        List<String> RadioButtons = new ArrayList<>();
        RadioButtons.add("Yes");
        RadioButtons.add("Impressive");
        RadioButtons.add("No");



        for(int i=0; i<RadioButtons.size(); i++) {
            WebElement RadioBtn = driver.findElement(By.xpath("//label[text()='" + RadioButtons.get(i) + "']"));
            RadioBtn.click();
            Thread.sleep(2000);
            System.out.println(RadioButtons.get(i)+" is Enabled :"+RadioBtn.isEnabled());
        }
        WebElement text=driver.findElement(By.xpath("//p[@class='mt-3']/span[@class='text-success']"));
        if(text.getText().equals("Yes")){
            System.out.println("You have selected "+ text.getText());
        }else{
            System.out.println("You have selected "+ text.getText());
        }
        System.out.println("No Button is Enabled: "+driver.findElement(By.xpath("//label[@for='noRadio']/preceding-sibling::input")).isEnabled());

        driver.quit();
        System.out.println("Done");











     /*
        driver.findElement(By.xpath("//label[@for='yesRadio']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//label[@for='impressiveRadio']")).click();
        Thread.sleep(2000);

        WebElement element1=driver.findElement(By.xpath("//p[@class='mt-3']/span[@class='text-success']"));
        if(element1.getText().equals("Yes")){
            System.out.println("You have selected 'Yes'");
        }else{
            System.out.println("You have selected 'Impressive'");
        }

//        System.out.println("You have selected 'Yes' : "+element1.getText().equals("Yes"));
//        System.out.println("You have selected 'Impressive' : "+element1.getText().equals("Impressive"));

        System.out.println("Yes Button Enabled: "+(driver.findElement(By.xpath("//label[@for='yesRadio']"))).isEnabled());
        System.out.println("Impressive Button Enabled: "+(driver.findElement(By.xpath("//label[@for='impressiveRadio']"))).isEnabled());

        System.out.println("No Button Enabled: "+driver.findElement(By.xpath("//label[@for='noRadio']/preceding-sibling::input")).isEnabled());
*/




//        List<WebElement> element = driver.findElements(By.xpath("//div[@class='custom-control custom-radio custom-control-inline']/input"));
//
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element.get(0)).click().build().perform();
//
//        WebElement element1=driver.findElement(By.xpath("//p[@class='mt-3']/span[@class='text-success']"));
//        System.out.println("You have selected 'Yes' : "+element1.getText().equals("Yes"));
//        Thread.sleep(2000);
//
//        actions.moveToElement(element.get(1)).click().build().perform();
//        System.out.println("You have selected 'Impressive' : "+element1.getText().equals("Impressive"));
//
//        System.out.println("Yes Button Enabled: "+element.get(0).isEnabled());
//        System.out.println("Impressive Button Enabled: "+element.get(1).isEnabled());
//
//        System.out.println("No Button Enabled: "+driver.findElement(By.xpath("//label[@for='noRadio']/preceding-sibling::input")).isEnabled());
//
//        driver.quit();
//        System.out.println("Done");
    }
}













/*
//        driver.findElement(By.xpath("(//label['custom-control-label::after'])[1]/preceding-sibling::input")).click();

//        driver.findElement(By.xpath("(//div[@class='custom-control custom-radio custom-control-inline'])[1]/input")).click();

//        driver.findElement(By.cssSelector("input#yesRadio")).click();

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
*/