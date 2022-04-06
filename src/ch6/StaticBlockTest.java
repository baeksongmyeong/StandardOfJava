package ch6;

public class StaticBlockTest {

    /*
    클래스 초기화 블록에서 클래스 변수를 접근할 수 있다.
    인스턴스 변수는 접근할 수 없다.
     */

    // 클래스 변수
    static int[] arr = new int[10];

    // 클래스 초기화 블록
    static {
        System.out.println("클래스 초기화 블록");
        for (int i = 0; i < arr.length; i++) { // 클래스 변수를 접근할 수 있다.
            arr[i] = (int)(Math.random() * 10) + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println("main 메서드");
        for (int i : arr) System.out.println(i);
    }
}
