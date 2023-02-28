package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class QADemoOne {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Neharika\\IdeaProjects\\SeleniumSample\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/checkbox");

        Thread.sleep(2000);

        List<String> checkboxlist=new ArrayList<>();
        checkboxlist.add("home");
        checkboxlist.add("desktop");
        checkboxlist.add("documents");
        checkboxlist.add("downloads");
        checkboxlist.add("workspace");
        checkboxlist.add("office");

        for(int i=0; i<checkboxlist.size(); i++){
            driver.findElement(By.xpath("//label[contains(@for,'"+checkboxlist.get(i)+"')]/span[contains(@class,'checkbox')]/*[contains(@class,'check')]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(@class,'collapsed')]//label[contains(@for, '"+checkboxlist.get(i)+"')]/preceding-sibling::button")).click();
            Thread.sleep(2000);
        }

        for(int i=checkboxlist.size()-1; i>=0; i--){
//            driver.findElement(By.xpath("//label[contains(@for,'"+checkboxlist.get(i)+"')]/span[contains(@class,'checkbox')]/*[contains(@class,'check')]")).click();
//            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(@class,'expanded')]//label[contains(@for,'"+checkboxlist.get(i)+"')]/preceding-sibling::button")).click();
            Thread.sleep(2000);
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@title='Expand all']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@title='Collapse all']")).click();

        Thread.sleep(2000);
        driver.quit();
        System.out.println("Done");
    }
}







































/*


//        List<String> condition = new ArrayList<>();
//        condition.add("check");
//        condition.add("uncheck");



//            for(int j=0; j<condition.size(); j++){
//                if(condition.get(j).equals("uncheck")){
//                    driver.findElement(By.xpath("//label[contains(@for,'"+checkboxlist.get(i)+"')]/span[contains(@class,'checkbox')]/*[contains(@class,'check')]")).click();
//                    Thread.sleep(2000);
//                }else{
//                    driver.findElement(By.xpath("//label[contains(@for,'"+checkboxlist.get(i)+"')]/span[contains(@class,'checkbox')]/*[contains(@class,'check')]")).click();
//                    Thread.sleep(2000);
//                }
//            }
*/
