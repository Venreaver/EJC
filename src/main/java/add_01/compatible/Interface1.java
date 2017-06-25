package add_01.compatible;

public interface Interface1 {
    default void m() {
        System.out.println("hello interface 1");
    }
}
