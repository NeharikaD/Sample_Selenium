package Demo.SeleniumOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RadioButton {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/Neharika/IdeaProjects/SeleniumSample/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@class='card-up']/following-sibling::div//h5[text()='Elements']")).click();
        driver.findElement(By.xpath("//li[@id='item-2']//span[text()='Radio Button']")).click();

        List<String> RadioButtons = new ArrayList<>();
        RadioButtons.add("Yes");
        RadioButtons.add("Impressive");
        RadioButtons.add("No");

        for (int i = 0; i < RadioButtons.size(); i++) {
            boolean flag = driver.findElement(By.xpath("//label[text()='" + RadioButtons.get(i) + "']/preceding-sibling::input")).isEnabled();
            if(flag) {
                Thread.sleep(2000);
                driver.findElement(By.xpath("//label[contains(text(),'" + RadioButtons.get(i) + "')]")).click();
                Thread.sleep(2000);
                WebElement text = driver.findElement(By.xpath("//p[@class='mt-3']/span[@class='text-success']"));
                if (text.getText().equals("Yes")) {
                    System.out.println("You have selected " + text.getText());
                } else {
                    System.out.println("You have selected Impressive");
                }
            }
            else{
                System.out.println("The radio button is disabled ");
            }
        }
        driver.quit();
        System.out.println("Done");
    }
}
