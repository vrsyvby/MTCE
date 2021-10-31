import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NamingThreadsFirstTechnique {

    public static void main(String[] args){


      ExecutorService es= Executors.newCachedThreadPool();
      for(int i=3;i>0;i--){

          es.execute(new LoopTaskA());

      }

      es.shutdown();

    }
}
