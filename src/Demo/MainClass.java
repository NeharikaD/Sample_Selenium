package Demo;

public class MainClass extends SeleniumTest{

    public static void main(String[] args) throws InterruptedException {
        System.out.println("before: " + number);
        increment(number);
        System.out.println("after: " + number);
        System.out.println("---------");
        SeleniumTest num = new SeleniumTest();
        System.out.println("before: " + num.number);
        increment(num);
        System.out.println("after: " + num.number);
    }
}
