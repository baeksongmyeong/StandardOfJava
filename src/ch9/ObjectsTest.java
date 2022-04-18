package ch9;

/*
* Objects 클래스는 Object 클래스에 추가적인 기능을 제공하기 위한 클래스이다.
* 주로 null 체크가 들어가 있다.
* equals(Object A, Object B)
* deepEquals(Object A, Object B)
* isNull(Object A)
* nonNull(Object A)
* requiredNonNull(Object A, String message)
* Objects.hashCode(Object A)
* Objects.toString(Object A)
* Objects.toString(Object A, String value)
* Objects.compare(Object A, Object B, Comparator C)
* */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class ObjectsTest {
    public static void main(String[] args) {
        String[][] str2D   = new String[][]{ {"aaa", "bbb"}, {"AAA", "BBB"}};
        String[][] str2D_2 = new String[][]{ {"aaa", "bbb"}, {"AAA", "BBB"}};

        System.out.print("str2D  ={");
        for (String[] strings : str2D) System.out.printf(Arrays.toString(strings));
        System.out.println("}");

        System.out.print("str2D_2={");
        for (String[] strings : str2D_2) System.out.printf(Arrays.toString(strings));
        System.out.println("}");

        // Objects.equals(Object A, Object B)
        System.out.println("Objects.equals(str2D, str2D_2)="+Objects.equals(str2D, str2D_2));

        // Objects.deepEquals(Object A, Object B)
        System.out.println("Objects.deepEquals(str2D, str2D_2)="+Objects.deepEquals(str2D, str2D_2));

        // Objects.isNull(Object A)
        System.out.println("Objects.isNull(null)="+Objects.isNull(null));

        // Objects.nonNull(Object A)
        System.out.println("Objects.nonNull(null)="+Objects.nonNull(null));

        // Objects.requireNonNull(Object A, String message)
        try {
            System.out.println("Objects.requireNonNull(null, \"오브젝트가 null 입니다.\")="+Objects.requireNonNull(null, "오브젝트가 null 입니다."));
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

        // Objects.hashCode(Object A)
        System.out.println(Objects.hashCode(null)); // null 이면 0 반환

        // Objects.toString(Object A)
        System.out.println(Objects.toString(null));

        // Objects.toString(Object A, String value)
        System.out.println(Objects.toString(null, "오브젝트가 null 이라 기본문자열을 반환합니다."));

        // Comparator 인스턴스 참조
        Comparator<String> c = String.CASE_INSENSITIVE_ORDER;

        // Objects.compare(Object A, Object B, Comparator C)
        System.out.println("Objects.compare(\"aa\", \"bb\", c)=" + Objects.compare("aa", "bb", c));
        System.out.println("Objects.compare(\"bb\", \"aa\", c)=" + Objects.compare("bb", "aa", c));
        System.out.println("Objects.compare(\"ab\", \"AB\", c)=" + Objects.compare("ab", "AB", c));


    }
}
