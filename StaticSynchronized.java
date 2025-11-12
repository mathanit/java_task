class Web{
    static synchronized void show(String name){
        for(int i=0;i<5;i++){
            try{
                Thread.sleep(2000);
                System.out.println("hello  "+name);
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
class User extends Thread{
    Web w;
    String name;
    User(Web w,String name){
        this.w=w;
        this.name=name;
    }
    public void run(){
        w.show(name);
    }


}

public class StaticSynchronized {
    public static void main(String[] args) {
        Web obj1 =new Web();
        Web obj2 =new Web();
        Web obj3 =new Web();
        User u1=new User(obj1,"user1");
        User u2=new User(obj2,"user2");
        User u3=new User(obj3,"user3");
        u1.start();
        u2.start();
        u3.start();
    }
}
