public class FifthThreadCreationExample {

    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 10; i > 0; i--) {
                System.out.println(" loop count: " + i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }
}
