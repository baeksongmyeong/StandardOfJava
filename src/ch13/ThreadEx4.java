package ch13;

/*
* '-' 를 출력하는 작업
* '|' 를 출력하는 작업
* 하나의 쓰레드(메인 쓰레드)로 처리했을때 시간
* */
public class ThreadEx4 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("-"));
        }
        System.out.printf("%n소요시간1) %d%n", (System.currentTimeMillis() - startTime));
        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("|"));
        }
        System.out.printf("%n소요시간2) %d", (System.currentTimeMillis() - startTime));
    }
}
