package ch9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
* 자바에서 정규식을 사용하기 위한 인스턴스 생성 및 메서드 사용 순서
* 1. Pattern 인스턴스 생성
* 2. Matcher 인스턴스 생성
* 3. matches() 메서드 실행
* */
public class RegularEx1 {
    public static void main(String[] args) {

        // 정규식을 통해 검증할 문자열 배열. 각 요소들을 검증해서 일치하는 요소들만 뽑아낼 것이다.
        String[] data = {"bat", "baby", "bonus", "cA", "ca", "co", "c.", "c0", "car", "combat", "count", "date", "disc"};
        
        // 1. Pattern 인스턴스 생성
        Pattern p = Pattern.compile("c[a-z]*");

        for (int i = 0; i < data.length; i++) {

            // 2. Matcher 인스턴스 생성
            Matcher m = p.matcher(data[i]);

            // 3. matches() 메서드 실행
            if(m.matches()) System.out.print(data[i] + ", ");

        }

    }
}
