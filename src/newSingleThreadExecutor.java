import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class newSingleThreadExecutor {

    public static void main(String[] args){
        ExecutorService es= Executors.newSingleThreadExecutor();
        for(int i=0;i<3;i++){

            es.execute(new FirstTask());


        }
        es.shutdown();

    }
}
