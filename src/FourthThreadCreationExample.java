public class FourthThreadCreationExample {public static void main(String[] args){
    System.out.println("main started");
   // new SecondTask().start();
    // new FirstTask();
    //new ThirdTask();

    new Thread(new FourthTask()::run).start();
    System.out.println("main ended");


}



}


class FourthTask implements Runnable{

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

    FourthTask(){
        this.instance=++count;


    }

}
