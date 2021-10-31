import java.util.concurrent.ThreadFactory;

public class NamedThreadFactory implements ThreadFactory {
    private int count=0;

    @Override
    public Thread newThread(Runnable r) {
        Thread t= new Thread(r);
        t.setName("FloopWorker"+ ++count);
        return t;
    }
}
