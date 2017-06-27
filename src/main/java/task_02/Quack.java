package task_02;

public class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Кря-Кря!");
    }
}
