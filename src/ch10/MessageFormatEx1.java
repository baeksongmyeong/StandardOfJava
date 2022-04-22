package ch10;

import java.text.MessageFormat;

/*
* MessageFormat 클래스는 리포트와 같은 기능을 제공한다.
* 문자열 내에 {배열의 인덱스번호} 형태의 문자열이 들어있으면, 해당 인덱스번호로 배열의 값을 찾아와 넣어주는 형태이다.
* 배열의 인덱스번호를 사용하기 때문에 번호가 중복되거나 번호 순서는 영향이 없다.
*
* */
public class MessageFormatEx1 {
    public static void main(String[] args) {
        String msg = "Name : {0} \nTel : {1} \nAge : {2} \nBirthday : {3} \nAll : {0} - {1} - {2} - {3}";
        Object[] arg = {"이자바", "02-123-1234", "27", "07-09"};
        String result = MessageFormat.format(msg, arg);
        System.out.println(result);
    }
}
