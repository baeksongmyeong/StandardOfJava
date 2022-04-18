package ch9;

import java.util.StringJoiner;

/*
* String 의 메서드 중 split, join 을 이용해 문자열을 자르거나, 조합할 수 있다.
* java.util.StringJoiner 클래스의 인스턴스를 이용해 문자열을 조합할 수 있다.
* */
public class StringEx4 {
    public static void main(String[] args) {
        String animals = "dog,cat,bear";
        String[] arr = animals.split(",");

        System.out.println(String.join("-", arr));
        StringJoiner sj = new StringJoiner("/", "[", "]");
        for(String s : arr) {sj.add(s);}
        System.out.println(sj);
    }
}
