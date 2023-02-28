package Java.Test;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DemoConstructor {
//    public WebDriver driver;
//    DemoConstructor(WebDriver driver){
//        this.driver=driver;
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://demoqa.com/");
//    }

    DemoConstructor(){
        System.out.println(">_<");
    }
    DemoConstructor(int a){
        System.out.println(a);
    }
}
