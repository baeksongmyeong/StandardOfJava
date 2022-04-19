package ch9;

import java.util.StringTokenizer;

/*
* StringTokenizer 는 문자열을 입력된 구분자로 잘라서 토큰들로 저장해놓는다.
* 제한사항은 구분자가 한문자만 된다는 것이다
* 만약 구분자가 ",|>" 로 입력되더라도, ,|> 를 하나의 구분자로 보는것이 아니라, , | > 를 각각의 구분자로 판단하여, 총 3개의 구분자로 문자열을 잘라낸다.
* 생성자 : StringTokenizer(원본문자열, 구분자, 구분자를 토큰에 포함시킬지 여부)
* 토큰이 있는지 확인 : hasMoreTokens()
* 다음 토큰을 가져오기 : nextToken()
* */
public class StringTokenizerEx1 {
    public static void main(String[] args) {

        String source = "100, 200, 300, 400";
        source.replace(" ", "");
    
        // StringTokenizer 인스턴스 생성
        StringTokenizer st = new StringTokenizer(source, ",");

        // StringTokenizer 인스턴스에 다음 토큰이 있는지 확인하고, 있으면 출력
        while (st.hasMoreTokens()){
            System.out.println("[" + st.nextToken() + "]");
        }

    }
}
