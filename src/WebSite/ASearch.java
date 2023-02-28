package WebSite;

import org.openqa.selenium.By;
import static org.openqa.selenium.Keys.ENTER;

public class ASearch extends Amazon {
    public void searchMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("headphones", ENTER );
        Thread.sleep(2000);
    }
}
