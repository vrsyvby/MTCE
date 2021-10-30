public class ThirdThreadCreationExample {
    public static void main(String[] args){
    System.out.println("main started");
    new SecondTask().start();
    // new FirstTask();
     new ThirdTask();
    System.out.println("main ended");

       // new Thread(new ThirdTask()::run);
}



}


class ThirdTask implements Runnable{

    private static int count=0;

    private  int instance=0;

    public void run(){
        for(int i=10;i>0;i--){

            System.out.println("instance is "+this.instance+" loop count: "+i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    ThirdTask(){
        this.instance=++count;
        new Thread(this::run);

    }

}
