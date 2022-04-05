package ch6;

public class PrimitiveParamEx {
    public static void main(String[] args) {
        Data1 d = new Data1();
        d.x = 10;
        System.out.printf("main() : x = %d%n", d.x);

        change(d.x);
        System.out.printf("After change(d.x)%n");
        System.out.printf("main() : x = %d%n", d.x);
    }

    static void change(int x){
        x = 1000;
        System.out.printf("change() : x = %d%n", x);
    }
}

class Data1 {
    // 인스턴스 변수
    int x;
}