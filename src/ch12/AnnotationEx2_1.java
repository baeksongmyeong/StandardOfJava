package ch12;

import java.util.ArrayList;

public class AnnotationEx2_1 {
    public static void main(String[] args) {
        Object obj = new Object();
        @SuppressWarnings("unchecked")
        ArrayList<Object> list1 = new ArrayList(); // 이 형태로 선언되면 @SuppressWarnings("unchecked") 가 작동
        ArrayList         list2 = new ArrayList(); // 이 형태로 선언되면 작동 안함. 경고 메시지가 발생
        list1.add(obj);
    }
}
