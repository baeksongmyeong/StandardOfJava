package ch6;

public class ReferenceParamEx2 {
    public static void main(String[] args) {
        int[] x = new int[]{10};
        System.out.printf("main() : x[0] = %d%n", x[0]);
        change(x);
        System.out.printf("After change(int[] x)%n");
        System.out.printf("main() : x[0] = %d%n", x[0]);
    }

    static void change(int[] x){
        x[0] = 1000;
        System.out.printf("change() : x[0] = %d%n", x[0]);
    }
}
