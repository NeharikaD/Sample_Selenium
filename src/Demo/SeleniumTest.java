package Demo;

public class SeleniumTest {

    public static int number = 10;
    public static void increment(int number){
        number = number+1;
        System.out.println("number: "+number);
    }

    public static void increment(SeleniumTest num){
        num.number = num.number + 1;
        System.out.println("number: "+num.number);
    }



//        System.setProperty("webdriver.chrome.driver","C:\\Users\\Neharika\\IdeaProjects\\SeleniumSample\\chromedriver.exe");
//        WebDriver d=new ChromeDriver();
//        d.get("http://www.google.com");
//        Thread.sleep(5000);
//        d.navigate().refresh();
//
//        d.findElement(By.className("gLFyf")).sendKeys("gmail");
//
////        d.close();
////        d.quit();
//
//
////        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
////        d.manage().window().maximize();
////        d.wait(10000,100000000);
//
//
//
//        d.get("http://support.google.com/google");
//        d.manage().window().maximize();
//
//
////        d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
////        Thread.sleep(10000);
//        d.close();
////        d.quit();
////        System.out.println(d);
//        System.out.println("End");
////        d.quit();
//        System.out.println("thank-You");

    }


