package Java.Sample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ChildClass extends ParentClass{
    public void windowsMethod(String windowOne) throws InterruptedException{
        method();
        driver.findElement(By.xpath(windowOne)).click();
        String currentWindowTwo="";
        String currentWindow = driver.getWindowHandle();                       //individual window details
        List<String> listOfButtons=new ArrayList<>();
        listOfButtons.add("tabButton");
        listOfButtons.add("windowButton");
        listOfButtons.add("messageWindowButton");

        for(int i=0; i<listOfButtons.size(); i++) {
            driver.findElement(By.xpath("//button[@id='" + listOfButtons.get(i) + "']")).click();
            Thread.sleep(2000);
            Set<String> listOfWindows = driver.getWindowHandles();              //multiple window details
            Iterator<String> listValue = listOfWindows.iterator();
            while (listValue.hasNext()){
                String childWindow = listValue.next();
                if(!currentWindow.equals(childWindow)){
                    driver.switchTo().window(childWindow);                      //(switchTo) used to focus on child window
                    Thread.sleep(2000);
                    currentWindowTwo = driver.getWindowHandle();
                    driver.switchTo().window(childWindow).close();
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
    }

    public void alertMethod(String alertOne) throws InterruptedException{
        method();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath(alertOne)).click();
        List<String> alertButtons = new ArrayList<>();
        alertButtons.add("alertButton");
        alertButtons.add("timerAlertButton");
        alertButtons.add("confirmButton");
        alertButtons.add("promtButton");

        for(int i=0; i<alertButtons.size(); i++){
            driver.findElement(By.xpath("//button[@id='"+alertButtons.get(i)+"']")).click();
            Thread.sleep(2000);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert= driver.switchTo().alert();
            System.out.println(alert.getText());
            if(alertButtons.get(i).equals("alertButton")){
                alert.accept();
                Thread.sleep(2000);
            } else if (alertButtons.get(i).equals("timerAlertButton")) {
                alert.accept();
                Thread.sleep(2000);
            }else if (alertButtons.get(i).equals("confirmButton")) {
                alert.dismiss();
                Thread.sleep(2000);
                System.out.println(driver.findElement(By.xpath("//span[@id='confirmResult']")).getText());
            }else if (alertButtons.get(i).equals("promtButton")) {
                alert.sendKeys("Hello");
                alert.accept();
                Thread.sleep(2000);
                System.out.println(driver.findElement(By.xpath("//span[@id='promptResult']")).getText());
            }else {
                System.out.println("Some Thing Went Wrong");
                break;
            }
        }
    }

    public void frameMethod(String frameOne) throws InterruptedException{
        method();
        driver.findElement(By.xpath(frameOne)).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame1']")));
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//body/h1[@id='sampleHeading']")).getText());
    }
}






































/*

//    public void methodOne() throws InterruptedException {
//        super.method();
//        driver.findElement(By.xpath("//li[@id='item-2']//span[text()='Radio Button']")).click();
//        List<String> RadioButtons = new ArrayList<>();
//        RadioButtons.add("Yes");
//        RadioButtons.add("Impressive");
//        RadioButtons.add("No");
//
//        for (int i = 0; i < RadioButtons.size(); i++) {
//            boolean flag = driver.findElement(By.xpath("//label[text()='" + RadioButtons.get(i) + "']/preceding-sibling::input")).isEnabled();
//            if(flag) {
//                Thread.sleep(2000);
//                driver.findElement(By.xpath("//label[contains(text(),'" + RadioButtons.get(i) + "')]")).click();
//                Thread.sleep(2000);
//                WebElement text = driver.findElement(By.xpath("//p[@class='mt-3']/span[@class='text-success']"));
//                if (text.getText().equals("Yes")) {
//                    System.out.println("You have selected " + text.getText());
//                } else {
//                    System.out.println("You have selected Impressive");
//                }
//            }
//            else{
//                System.out.println("The radio button is disabled ");
//            }
//        }
//        driver.quit();
//        System.out.println("Done");
//    }

 */