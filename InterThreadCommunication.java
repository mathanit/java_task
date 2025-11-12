class Shop{
    int bag=20;
    
    synchronized void Order(int countOfOrder){
        
        if(bag>countOfOrder){
            System.out.println("Order Successfully...");
            bag=bag-countOfOrder;
            System.out.println("Remain bag"+bag);
        }
        else{
            try{
                System.out.println("waiting ...");
                    wait();
            }
            catch(Exception e){
                System.out.println(e);
            }
            if(bag>countOfOrder){
                System.out.println("Order Successfully after loading...");
                bag=bag-countOfOrder;
                System.out.println("Remain bag"+bag);
            }

        }
    }
    synchronized void loading(int load){
        bag+=load;
        System.out.println("bag load in the shop successfully");
        System.out.println("Current available bag count :"+bag);
        notify();
        }
    
}
class OrderThread extends Thread{
    Shop shop;
    OrderThread(Shop shop){
        this.shop=shop;
    }
    public void run(){
        shop.Order(100);
    }
}
class ShopLoad extends Thread{
    Shop shop;
    ShopLoad(Shop shop){
        this.shop=shop;
    }
    public void run(){
        shop.loading(100);
    }
}

public class InterThreadCommunication {
    public static void main(String[] args) {
        Shop shop=new Shop();
        ShopLoad load=new ShopLoad(shop);
        OrderThread order=new OrderThread(shop);
        order.start();
        order.setPriority(10);
        load.start();
    }
}
