package tasks.task_02.quack;

public class FakeQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Qwak!");
    }
}
