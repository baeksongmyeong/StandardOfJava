package ch11;

import java.util.ArrayList;
import java.util.ListIterator;

/*
* ListIterator 는 Iterator 를 개선한 인터페이스
*
* Iterator 는 단방향 접근만 가능하나, ListIterator 는 양방향 접근이 가능
* List 인터페이스를 구현한 클래스에만 적용가능
* Set 인터페이스를 구현한 클래스에는 적용 불가
*
* listIterator() : ListIterator 구현체 반환
* hasNext() : 순방향 다음 요소 존재여부
* next() : 순방향 다음 요소 가져오기
* hasPrevious() : 역방향 다음 요소 존재여부
* previous() : 역방향 다음 요소 가져오기
* */
public class ListIteratorEx1 {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        // 순방향
        ListIterator<Object> it = list.listIterator();
        while(it.hasNext()) System.out.print(it.next());

        System.out.println();

        // 역방향
        while (it.hasPrevious()) System.out.print(it.previous());
    }
}
