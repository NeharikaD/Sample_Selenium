package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FrameDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/Neharika/IdeaProjects/SeleniumSample/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/iframe");

        List<String> selectMenu=new ArrayList<>();
        selectMenu.add("View");
        selectMenu.add("File");
        selectMenu.add("Edit");
        selectMenu.add("Format");

        List<String> selectEdit=new ArrayList<>();
        selectEdit.add("Undo");
        selectEdit.add("Select all");
        selectEdit.add("Cut");

        List<String> selectFormat=new ArrayList<>();
        selectFormat.add("Bold");
        selectFormat.add("Italic");
        selectFormat.add("Underline");
        selectFormat.add("Blocks");
        selectFormat.add("Fonts");
        selectFormat.add("Text color");

        for(int i=0; i<selectMenu.size(); i++) {
            driver.findElement(By.xpath("//span[contains(text(),'" + selectMenu.get(i) + "')]")).click();
            Thread.sleep(2000);
            if(selectMenu.get(i).equals("Edit")){
                for(int e=0; e<selectEdit.size(); e++){
                    if(driver.findElements(By.xpath("//div[contains(text(),'"+selectEdit.get(e)+"')]")).size()==0){
                        driver.findElement(By.xpath("//span[contains(text(),'Edit')]")).click();
                        Thread.sleep(2000);
                    }
                    driver.findElement(By.xpath("//div[contains(text(),'"+selectEdit.get(e)+"')]")).click();
                    Thread.sleep(2000);
                }
            } else if(selectMenu.get(i).equals("View")) {
                driver.findElement(By.xpath("//div[contains(@title,'Visual aids')]")).click();
            } else if(selectMenu.get(i).equals("File")) {
                driver.findElement(By.xpath("//div[contains(text(),'New document')]")).click();
                Thread.sleep(2000);
            } else if(selectMenu.get(i).equals("Format")) {
                for(int f=0; f<selectFormat.size(); f++){
                    if(driver.findElements(By.xpath("//div[contains(text(),'"+selectFormat.get(f)+"')]")).size()==0){
                        driver.findElement(By.xpath("//span[contains(text(),'Format')]")).click();
                        Thread.sleep(2000);
                    }
                    driver.findElement(By.xpath("//div[contains(text(),'"+selectFormat.get(f)+"')]")).click();
                    Thread.sleep(2000);
                    if(selectFormat.get(f).equals("Blocks")){
                        driver.findElement(By.xpath("//div[@title='Heading 3']")).click();
                    } else if (selectFormat.get(f).equals("Fonts")) {
                        driver.findElement(By.xpath("//div[@title='Arial']")).click();
                    }
                    else if(selectFormat.get(f).equals("Text color")) {
                        driver.findElement(By.xpath("//div[@title='Yellow']")).click();
                    }
                    else {

                    }
                }
            } else {
                System.out.println("Something Went Wrong");
                break;
            }
        }
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Rich Text Area']")));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Hello-World");

        Thread.sleep(2000);
        driver.quit();
        System.out.println("Done");
    }
}























/*

//                driver.findElement(By.xpath("//span[contains(text(),'Edit')]")).click();
//                Thread.sleep(4000);
//                Actions act=new Actions(driver);
//                WebElement el= driver.findElement(By.xpath("//span[contains(text(),'Format')]"));
//                act.moveToElement(el).build().perform();
//                Thread.sleep(4000);
//                driver.findElement(By.xpath("//div[contains(text(),'Bold')]")).click();

 */