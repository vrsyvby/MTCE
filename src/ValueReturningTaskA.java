public class ValueReturningTaskA implements Runnable{
   int a;
   int b;
   int sum;
   long sleepTime;
   private static int count=0;
   private int instanceNumber;
   private String taskId;
   private volatile boolean isDone=false;

    ValueReturningTaskA(int a, int b, long sleepTime){
        this.a=a;
        this.b=b;
        this.sleepTime=sleepTime;
        this.instanceNumber=++count;
        this.taskId= "ValueReturningTaskA: "+instanceNumber;
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



        sum=a+b;
        System.out.println("completed thread name "+name);
        isDone=true;
        synchronized (this){
            System.out.println("notifying thread name "+name);
            this.notify();
        }



    }

    public int getSum(){

        synchronized (this){
            if(!isDone){
                System.out.println("Waiting for thread "+Thread.currentThread().getName()+" to return sum from "+taskId);
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return sum;
    }

}
