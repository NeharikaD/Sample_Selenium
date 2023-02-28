package Java.Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class RegisterPage extends HomePage {

//    public WebDriver driver = new ChromeDriver();
//    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//    RegisterPage() {
//        super(driver);
//    }
//    RegisterPage(WebDriver driver) {
//        super(driver);
//    }
//    RegisterPage(WebDriver driver) {
//        this.driver=driver;
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.navigate().to("https://demo.automationtesting.in/Index.html");
//    }
//    public void homeMethod(){
//        HomePage page=new HomePage();
//    }
    public void registerValue() throws InterruptedException {
        List<WebElement> name=driver.findElements(By.xpath("//label[text()='Full Name* ']/following-sibling::div/input"));
        name.get(0).sendKeys("Narayana");
        name.get(1).sendKeys("Swami");

        driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys("Gadag");
        driver.findElement(By.xpath("//label[text()='Email address*']/following-sibling::div//input[@ng-model='EmailAdress']")).sendKeys(getEmail());
        driver.findElement(By.xpath("//label[text()='Phone*']/following-sibling::div/input[@ng-model='Phone']")).sendKeys("1234567890");

        driver.findElement(By.xpath("//input[@value='Male']")).click();

        List<WebElement> hobbies = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for(int i=0; i<hobbies.size(); i++){
            if(!(hobbies.get(i).getAttribute("value")).equals("Movies")){
                hobbies.get(i).click();
            }
        }

        List<WebElement> passWord=driver.findElements(By.xpath("//label[contains(text(),'Password')]/following-sibling::div/input"));
        for(int i=0; i<passWord.size(); i++){
            passWord.get(i).sendKeys(getPassword());
        }

        driver.findElement(By.xpath("//label[contains(text(),'Languages')]/following-sibling::div")).click();
        List<WebElement>  language=driver.findElements(By.xpath("//multi-select/div[2]//li/a"));
        language.get(7).click();
        language.get(11).click();
        language.get(15).click();
        driver.findElement(By.xpath("//label[contains(text(),'Languages')]")).click();

//        WebElement element=driver.findElement(By.xpath("//multi-select/div[2]//li/a"));
//        Select obj = new Select(element);
//        List<WebElement> languages = obj.getOptions();
//        languages.get(7).click();

        WebElement selection=driver.findElement(By.id("Skills"));
        Select skill=new Select(selection);
        skill.selectByVisibleText("Android");

        WebElement countrySelection=driver.findElement(By.id("country"));
        Select country=new Select(countrySelection);
        country.selectByVisibleText("India");

        WebElement yearSelection=driver.findElement(By.id("yearbox"));
        Select year=new Select(yearSelection);
        year.selectByValue("2004");

        WebElement monthSelection=driver.findElement(By.xpath("//select[@ng-model='monthbox']"));
        Select month=new Select(monthSelection);
        month.selectByVisibleText("November");

        WebElement dateSelection=driver.findElement(By.id("daybox"));
        Select date=new Select(dateSelection);
        date.selectByValue("28");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@type='button']")).click();
    }

    public void switchToMethod() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'SwitchTo')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Alerts')]")).click();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//span[@class='ns-qshek-e-16']")).click();

        List<String> alertButton=new ArrayList<>();
        alertButton.add("Alert with OK");
        alertButton.add("Alert with OK & Cancel");
        alertButton.add("Alert with Textbox");

        List<String> alertBtn=new ArrayList<>();
        alertBtn.add("alertbox()");
        alertBtn.add("confirmbox()");
        alertBtn.add("promptbox()");

        for(int i=0; i<alertButton.size(); i++){
            driver.findElement(By.xpath("//a[contains(text(),'"+alertButton.get(i)+"')]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//button[@onclick='"+alertBtn.get(i)+"']")).click();
//            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert=driver.switchTo().alert();
            if(alertBtn.get(i).equals("alertbox()")){
                alert.accept();
            }else if(alertBtn.get(i).equals("confirmbox()")){
                alert.dismiss();
                System.out.println(driver.findElement(By.xpath("//p[@id='demo']")).getText());
            }else if(alertBtn.get(i).equals("promptbox()")){
                alert.sendKeys("Harry Potter");
                Thread.sleep(5000);
                alert.accept();
                System.out.println(driver.findElement(By.xpath("//p[@id='demo1']")).getText());
            }else{
                System.out.println("not acceptable");
            }
        }
    }

}












/*

//        driver.findElement(By.xpath("//label[text()='Full Name* ']/following-sibling::div/input[@placeholder='First Name']")).sendKeys("Narayana");
//        driver.findElement(By.xpath("//label[text()='Full Name* ']/following-sibling::div/input[@placeholder='Last Name']")).sendKeys("Swami");


//        List<String> word=new ArrayList<>();
//        word.add("Password");
//        word.add("CPassword");
//        for(int i=0; i<word.size(); i++){
//            driver.findElement(By.xpath("//label[contains(text(),'Password')]/following-sibling::div/input[@ng-model='"+word.get(i)+"']")).sendKeys(getPassword());
//            Thread.sleep(2000);
//        }

 */
