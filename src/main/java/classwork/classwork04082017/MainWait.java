package classwork.classwork04082017;

public class MainWait {
    private static final Object key = new Object();

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
//                synchronized (key) {
//                    key.notifyAll();
//                }
            }
        });
        System.err.println("start...");
        thread.start();
        // нельзя испольозовать wait и notify в небезопасных частях кода (могут обратиться сразу несколько потоков к key)
        synchronized (key) {
            key.wait();
        }
        System.err.println("finish.");
    }
}
