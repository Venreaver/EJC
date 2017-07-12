package task_02.fly;

/**
 * Abstraction of flying behavior
 *
 * @author Irina Vasileva
 */
public interface FlyBehavior {
    /**
     * Creates current speed for specific fly behavior
     *
     * @return int current speed
     */
    int fly();

    /**
     * Shows a specific fly behavior
     */
    void displayFlyBehavior();
}
