package WebSite;

public class AExecute {

    public static void main(String[] args) throws InterruptedException{

//        amazon.methodAmazon();
//        amazon.fashionMethod(amazon);
//        amazon.cartMethod(amazon);
//        System.out.println(amazon.productTitle.equals(amazon.itemsTitle));
//        amazon.driver.quit();

        ACart cart = new ACart();
        cart.methodAmazon();
        cart.fashionMethod(cart);
        cart.cartMethod(cart);
        System.out.println(cart.productTitle.equals(cart.itemsTitle));
        cart.driver.quit();

//        Flipkart flipkart = new Flipkart();
//        flipkart.methodFlipkart();
//        flipkart.flipkartFashionMethod();
//        flipkart.driver.quit();


//        ASearch search=new ASearch();
//        search.searchMethod();
//        search.driver.quit();


        System.out.println(" --done-- ");
    }
}
