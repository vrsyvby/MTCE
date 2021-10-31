import java.util.concurrent.Callable;

public class CalculationResultTaskB implements Callable<ReturnResult> {

    int a;
    int b;
    long sleepTime;
    private static int count=0;
    private int instanceNumber;
    private String taskId;

    CalculationResultTaskB(int a, int b, long sleepTime){
        this.a=a;
        this.b=b;
        this.sleepTime=sleepTime;
        this.instanceNumber=++count;
        this.taskId= "ValueReturningTaskA: "+instanceNumber;

    }

    @Override
    public ReturnResult call() throws Exception {
        String name= Thread.currentThread().getName();
        System.out.println("##### starting thread name: "+name);
      try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      return new ReturnResult<>(taskId,a+b);
    }
}
