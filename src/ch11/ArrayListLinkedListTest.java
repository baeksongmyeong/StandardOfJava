package ch11;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListLinkedListTest {

    public static void main(String[] args) {
        // ArrayList 생성
        ArrayList arrayList = new ArrayList(2000000);

        // LinkedList 생성
        LinkedList linkedList = new LinkedList();

        // 순차적으로 List 에 인스턴스 add
        System.out.printf("=순차적으로 추가하기=%n");
        System.out.printf("ArrayList  : %d%n", add1(arrayList));
        System.out.printf("LinkedList : %d%n", add1(linkedList));

        System.out.printf("=중간에서 추가하기=%n");
        System.out.printf("ArrayList  : %d%n", add2(arrayList));
        System.out.printf("LinkedList : %d%n", add2(linkedList));

        System.out.printf("=중간에서 삭제하기=%n");
        System.out.printf("ArrayList  : %d%n", remove2(arrayList));
        System.out.printf("LinkedList : %d%n", remove2(linkedList));

        System.out.printf("=순차적으로 삭제하기=%n");
        System.out.printf("ArrayList  : %d%n", remove1(arrayList));
        System.out.printf("LinkedList : %d%n", remove1(linkedList));



    }

    static long add1(List list){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            list.add(i+"");
        }
        return System.currentTimeMillis() - start;
    }

    static long add2(List list){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            list.add(500, "X");
        }
        return System.currentTimeMillis() - start;
    }

    static long remove1(List list) {
        long start = System.currentTimeMillis();
        for (int i = list.size()-1; i >= 0 ; i--) {
            list.remove(i);
        }
        return System.currentTimeMillis() - start;
    }

    static long remove2(List list){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            list.remove(i);
        }
        return System.currentTimeMillis() - start;
    }
}
