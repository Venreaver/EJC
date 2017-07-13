package additional.add_02;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List list = new LinkedList();
        String str = "String";
        list.add("String");
        list.add("String");
        list.add(5);
        list.add("String");
        list.add(str);
        list.add("String");
        list.add(5);
        list.add(5);
        list.add("String");
        list.add(10L);
        list.add("String");
        list.add("CollisionCat");
        System.out.println(list);

        // NOT GOOD: In foreach it.hasNext is calling after iteration => ConcurrentModificationException
        for (Object obj : list) {
            if (obj.equals("String")) {
                list.remove(obj);
            }
        }

        // NOT GOOD: can skip element
        for (int i = 0; i < list.size(); ++i) {
            list.remove("String");
        }

        // NOT GOOD: can skip element
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i).equals("String")) {
                list.remove(list.get(i));
            }
        }

        // GOOD
        Iterator each = list.iterator();
        while (each.hasNext()) {
            if (each.next().equals("String")) {
                each.remove();
            }
        }

        // GOOD
        list.removeIf(o -> o.equals("String"));
        System.out.println(list);
    }
}
