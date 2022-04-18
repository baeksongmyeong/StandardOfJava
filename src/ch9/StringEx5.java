package ch9;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.StringJoiner;

/*
* 서로 다른 문자 인코딩을 사용하는 컴퓨터간에 문자열을 주고받기 위해서는 자신에게 맞는 문자 인코딩으로 문자열을 변환해야 한다.
* getByte(String 문자셋명) 메서드로 원하는 문자 인코딩으로 문자열을 변환할 수 있다.
* */
public class StringEx5 {
    public static void main(String[] args) {
        String str = "가";
        byte[] bArr = null;
        byte[] bArr2 = null;

        try { bArr = str.getBytes("UTF-8"); } catch (UnsupportedEncodingException e) {}
        try { bArr2 = str.getBytes("CP949"); } catch (UnsupportedEncodingException e) {}

        System.out.println("UTF-8:" + joinByteArr(bArr));
        System.out.println("CP949:" + joinByteArr(bArr2));

        String s1 = "";
        String s2 = "";

        try { s1 = new String(bArr, "UTF-8"); } catch (UnsupportedEncodingException e) {}
        try { s2 = new String(bArr2, "CP949"); } catch (UnsupportedEncodingException e) {}

        System.out.println("UTF-8:" + s1);
        System.out.println("CP949:" + s2);
    }

    static String joinByteArr(byte[] bArr){
        StringJoiner sj = new StringJoiner(":", "[", "]");
        for(byte b : bArr){
            sj.add(String.format("%02X", b));
        }
        return sj.toString();
    }
}
