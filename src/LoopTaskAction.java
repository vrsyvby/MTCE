import java.util.concurrent.TimeUnit;

public class LoopTaskAction {

    public static void main(String[] args) {
        System.out.println("main started");
        // new SecondTask().start();
        // new FirstTask();
        //new ThirdTask();
       LoopTaskA taskA= new LoopTaskA();
       Thread thread1= new Thread(taskA);
               thread1.start();

        LoopTaskA taskB= new LoopTaskA();
        Thread thread2= new Thread(taskA);
        thread2.start();

        LoopTaskA taskC= new LoopTaskA();
        Thread thread3= new Thread(taskA);
        thread3.start();


        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("taskA cancelled");
        taskA.cancel();
        taskB.cancel();
        taskC.cancel();


        System.out.println("main ended");


    }


}


class LoopTaskA implements Runnable {

    private static int count = 0;

    private int instance = 0;
    private String name="LoopTaskA";

    private volatile boolean shutdown=false;

    public void run() {
        Thread.currentThread().setName(name);
        System.out.println("#### starting worker: "+name);
        for (int i = 0;; i--) {

            System.out.println("executing worker"+name+" instance is " + this.instance + " loop count: " + i);

            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           synchronized (this) {
               if (shutdown) {
                   break;
               }
           }
        }

        System.out.println("#### stopping worker: "+name);
    }

    public void cancel(){
        this.shutdown=true;
    }

    LoopTaskA() {
        this.instance = ++count;
        name+="-"+instance;

    }


}


class LoopTaskB implements Runnable {

    private static int count = 0;

    private int instance = 0;


    public void run() {
        String name=Thread.currentThread().getName();
        System.out.println("#### starting worker: "+name);
        for (int i = 10; i > 0; i--) {

            System.out.println("executing worker "+name+" instance is " + this.instance + " loop count: " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("#### stopping worker: "+name);
    }

    LoopTaskB() {
        this.instance = ++count;


    }


}
