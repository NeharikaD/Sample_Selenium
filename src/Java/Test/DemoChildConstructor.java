package Java.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoChildConstructor extends DemoConstructor {
//    DemoChildConstructor(WebDriver driver){
//        super(driver);
//        driver.findElement(By.xpath("//div[@class='card-up']/following-sibling::div//h5[text()='Elements']")).click();
//    }
    DemoChildConstructor(){
        super(100);
        System.out.println(10);
    }

    public static void main(String[] args) {
        DemoChildConstructor demo=new DemoChildConstructor();

    }
}
