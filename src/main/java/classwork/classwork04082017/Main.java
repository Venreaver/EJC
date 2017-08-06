package classwork.classwork04082017;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; ++i) {
                    System.err.println(i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        System.err.println("start...");
        thread.start();
        thread.join();
        System.err.println("finish.");
    }
}
