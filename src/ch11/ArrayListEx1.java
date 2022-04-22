package ch11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
* - ArrayList
* Collection 인터페이스
* : 데이터군을 다루는 클래스들의 공통기능을 모아놓은 인터페이스
*
* List 인터페이스
* : Collection 인터페이스 내에 데이터의 중복을 허용, 순서를 유지하지 않는 데이터구조를 가지는 클래스들의 공통기능을 모아놓은 인터페이스
*
* Set 인터페이스
* : Collection 인터페이스 내에 데이터의 중복을 미허용, 순서를 유지하지 않는 데이터구조를 가지는 클래스들의 공통 기능을 모아놓은 인터페이스
*
* ArrayList 클래스
* : List 인터페이스의 구현체
*   데이터 저장시 배열을 사용
*   배열을 사용하기 때문에 순차적 데이터 저장, 조회에 적합, 역순 데이터 삭제 적합 ( 뒤에 저장된 것부터 차례대로 삭제 )
*   비순차적 데이터 추가, 삭제에 비적합 -> LinkedList 가 적합
*
* - ArrayList 클래스의 주요 메서드
* : ArrayList( null | Collection | int ) : 생성자
*   add( Object | int, Object )
*   addAll( Collection | int Collection )
*   set( int, Object )
*   get( int )
*   remove( Object | int )
*   removeAll( Collection )
*   retainAll( Collection )
*   clear()
*   clone()
*   size()
*   contains( Object )
*   isEmpty()
*   iterator()
*   listIterator( null | int )
*   indexOf( Object )
*   lastIndexOf( Object )
*   subList( int, int )
*   toArray( null | Object[] )
*
*
*
*
* */
public class ArrayListEx1 {

    static ArrayList list1;
    static ArrayList list2;

    public static void main(String[] args) {

        // ArrayList 생성
        list1 = new ArrayList<Object>(10);

        // ArrayList 에 오브젝트 추가
        list1.add(5);
        list1.add(4);
        list1.add(2);
        list1.add(0);
        list1.add(1);
        list1.add(3);

        // 기존 ArrayList 의 부분집합으로 ArrayList 생성
        list2 = new ArrayList<Object>(list1.subList(1, 4));

        print();

        // ArrayList 정렬
        Collections.sort(list1);
        Collections.sort(list2);

        print();

        // 다른 컬렉션과 동일한 인스턴스 또는 값을 포함하고 있는지
        System.out.printf("list1.containsAll(list2) : %b%n", list1.containsAll(list2));

        // ArrayList에 문자열을 추가
        list2.add("B");
        list2.add("C");
        list2.add("A");

        print();

        // ArrayList의 특정 인덱스에 저장된 인스턴스 변경
        list2.set(3, "AA");

        // 다른 Collection 인스턴스와 중복된 요소만 남김
        System.out.printf("list1.retainAll(list2) : %b%n", list1.retainAll(list2));

        print();
        
        // list2 에서 list1 에 포함된 요소는 모두 삭제
        // 배열이니까 삭제는 인덱스 마지막부터 시작해야 문제가 없다.
        for (int i = list2.size() - 1; i > -1; i--) {
            if(list1.contains(list2.get(i))) list2.remove(i);
        }

        print();
    }

    private static void print(){
        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);
        System.out.println();
    }
}
