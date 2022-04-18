package ch9;

import java.util.ArrayList;
import java.util.Arrays;

/*
* 공변반환타입 : 메서드를 오버라이드시 기존 메서드의 반환타입을 해당 반환타입을 상속한 클래스타입으로 변경하도록 허용해주는것
* 배열복사 1 : clone() 메서드로 가능. 공변반환타입이 적용된 오버라이드된 clone() 메서드이다.
* 배열복사 2 : System.arraycopy() 메서드로 가능.
* */

public class CloneEx2 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] arrClone = arr.clone(); // 배열 클래스는 이미 공변반환타입이 적용된 clone() 메서드가 오버라이드 되어 있다.
        arrClone[0] = 6;

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arrClone));

        // 배열을 복사하는 다른 방법. System.arraycopy() 메서드
        int[] arrClone2 = new int[arr.length];
        System.arraycopy(arr, 0, arrClone2, 0, arr.length);
        arrClone2[0] = 3;
        System.out.println(Arrays.toString(arrClone2));

        ArrayList list = new ArrayList();
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        ArrayList listClone = (ArrayList) list.clone();

        // 인스턴스는 서로 다른 것
        System.out.println(System.identityHashCode(list));
        System.out.println(System.identityHashCode(listClone));
        
        // 인스턴스 내 값(참조변수값)은 동일
        for (Object o : list) {System.out.print(o + ", ");}
        System.out.println();
        for (Object o : listClone) {System.out.print(o + ", ");}
    }
}
