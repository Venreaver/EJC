package task_02;

public class Squeak implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Пик-Пик!");
    }
}
