package classwork.classwork17072017;

/**
 * <p>Class implements jamon shop with only one client.
 * <p>The client can buy several portions of the jamon
 * <p>Class shows how synchronized can be used.
 */
public class JamonShop {
    private static int clientCash = 500;

    public static void main(String[] args) {
        buyJamon(7);
    }

    /**
     * <p>Start the number of threads equal to the amount of portions of the jamon
     * <p>Run method buyOneJamon in each thread.
     *
     * @param amount - count of portions of the jamon
     */
    private static void buyJamon(int amount) {
        for (int i = 0; i < amount; i++) {
            new Thread(JamonShop::buyOneJamon).start();
        }
    }

    /**
     * synchronized method implements buying one portion of jamon
     */
    private static synchronized void buyOneJamon() {
        int jamonPrice = 100;
        if (clientCash >= jamonPrice) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clientCash -= jamonPrice;
            System.err.println("Done. Our cash is " + clientCash);
        } else {
            System.err.println("Not enough money");
        }
    }
}
