package task_02.quackbehaviors;

public class FakeQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("КрЫ-КрЫ!");
    }
}
