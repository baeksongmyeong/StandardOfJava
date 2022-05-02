package ch11;

import java.util.*;

public class HashSetLotto {
    public static void main(String[] args) {
        Set set = new HashSet<Object>();

        // 1 ~ 45 까지의 숫자를 5개만 HashSet 에 저장
        while (set.size() < 6) {set.add((int) (Math.random() * 45) + 1);}
        System.out.println("set = " + set);

        // HashSet 에 저장된 숫자를 정렬
        //Collections.sort(new LinkedList<Object>(set)); // 이 형태는 안됨. 지네릭스에서 오류 발생
        List list = new LinkedList(set);
        Collections.sort(list);
        System.out.println("list = " + list);
    }
}
