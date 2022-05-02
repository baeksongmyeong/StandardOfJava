package ch11;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx1 {
    public static void main(String[] args) {
        Object[] objArr = new Object[]{
                "1",
                new Integer(1),
                "2",
                "2",
                "3",
                "3",
                "4",
                "4",
                "4",
        };

        Set set = new HashSet<Object>();

        for (Object o : objArr) {
            if(!set.add(o)) System.out.println("중복값 : " + o);;
        }

        System.out.println(set);


    }
}
