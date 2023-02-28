package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class QADemoSelect {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Neharika\\IdeaProjects\\SeleniumSample\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");

//        WebElement element=driver.findElement(By.xpath("//select[@id='oldSelectMenu']/option"));
        WebElement element=driver.findElement(By.id("oldSelectMenu"));
        Select selectObj=new Select(element);
        selectObj.selectByIndex(5);
        Thread.sleep(2000);
        selectObj.selectByValue("2");
        Thread.sleep(2000);
        selectObj.selectByVisibleText("White");

        WebElement webElement = driver.findElement(By.name("cars"));
        Select obj = new Select(webElement);

        List<WebElement> list = obj.getOptions();
        list.get(1).click();
        list.get(3).click();
        Thread.sleep(2000);
        System.out.println(list.get(1).getText());
        System.out.println(list.get(0).getAttribute("value"));
        System.out.println(list.get(0).getTagName());
        System.out.println(list.size());
        Thread.sleep(2000);

        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).getText());
            if (list.get(i).getText().equals("Opel")){
                list.get(i).click();
            }
            if(list.get(i).isSelected()){
                System.out.println(true);
//                obj.deselectAll();
            }
        }
        System.out.println(list.isEmpty());
        Thread.sleep(2000);
        obj.deselectByVisibleText("Audi");
        Thread.sleep(2000);
        obj.deselectByValue("saab");



        Thread.sleep(2000);
        driver.quit();
        System.out.println("Completed");
    }
}
