public class ThreadExampleTwoValueReturning {

    public static void main(String[] args){


        System.out.println("####starting main thread");
        ValueReturningTaskB task1= new ValueReturningTaskB(10,20,100, new SumObserver("task-1"));
        ValueReturningTaskB task2= new ValueReturningTaskB(20,30,1000,new SumObserver("task-2"));
        ValueReturningTaskB task3= new ValueReturningTaskB(30,40,500,new SumObserver("task-3"));

        Thread thread1 = new Thread(task1, "Thread-1");
        Thread thread2 = new Thread(task2, "Thread-2");
        Thread thread3 = new Thread(task3, "Thread-3");


        thread1.start();
        thread2.start();
        thread3.start();



        System.out.println("####completed main thread");




    }
}
