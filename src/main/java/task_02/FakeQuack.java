package task_02;

public class FakeQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("КрЫ-КрЫ!");
    }
}
