package ch9;

import java.util.StringTokenizer;

/*
* String.split() 은 자른 문자열이 공백인 경우, 사용한다.
* StringTokenizer 는 자른 문자열이 공백인 경우, 버린다.
* */
public class StringTokenizerEx5 {
    public static void main(String[] args) {
        String data = "100,,,200,300";

        String[] result = data.split(",");
        for (String s : result) {System.out.print(s + "|");}

        System.out.println();

        StringTokenizer st = new StringTokenizer(data, ",");
        int tokenount = st.countTokens();
        while (st.hasMoreTokens()){System.out.print(st.nextToken() + "|");}

        System.out.println();

        System.out.printf("split count : %d%n", result.length);
        System.out.printf("token count : %d%n", tokenount);
    }
}
