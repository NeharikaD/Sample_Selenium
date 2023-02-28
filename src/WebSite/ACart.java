package WebSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ACart extends Amazon {

    public void cartMethod(Amazon it) throws InterruptedException {
        super.cartMethod(it);
        double total = 0;
        List<WebElement> amount = driver.findElements(By.xpath("(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold'])"));
        for(int i=0; i<amount.size(); i++){
            String price = amount.get(i).getText();
            double priceInDigit = Double.parseDouble(price);
            total = total + priceInDigit;
        }
        System.out.println("total: "+total);

        String subTotalString=driver.findElement(By.xpath("//span[@id='sc-subtotal-label-activecart']/following-sibling::span/span")).getText();
        String str = subTotalString.replaceAll(",","");
        double subTotal = Double.parseDouble(str);
        System.out.println("subTotal: "+subTotal);
        System.out.println(total==subTotal);

    }
}
