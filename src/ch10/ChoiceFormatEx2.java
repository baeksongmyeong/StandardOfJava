package ch10;

import java.awt.*;
import java.text.ChoiceFormat;

/*
* 패턴 문자열을 사용하는 ChoiceFormater 인스턴스
* 패턴 문자열의 구분자는 #, < 2가지를 제공
*   # : 경계값을 범위에 포함
*   < : 경계값을 범위에서 제외
* 패턴 문자열 형태
*   경계값 #또는< 변환값 ( 90#A )
* 패턴 문자열 내에서 경계값, 변환값의 쌍은 | 기호로 구분
*   60#D|70#D|80<C|90#A
* */
public class ChoiceFormatEx2 {
    public static void main(String[] args) {
        String pattern =
                "60#D" + "|" +
                "70#C" + "|" +
                "80<B" + "|" +
                "90#A"
                ;

        ChoiceFormat cf = new ChoiceFormat(pattern);

        int[] scores = {91, 90, 80, 88, 70, 52, 60};
        for (int score : scores) {
            System.out.printf("%3d : %s%n", score, cf.format(score));
        }



    }
}
