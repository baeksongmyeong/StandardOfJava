package ch11;

import java.util.ArrayList;
import java.util.Iterator;

/*
* 전문 자르는 방식과 비슷한 예제
* */
public class ArrayListEx2 {
    public static void main(String[] args) {
        final int LIMIT = 10;
        String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
        int length = source.length();

        ArrayList<String> list = new ArrayList<>(length / LIMIT + 10);

        for (int i = 0; i < length; i += LIMIT) {
            if( i + LIMIT < length){
                list.add(source.substring(i, i + LIMIT));
            }
            else{
                list.add(source.substring(i));
            }
        }

        Iterator<String> it = list.iterator();
        while (it.hasNext()) System.out.println(it.next());
    }
}
