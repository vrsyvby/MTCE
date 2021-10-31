public class ValueReturningTaskB implements Runnable{

    int a;
    int b;
    int sum;
    long sleepTime;
    private static int count=0;
    private int instanceNumber;
    private String taskId;
    private ResultListener<Integer> resultListener;

    ValueReturningTaskB(int a, int b, long sleepTime,ResultListener<Integer> resultListener ){
        this.a=a;
        this.b=b;
        this.sleepTime=sleepTime;
        this.instanceNumber=++count;
        this.taskId= "ValueReturningTaskA: "+instanceNumber;
        this.resultListener=resultListener;
    }

    @Override
    public void run() {
        String name= Thread.currentThread().getName();
        System.out.println("##### starting thread name: "+name);



        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




        resultListener.notifyResult(a+b);
        System.out.println("completed thread name "+name);





    }

}
