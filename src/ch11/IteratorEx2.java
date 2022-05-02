package ch11;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorEx2 {
    public static void main(String[] args) {
        ArrayList<Object> original = new ArrayList<>(10);
        ArrayList<Object> copy1 = new ArrayList<>(10);
        ArrayList<Object> copy2 = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            original.add(i+"");
        }

        Iterator<Object> it = original.iterator();
        while (it.hasNext()) {
            copy1.add(it.next());
        }

        System.out.println("=Original 에서 copy1 으로 복사=");
        System.out.println(original);
        System.out.println(copy1);

        System.out.println();

        it = original.iterator();
        while (it.hasNext()) {
            copy2.add(it.next());
            it.remove();
        }

        System.out.println("=Original 에서 copy1 으로 이동=");
        System.out.println(original);
        System.out.println(copy1);
    }
}
