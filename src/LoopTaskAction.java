public class LoopTaskAction {

    public static void main(String[] args) {
        System.out.println("main started");
        // new SecondTask().start();
        // new FirstTask();
        //new ThirdTask();

        new Thread(new LoopTaskA()::run).start();
        System.out.println("main ended");


    }


}


class LoopTaskA implements Runnable {

    private static int count = 0;

    private int instance = 0;
    private String name="LoopTaskA";

    public void run() {
        Thread.currentThread().setName(name);
        System.out.println("#### starting worker: "+name);
        for (int i = 10; i > 0; i--) {

            System.out.println("executing worker"+name+" instance is " + this.instance + " loop count: " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("#### stopping worker: "+name);
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
