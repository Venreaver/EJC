package task_02.quackbehaviors;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Кря-Кря!");
    }
}
