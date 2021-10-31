import java.util.concurrent.*;

public class ThreadReturningResultExecutorTwo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ExecutorService es= Executors.newCachedThreadPool();
        CompletionService<ReturnResult> completion= new ExecutorCompletionService<>(es);
        completion.submit(new CalculationResultTaskB(10,20,1000));
        completion.submit(new CalculationResultTaskB(20,30,500));
        completion.submit(new CalculationResultTaskB(30,40,2000));

        completion.submit(new LoopTaskA(),new ReturnResult<>("Runnable-1",999));

        es.shutdown();

        for(int i=0;i<4;i++){
            System.out.println(completion.take().get());
        }





    }
}
