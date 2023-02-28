package Java.Sample;

import java.util.Scanner;

public class Execution {
    public static void main(String[] args) throws InterruptedException {
        ChildClass childObj=new ChildClass();
        childObj.windowsMethod("//li[@id='item-0']//span[text()='Browser Windows']");
        Thread.sleep(2000);
        childObj.alertMethod("//li[@id='item-1']//span[text()='Alerts']");
        Thread.sleep(2000);
        childObj.frameMethod("//li[@id='item-2']/span[contains(text(),'Frames')]");


        TextClass elementObject=new TextClass("Gadaga");
        elementObject.setUserName("Narayan");
        elementObject.setUserEmail("Narayan@gmail.com");
        elementObject.textMethod();

        elementObject.driver.quit();
        childObj.driver.quit();
        System.out.println(" -- Executed -- ");
    }
}
