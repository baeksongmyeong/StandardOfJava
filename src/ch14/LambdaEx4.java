package ch14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class LambdaEx4 {
    public static void main(String[] args) {
        // ArrayList 인스턴스 생성
        ArrayList<Integer> list = new ArrayList();
        
        // 0 부터 9 까지 ArrayList 에 추가
        for (int i = 0; i < 10; i++) list.add(i);
        
        // Iterator 사용. ArrayList 의 모든요소 출력
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) System.out.print(it.next());

        // ForEach 사용. ArrayList 의 모든요소 출력
        System.out.printf("%n");
        list.forEach((i) -> {System.out.printf("%d, ",i);});

        // ArrayList 에서 2의 배수 또는 3의 배수인 요소 제거
        list.removeIf((i) -> i % 2 == 0 || i % 3 == 0);

        // ForEach 사용. ArrayList 의 모든요소 출력
        System.out.printf("%n");
        list.forEach((i) -> {System.out.printf("%d, ",i);});

        // ArrayList 의 모든 요소에 10을 곱함
        list.replaceAll((i)->{return i * 10;});

        // ForEach 사용. ArrayList 의 모든요소 출력
        System.out.printf("%n");
        list.forEach((i) -> {System.out.printf("%d, ",i);});

        // HashMap 인스턴스 생성
        HashMap<Integer, Integer> map = new HashMap<>();

        // 1부터 4까지의 키와 값을 HashMap 인스턴스에 추가
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);

        // HashMap 의 모든 요소를 출력
        System.out.printf("%n");
        map.forEach((k,v)->{System.out.printf("{키 : %d, 값 : %d}, ", k, v);});
    }
}
