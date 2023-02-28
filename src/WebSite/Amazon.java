package WebSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Amazon extends AWebPage {
    protected String itemsTitle, productTitle;
    String mainWindow, secondWindow;
    public void methodAmazon(){
        driver.get("https://www.amazon.in/");
    }
    public void fashionMethod(Amazon pt) throws InterruptedException {
        List<String> categories = new ArrayList<>();
        categories.add("Women");
        categories.add("Men");
        categories.add("Kids");


        List<String> selections = new ArrayList<>();
        selections.add("Watches");
        selections.add("Sunglasses & frames");
        selections.add("Footwear");

        for(int i=0; i<categories.size(); i++){
            Thread.sleep(2000);
            driver.findElement(By.xpath("//a[text()='Fashion']")).click();
            mainWindow = driver.getWindowHandle();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[@class='nav-a-content' and contains(text(),'"+categories.get(i)+"')]")).click();
            driver.findElement(By.xpath("//img[contains(@alt,'"+selections.get(i)+"')]")).click();
            if(categories.get(i).equals("Women")){
                Thread.sleep(2000);
                driver.findElement(By.xpath("//a/img[@alt='Fastrack Analog Grey Dial Unisex-Adult Watch-38024PP24']")).click();
            }else if(categories.get(i).equals("Men")){
                Thread.sleep(2000);
                driver.findElement(By.xpath("//div[@data-asin='B09TTN31LX']")).click();
            }else if(categories.get(i).equals("Kids")){
                Thread.sleep(2000);
                driver.findElement(By.xpath("//li[@id='sobe_d_b_11_2']//div/img[contains(@alt,'Sneakers')]")).click();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//img[contains(@alt,'Liberty Boys Bastian-2e Sneaker')]")).click();
                Thread.sleep(2000);
                Set<String> windows = driver.getWindowHandles();
                Iterator<String> windowList = windows.iterator();
                while (windowList.hasNext()){
                    String childWindow = windowList.next();
                    if(!mainWindow.equals(childWindow)) {
                        driver.switchTo().window(childWindow);
                        driver.findElement(By.xpath("//img[@alt='N.Blue' and @class='imgSwatch']")).click();
                        WebElement shoe=driver.findElement(By.id("native_dropdown_selected_size_name"));
                        Thread.sleep(2000);
                        Select size = new Select(shoe);
                        size.selectByIndex(2);
                        Thread.sleep(2000);
                    }
                }
            }else{
                Thread.sleep(2000);
                System.out.println("not accepting");
            }
            productTitle=driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
            pt.productTitle = pt.productTitle.toLowerCase();
            System.out.println(pt.productTitle);


            driver.findElement(By.id("add-to-cart-button")).click();
            driver.findElement(By.xpath("//a[contains(text(),'Go to Cart') and @data-csa-c-slot-id='sw-gtc']")).click();
            secondWindow = driver.getWindowHandle();
            driver.switchTo().window(secondWindow);
        }

    }

    protected void cartMethod(Amazon it) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.id("nav-cart")).click();
        String str = driver.findElement(By.xpath("//span[@id='sc-subtotal-label-activecart']")).getText();
        String items = str.replaceAll("[^0-9]","");
        int totalItems = Integer.parseInt(items);

        for (int i = totalItems-1; i >= 0; i--) {
            itemsTitle = driver.findElement(By.xpath("(//span[@class='a-list-item']/a/span/span/span/following-sibling::span)[" + (i + 1) + "]")).getText();
            it.itemsTitle = it.itemsTitle.toLowerCase();
            System.out.println((i + 1) + ") " + it.itemsTitle);
            System.out.println(driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold'])[" + (i + 1) + "]")).getText());

        }



    }

}






















/*

 for(int x=0; x<str.length(); x++) {
            char n = str.charAt(x);
            if (Character.isDigit(n)) {
                System.out.println(n);
            }
 }

protected List<String> stringList, sList;
stringList=new ArrayList<>();
sList=new ArrayList<>();
stringList.add(productTitle);
System.out.println(stringList);

sList.add(itemsTitle);
System.out.println(sList);

System.out.println(stringList.equals(sList));

 */
