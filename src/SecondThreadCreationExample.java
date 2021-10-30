public class SecondThreadCreationExample {

    public static void main(String[] args){
        System.out.println("main started");
        new SecondTask().start();
       // new FirstTask();
        System.out.println("main ended");


    }



}


class SecondTask extends Thread{

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

    SecondTask(){
        this.instance=++count;

    }

}
