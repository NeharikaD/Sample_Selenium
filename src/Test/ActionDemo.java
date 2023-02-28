package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ActionDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/Neharika/IdeaProjects/SeleniumSample/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://demoqa.com/");

        driver.findElement(By.xpath("//div[@class='card-up']/following-sibling::div//h5[text()='Elements']")).click();
//1
        driver.findElement(By.xpath("//li[@id='item-2']//span[text()='Radio Button']")).click();

        List<String> radioButtons=new ArrayList<>();
        radioButtons.add("yesRadio");
        radioButtons.add("impressiveRadio");
        radioButtons.add("noRadio");

        Actions buttonClickAction = new Actions(driver);
        for(int i=0; i<radioButtons.size(); i++){
            WebElement radioButtonElement=driver.findElement(By.id(radioButtons.get(i)));
            Thread.sleep(2000);
            if(radioButtonElement.isEnabled()){
                buttonClickAction.moveToElement(radioButtonElement).click().build().perform();
                Thread.sleep(2000);
            }
        }

//2
        driver.findElement(By.xpath("//li[@id='item-4']/span[contains(text(),'Buttons')]")).click();

        List<String> buttons=new ArrayList<>();
        buttons.add("Double Click Me");
        buttons.add("Right Click Me");
        buttons.add("Click Me");

        Thread.sleep(2000);
        for(int i=0; i<buttons.size(); i++) {
            WebElement buttonElement = driver.findElement(By.xpath("//button[text()='" + buttons.get(i) + "']"));
            Thread.sleep(2000);
            if (buttons.get(i).equals("Double Click Me")) {
                buttonClickAction.moveToElement(buttonElement).doubleClick().build().perform();
                Thread.sleep(2000);
            }else if ((driver.findElement(By.xpath("//p[@id='doubleClickMessage']")).isDisplayed()) && (buttons.get(i).equals("Right Click Me"))) {
                buttonClickAction.moveToElement(buttonElement).contextClick().build().perform();
                Thread.sleep(2000);
            }else if ((driver.findElement(By.xpath("//p[@id='rightClickMessage']")).isDisplayed()) && (buttons.get(i).equals("Click Me"))) {
                        buttonElement.click();
                        Thread.sleep(2000);
            }else {
                break;
            }
        }


//3
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='Interactions']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@id='item-0']//span[text()='Sortable']")).click();
        Thread.sleep(2000);

        WebElement elementOne = driver.findElement(By.xpath("//div[contains(text(),'One')]"));
        WebElement elementFive = driver.findElement(By.xpath("//div[contains(text(),'Five')]"));
        Thread.sleep(4000);
        buttonClickAction.clickAndHold(elementOne).moveToElement(elementFive).release(elementFive).perform();
        Thread.sleep(4000);



//4
        driver.findElement(By.xpath("//li[@id='item-3']//span[text()='Droppable']")).click();

        WebElement x=driver.findElement(By.id("draggable"));
        WebElement y=driver.findElement(By.xpath("(//div[@id='droppable']/p[contains(text(),'Drop here')])[1]"));
        WebElement z=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        Thread.sleep(2000);
        buttonClickAction.dragAndDrop(x,z).build().perform();
        Thread.sleep(2000);


        driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']")).click();
        WebElement a=driver.findElement(By.xpath("//div[@id='acceptable']"));
        WebElement b=driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        WebElement c=driver.findElement(By.xpath("(//div[@class='drop-box ui-droppable'])[2]"));
        Thread.sleep(2000);
        buttonClickAction.dragAndDrop(b,c).build().perform();
        WebElement c2=driver.findElement(By.xpath("(//div[@class='drop-box ui-droppable'])[2]"));
        if(c.equals(c2)){
            System.out.println("Not acceptable");
        }else{
            System.out.println("acceptable");
        }
        Thread.sleep(2000);
        buttonClickAction.dragAndDrop(a,c).build().perform();
        WebElement c1=driver.findElement(By.xpath("(//div[@class='drop-box ui-droppable'])[2]"));
        if(c.equals(c1)){
            System.out.println("Not acceptable");
        }else{
            System.out.println("acceptable");
        }
        Thread.sleep(2000);


        driver.quit();
        System.out.println("Executed");
    }
}





/*

package Java.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/Neharika/IdeaProjects/SeleniumSample/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://selenium08.blogspot.com/2020/01/drag-drop.html");

        Thread.sleep(2000);
        WebElement hold= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop= driver.findElement(By.xpath("//div[@id='droppable']"));

        Actions action=new Actions(driver);
        Thread.sleep(2000);
        action.clickAndHold(hold).moveToElement(drop).release(drop).perform();
//        action.dragAndDrop(hold,drop).build().perform();
        Thread.sleep(2000);

        driver.navigate().to("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
        WebElement A= driver.findElement(By.xpath("//li[@name='A']"));
        WebElement K= driver.findElement(By.xpath("//li[@name='K']"));
        Thread.sleep(4000);
        action.clickAndHold(A).moveToElement(K).release(K).perform();
        Thread.sleep(4000);

        Thread.sleep(2000);
        driver.quit();
        System.out.println("Done");
    }
}

 */










/*

if(driver.findElement(By.xpath("//span[text()='Yes']")).isDisplayed()){
                    System.out.println(driver.findElement(By.xpath("//span[text()='Yes']")).getText());
                }else{
                    System.out.println(driver.findElement(By.xpath("//span[text()='Impressive']")).getText());
                }

 */