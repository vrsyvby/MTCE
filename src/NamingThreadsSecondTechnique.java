import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NamingThreadsSecondTechnique {


    public static void main(String[] args) throws InterruptedException {


        ExecutorService es= Executors.newCachedThreadPool(new NamedThreadFactory());
        for(int i=3;i>0;i--){

            es.execute(new LoopTaskB());

        }

        TimeUnit.MILLISECONDS.sleep(30000);


        for(int i=5;i>0;i--){

            es.execute(new LoopTaskB());

        }

        es.shutdown();

    }
}
