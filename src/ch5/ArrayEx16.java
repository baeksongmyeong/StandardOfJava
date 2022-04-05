package ch5;

public class ArrayEx16 {
    public static void main(String[] args) {
        
        // main 메서드의 String 배열 매개변수 사용
        System.out.println("매개변수의 개수 : " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "] : " + "\"" + args[i] + "\"");
        }
    }
}
