package ch11;

import java.util.Arrays;
import java.util.Comparator;

/*
* Comparable : 기본 정렬을 구현하는데 사용되는 인터페이스
*   - compareTo( Object ) 메서드 구현필요
*   - 같으면 0, 작으면 음수, 크면 양수 리턴
* 
* Comparator : 기본 정렬이 아닌, 사용자가 정의한 다른 방식의 정렬을 구현하는데 사용되는 인터페이스
*   - compare( Object, Object ) 메서드 구현 필요
*   - 같으면 0, 작으면 음수, 크면 양수 리턴
*
* Comparator 를 만드는 순서
*   1. 신규 클래스를 만들고 Comparator 를 implement 한다.
*   2. int Compare(Object, Object) 메서드를 오버라이드한다.
*   3. Object 2개를 Comparable 타입으로 형변환한다.
*   4. Object 의 CompareTo 메서드를 호출하되 내가 원하는 리턴값을 생성한다.
*
* Arrays.sort( Object[], Comparator )
* */
public class ComparatorEx {
    public static void main(String[] args) {
        String[] strArr = new String[]{
                "cat",
                "Dog",
                "lion",
                "tiger"
        };

        System.out.println(Arrays.toString(strArr));

        // String 클래스에 미리 구현되어 있는 Comparable 을 그대로 사용하여, 배열을 정렬
        Arrays.sort(strArr);
        System.out.println(Arrays.toString(strArr));
        
        // String 클래스에서 상수로 제공되는 Comparator 적용
        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(strArr));

        new ArraysEx();

        // 내가 만든 Comparator 적용
        Arrays.sort(strArr, new Descending());
        System.out.println(Arrays.toString(strArr));
    }
}

class Descending implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Comparable && o2 instanceof Comparable) {
            Comparable c1 = (Comparable) o1;
            Comparable c2 = (Comparable) o2;
            return c1.compareTo(c2) * -1;
        }
        return -1;
    }
}