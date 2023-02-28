package Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class WindowsDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/Neharika/IdeaProjects/SeleniumSample/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@class='card-up']/following-sibling::div//h5[text()='Alerts, Frame & Windows']")).click();
        driver.findElement(By.xpath("//li[@id='item-0']//span[text()='Browser Windows']")).click();
        Thread.sleep(2000);

        String currentWindowTwo="";
        String currentWindow = driver.getWindowHandle();
        List<String> listOfButtons=new ArrayList<>();
        listOfButtons.add("tabButton");
        listOfButtons.add("windowButton");
        listOfButtons.add("messageWindowButton");

        for(int i=0; i<listOfButtons.size(); i++) {
            driver.findElement(By.xpath("//button[@id='" + listOfButtons.get(i) + "']")).click();
            Thread.sleep(2000);
            Set<String> listOfWindows = driver.getWindowHandles();
            Iterator<String> listValue = listOfWindows.iterator();
            while (listValue.hasNext()){
                String childWindow = listValue.next();
                if(!currentWindow.equals(childWindow)){
                    driver.switchTo().window(childWindow);
                    Thread.sleep(2000);
                    currentWindowTwo = driver.getWindowHandle();
                    if(driver.switchTo().window(childWindow).getCurrentUrl().equals("https://demoqa.com/sample")){
                        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
                    }
                    else{
                        System.out.println("not accepting");
                    }

//                    System.out.println(currentWindowTwo.equals(childWindow));
//                    System.out.println(driver.switchTo().window(childWindow).getTitle());
//                    System.out.println(childWindow);

//                    System.out.println(driver.switchTo().window(childWindow).manage().hashCode());

//                    System.out.println(driver.switchTo().window(childWindow) == (driver.findElement(By.xpath("about:blank"))));


//                    if((driver.switchTo().window(childWindow).hashCode()) == (988904418)) {
//                        System.out.println("not accepting");
//                        driver.close();
//                        break;
////                        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
////                        System.out.println(driver.findElement(By.xpath("//body[contains(text(),'Knowledge')]")).getText());
////                        System.out.println(driver.findElement(By.xpath("//body")).getText());
//                    }
//////                    else if ((driver.switchTo().window(childWindow).manage().hashCode()) == (1403716230)) {
//////                        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
////////                        System.out.println(driver.findElement(By.xpath("//body[contains(text(),'Knowledge')]")).getText());
////////                        System.out.println(driver.findElement(By.xpath("//body")).getText());
//////                    }
//                    else{
//                        System.out.println(driver.findElement(By.xpath("//body")).getText());
////                        break;
////                        System.out.println("not acceptable");
////                        driver.close();
////                        break;
//                    }
//                    wait.until(ExpectedConditions.urlMatches("https://demoqa.com/sample"));
//                    System.out.println(driver.findElement(By.xpath("//body")).getText());
                    driver.close();
                }
            }
            driver.switchTo().window(currentWindow);
        }

        currentWindowTwo = driver.getWindowHandle();
        Thread.sleep(2000);
        if(currentWindow.equals(currentWindowTwo)){
            System.out.println("we are on the parent window");
        }else{
            System.out.println("we are on child window");
        }

        Thread.sleep(2000);
        driver.quit();
        System.out.println("Executed");
    }
}




/*

//106557175    //1111379131    //1403716230
//1190566357    //224060798    //1107204185
//1988939205    //50720817     //747870628
//1988939205    //1924990666   //988904418

CDwindow-F2AE2F78B5C49AE446CBCE332D17150B
CDwindow-A29101F9E891613B4BE580510D2D9A30
CDwindow-C50E8BC8DBBF04B23F1A6D6B6C98E5CE

 */



/*

package Java.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowsDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/Neharika/IdeaProjects/SeleniumSample/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@class='card-up']/following-sibling::div//h5[text()='Alerts, Frame & Windows']")).click();
        driver.findElement(By.xpath("//li[@id='item-0']//span[text()='Browser Windows']")).click();
        Thread.sleep(2000);

        String currentWindowTwo="";
        String currentWindow=driver.getWindowHandle();
        driver.findElement(By.id("tabButton")).click();
        driver.findElement(By.id("windowButton")).click();
        driver.findElement(By.id("messageWindowButton")).click();

        Set<String> childWindows = driver.getWindowHandles();
        Iterator<String> listOfWindows=childWindows.iterator();
        while (listOfWindows.hasNext()){
            String childWindow=listOfWindows.next();
            if (!currentWindow.equals(childWindow)){
                driver.switchTo().window(childWindow);
//                System.out.println(driver.switchTo().window(childWindow).getCurrentUrl().equals("https://demoqa.com/sample"));
//                System.out.println(driver.findElement(By.xpath("//body")).getText().equals("This is a sample page"));
                if(driver.switchTo().window(childWindow).getCurrentUrl().equals("https://demoqa.com/sample")){
                    System.out.println(driver.findElement(By.xpath("//body")).getText());
                }//else{
//                    break;
//                }
                driver.close();
            }
//            System.out.println(driver.findElement(By.xpath("//body")).getText());
        }
        driver.switchTo().window(currentWindow);

//        System.out.println(currentWindow);
//        Thread.sleep(2000);
//        driver.findElement(By.id("messageWindowButton")).click();
//        currentWindowTwo = driver.getWindowHandle();
//        driver.switchTo().window(currentWindowTwo);
//        Thread.sleep(2000);
//        System.out.println(currentWindowTwo);
//        Thread.sleep(2000);
//        driver.close();

//        currentWindowTwo=driver.getWindowHandle();
//        for(String i:childWindows){
//            if(!childWindows.equals(currentWindow)) {
//                Thread.sleep(2000);
//                driver.switchTo().window(i);
////                wait.until(ExpectedConditions.urlMatches("about:blank"));
////                System.out.println("hashcode: "+driver.switchTo().window(i).manage().hashCode());
//                if((driver.switchTo().window(i).manage().hashCode() != 747870628) && driver.switchTo().window(i).manage().hashCode() != 976358110){
//                    System.out.println(driver.findElement(By.id("sampleHeading")).getText());
//                } else {
//                    System.out.println("+++");
//                }
//            }
//        }

        driver.quit();
        System.out.println("Done");
    }
}

 */




































/*
System.out.println(driver.findElement(By.id("sampleHeading")).getText());
*/