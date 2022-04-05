package ch6;

public class ReferenceParamEx {
    public static void main(String[] args) {
        Data2 d = new Data2();
        d.x = 10;
        System.out.printf("main() : x = %d%n", d.x);

        change(d);

        System.out.printf("After Change(d)%n");
        System.out.printf("main() : x = %d%n", d.x);
    }

    static void change(Data2 d){
        d.x = 1000;
        System.out.printf("change() : x = %d%n", d.x);
    }

}

class Data2 {
    int x;
}
