class One{
    Two t;
    
    synchronized void method1(Two t){
        System.out.println("method one start...");
       t.method4(); 
    }
        void method2(){
        System.out.println("method two start...");
    }
}
class Two{
  
    synchronized void method3(One o){
        System.out.println("method three start...");
        o.method2();
    }
       synchronized void method4(){
        System.out.println("method four start...");
    }
}
class Deadlock1 extends Thread {
    One o;
    Two t;
    Deadlock1(One o,Two t){
        this.o=o;
        this.t=t;
    }
    public void run(){
        o.method1(t);
        
    }
}
class Deadlock2 extends Thread {
    One o;
    Two t;
    Deadlock2(One o,Two t){
        this.o=o;
        this.t=t;
    }
    public void run(){
        t.method3(o);
        
    }
}
public class DealdlockPrevent {
    public static void main(String[] args) {
       
        One o=new One();
        Two t=new Two();
        Deadlock1 d1=new Deadlock1(o, t);
        Deadlock2 d2 =new Deadlock2(o, t);
        d1.start();
        d2.start();
    }
}
