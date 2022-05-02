package ch11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
* Iterator 인터페이스
*
* Collection 인터페이스에 iterator() 메서드가 있으며 Iterator 인터페이스의 구현체를 리턴해야함
* 따라서, List, Set 인터페이스의 구현체는 모두 iterator() 메서드가 구현되어있음
* 
* iterator() : Iterator 구현체 반환
* hasNext() : Iterator 내 다음 요소 반환
* remove() : Iterator 내 현재 참조하고 있는 요소 삭제
*
* */
public class IteratorEx1 {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        Iterator it = list.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
