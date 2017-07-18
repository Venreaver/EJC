package classwork.classwork17072017;

import java.io.IOException;

/**
 * <p>Class implements rabbit's carrot dinner.
 * <p>Rabbit can eat carrot until any key is entered in console.
 * <p>Class shows how volatile variables can be used.
 */
public class CarrotDinner {
    volatile static boolean isEating = true;

    public static void main(String[] args) {
        new ThreadFlagStopEating().start();
        new ThreadFlagEating().start();
    }

    /**
     * set <code>isEating</code> variable to <code>false</code>
     * if any key is entered in console
     */
    public static class ThreadFlagStopEating extends Thread {
        @Override
        public void run() {
            try {
                int k = System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            isEating = false;
            System.err.println("isEating is false");
        }
    }

    /**
     * rabbit is eating carrot if <code>isEating</code> variable is <code>true</code>
     */
    public static class ThreadFlagEating extends Thread {
        @Override
        public void run() {
            System.err.println("Start dinner");
            while (isEating) {
                System.err.println("Rabbit is eating Carrot");
            }
            System.err.println("Dinner is canceled");
        }
    }
}
