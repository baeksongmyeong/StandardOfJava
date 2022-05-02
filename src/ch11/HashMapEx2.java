package ch11;

import java.util.*;

public class HashMapEx2 {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("김자바", 100);
        map.put("이자바", 100);
        map.put("강자바", 80);
        map.put("안자바", 90);

        Set set = map.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            System.out.println(e.getKey() + " " + e.getValue());
        }

        set = map.keySet();
        it = set.iterator();
        while (it.hasNext()) System.out.println(it.next());

        int sum = 0;
        Collection c = map.values();
        it = c.iterator();
        while (it.hasNext()) {sum+=(int)it.next();}
        System.out.println(sum);
        System.out.println((float)sum / set.size());
        System.out.println(Collections.max(c));
        System.out.println(Collections.min(c));
    }
}
