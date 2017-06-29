package task_02.quack;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Пик-Пик!");
    }
}
