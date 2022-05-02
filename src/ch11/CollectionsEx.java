package ch11;

import java.util.*;

/*
* Collections 클래스
*   - Collection 인터페이스를 구현한 클래스들을 다루기위한 메서드들을 제공
*   - 동기화   : synchronized
*   - 변경불가  : ummodifiable
*   - 싱글톤   : singleton
*   - 타입제한  : checked
*   - fill(), copy(), ncopy(), sort() 등
* */
public class CollectionsEx {
    public static void main(String[] args) {
        List list = new ArrayList();
        System.out.println(list);

        Collections.addAll(list, 1, 2, 3, 4, 5);
        System.out.println(list);

        Collections.rotate(list, 2);
        System.out.println(list);

        Collections.swap(list, 0, 2);
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);

        // 사용자정의 정렬
        Collections.sort(list, new MyComparator());
        System.out.println(list);

        // 오름차순
        Collections.sort(list);
        System.out.println(list);

        // 내림차순
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

        // 내림차순
        Collections.reverse(list);
        System.out.println(list);

        int idx = Collections.binarySearch(list, 3);
        System.out.println(idx);

        Comparable max = Collections.max(list);
        System.out.println(max.toString());

        Comparable min = Collections.min(list);
        System.out.println(min);

        Object max1 = Collections.max(list, Collections.reverseOrder());
        System.out.println(max1);

        Collections.fill(list, 9);
        System.out.println(list);

        List<Integer> newList = Collections.nCopies(list.size(), 2);
        System.out.println(newList);

        // 공통요소 존재여부
        boolean disjoint = Collections.disjoint(list, newList);
        System.out.println(disjoint);

        Set set = new HashSet();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(9);

        System.out.println(Collections.disjoint(list, set));

        Collections.copy(list, newList);
        System.out.println(list);
        System.out.println(newList);

        Collections.replaceAll(list, 2, 1);
        System.out.println(list);

        Enumeration e = Collections.enumeration(list);
        ArrayList list2 = Collections.list(e);
        System.out.println(list2);

        // 동기화 처리
        set = Collections.synchronizedSet(set);
        set.add(15);

        // 변경불가 처리
        set = Collections.unmodifiableSet(set);
        //set.add(20);

        // 싱글톤
        Set stSet = Collections.singleton("A");
        //stSet.add("B");

        // 한종류 타입만 저장
        Set set1 = Collections.checkedSet(new HashSet(), String.class);
        set1.add("A");
        //set1.add(5);
    }
}

class MyComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Integer && o2 instanceof Integer) return (int) o1 > (int) o2 ? 1 : -1;
        return -1;
    }
}