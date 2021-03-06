import java.util.concurrent.TimeUnit;

public class ThreadExampleOneValueReturning {

    public static void main(String[] args){


        System.out.println("####starting main thread");
        ValueReturningTaskA task1= new ValueReturningTaskA(10,20,100);
        ValueReturningTaskA task2= new ValueReturningTaskA(20,30,1000);
        ValueReturningTaskA task3= new ValueReturningTaskA(30,40,500);

        Thread thread1 = new Thread(task1, "Thread-1");
        Thread thread2 = new Thread(task2, "Thread-2");
        Thread thread3 = new Thread(task3, "Thread-3");


        thread1.start();
        thread2.start();
        thread3.start();


        while(true){
            System.out.println("is thread1 is alive: "+thread1.isAlive());
            System.out.println("is thread2 is alive: "+thread2.isAlive());
            System.out.println("is thread3 is alive: "+thread3.isAlive());

            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if( !thread1.isAlive() && !thread2.isAlive() && !thread3.isAlive()){
                break;
            }
        }
        System.out.println("####sum returned fro thread1 "+task1.getSum());
        System.out.println("####sum returned fro thread2 "+task2.getSum());
        System.out.println("####sum returned fro thread3 "+task3.getSum());

        System.out.println("####completed main thread");




    }
}
