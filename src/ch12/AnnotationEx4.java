package ch12;

import java.util.Arrays;

/*
* @SafeVarargs : 경고 억제. 메서드의 매개변수중 가변인자가 있는데, 그 타입이 non-reifiable 인 경우(지네릭스처럼 컴파일후 사라지는 타입) unchecked 경고 발생
*                unchecked 경고는 억제되나, varargs 경고는 나타난다.
*                그래서, @SuppressWarnings("varargs") 어노테이션을 함께 써줌으로써 varargs 경고도 억제되게 해야한다.
*
* 컴파일 및 실행방법
* C:\study\StandardOfJava\src
* javac -Xlint -d . ch12/AnnotationEx4.java
* java -cp C:\study\StandardOfJava\src ch12.AnnotationEx4
* */
public class AnnotationEx4 {
    public static void main(String[] args) {
        MyArrayList<String> list = MyArrayList.asList("1", "2", "3");
        System.out.println(list);
    }
}

class MyArrayList<T> {
    T[] arr; //

    @SafeVarargs
    @SuppressWarnings("varargs")
    public MyArrayList(T... arr) {
        this.arr = arr;
    }

    @SafeVarargs
    @SuppressWarnings("varargs")
    public static <T> MyArrayList<T> asList(T... arr) {
        return new MyArrayList<>(arr);
    }

    public String toString(){return Arrays.toString(arr);}
}