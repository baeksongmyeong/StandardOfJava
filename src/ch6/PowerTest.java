package ch6;

public class PowerTest {
    public static void main(String[] args) {
        int x = 2, n = 5;
        long result = 0;
        for (int i = 1; i <= n; i++) {
            System.out.printf("%d 의 result = %d%n", i, result);
            result = result + power(x, i);
            System.out.printf("%d 의 result = %d%n", i, result);
        }
        System.out.println(result);
    }

    static long power(int x, int n){
        if(n==1){
            System.out.printf("%d ^ %d = %d%n", x, n, x);
            return x;
        }
        long tmp = power(x, n - 1);
        System.out.printf("%d ^ %d = %d%n", x, n, x * tmp);
        return x * tmp;
    }
}
