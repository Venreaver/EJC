package classwork.classwork04082017;

public class ThreadNotification {
    private static final Object key = new Object();

    /**
     * example of notify()/notifyAll() and wait() methods cooperation
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; ++i) {
                    System.err.println(i);
                    if (i == 3) {
                        synchronized (key) {
                            key.notifyAll();
                        }
                    }
                    try {
                        Thread.sleep(101);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        System.err.println("start...");
        thread.start();
        // be careful: lock "key" have to be in safe-zone
        synchronized (key) {
            key.wait();
        }
        System.err.println("finish.");
    }
}
