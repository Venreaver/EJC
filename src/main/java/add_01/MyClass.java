package add_01;

import add_01.base.Interface1;
import add_01.base.Interface2;

public class MyClass implements Interface1, Interface2 {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        if (args.length == 0) {
            myClass.m();
        }
    }
}
