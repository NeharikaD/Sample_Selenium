package Java.Sample;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;
public class TextClass extends EnClass{
    private String Address;
    public TextClass(String address) {
        this.Address = address;
    }
    public void textMethod() throws InterruptedException {
        super.textMethod();
        test();
        driver.findElement(By.xpath("//li[@id='item-0']//span[text()='Text Box']")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//div[@class='main-header' and contains(text(),'Text Box')]")).isDisplayed());
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(getUserName());
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(getUserEmail());
        List<String> address=new ArrayList<>();
        address.add("currentAddress");
        address.add("permanentAddress");
        for(int i=0; i<address.size(); i++){
            driver.findElement(By.xpath("//textarea[@id='"+address.get(i)+"']")).sendKeys(Address);
        }
        driver.findElement(By.xpath("//button[text()='Submit' and @id='submit']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@class='border col-md-12 col-sm-12']")).isDisplayed());
        Thread.sleep(5000);
    }
}
