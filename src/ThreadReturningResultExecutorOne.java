import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadReturningResultExecutorOne {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ExecutorService es= Executors.newCachedThreadPool();

        Future<Integer> result1=es.submit(new CalculationTaskA(10,20,2000));
        Future<Integer> result2= es.submit(new CalculationTaskA(10,20,2000));
        Future<Integer> result3=es.submit(new CalculationTaskA(10,20,2000));

        Future<?> result4=es.submit(new LoopTaskA());
        Future<Double> result5=es.submit(new LoopTaskA(),999.888);
        es.shutdown();

        System.out.println("##### result from task1 "+result1.get());
        System.out.println("##### result from task2 "+result2.get());
        System.out.println("##### result from task3 "+result3.get());
        System.out.println("##### result from task4 "+result4.get());
        System.out.println("##### result from task5 "+result5.get());



    }
}
