package Java.Test;

public class ExecutionClass {
    public static void main(String[] args) throws InterruptedException {

        RegisterPage data=new RegisterPage();
        data.setEmail("narayanswami@gmail.com");
        data.setPassword("Swami@123");
        data.registerValue();
//        data.switchToMethod();
        data.driver.quit();

//        SwitchToPage switchData=new SwitchToPage();
//        switchData.alertMethod();
//        switchData.windowMethod();
//        switchData.frameMethod();
//        switchData.driver.quit();

        System.out.println("--done--");
    }
}
