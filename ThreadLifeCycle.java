
class Threadcycle extends Thread{
    public void run(){
        for(int i=0;i<5;i++){
            try{
                Thread.sleep(1000);
                System.out.println(Thread.currentThread()+"Thread is running");
            }
            catch(InterruptedException e){
                System.out.println(e);  
        }
    }
}
}

class RunnableThread implements Runnable{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread()+"Runnable Thread is running");
        }
    }
} 

    

public class ThreadLifeCycle {
    public static void main(String[] args) {
        
        Threadcycle t1=new Threadcycle();
        RunnableThread r1=new RunnableThread();

        Thread t2=new Thread(r1);

        t1.start();
        t2.start();
        t1.setName("Threan1");
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setName("RunnableThead");
        System.out.println("Thread Name :"+t1.getName() +
        "state :"+t1.getState()+
        "priority :"+t1.getPriority());
        System.out.println("Thread Name :"+t2.getName() +
        "state :"+t2.getState()+
        "priority :"+t2.getPriority());
        for(int i=0;i<5;i++){
            System.out.println("main method");
        }
    }
}
