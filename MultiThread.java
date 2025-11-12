class Web{
   synchronized void show(String user){
        for(int i=0;i<5;i++){
            System.out.println("Welcome user " +user);
            try{
                Thread.sleep(2000);         
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
public class MultiThread {
    public static void main(String[] args) {
        Web w =new Web();
        User u1=new User(w,"Mathan" );
        User u2=new User(w,"Arul" );
        User u3=new User(w,"Banu" );
        u1.start();
        u2.start();
        u3.start();
    }
}
