package ch6;

public class OverloadingTest {
    public static void main(String[] args) {
        MyMath3 mm = new MyMath3();
        System.out.println("mm.add(3,3) : " + mm.add(3,3));
        System.out.println("mm.add(3L,3) : " + mm.add(3L,3));
        System.out.println("mm.add(3,3L) : " + mm.add(3,3L));
        System.out.println("mm.add(3L,3L) : " + mm.add(3L,3L));

        int[] arr = {100, 200, 300};
        System.out.println("mm.add(int[]) : " + mm.add(arr));
    }
}

class MyMath3 {
    int add(int a, int b){
        System.out.println("int add(int a, int b) - ");
        return a + b;
    }

    // 리턴타입이 다른것으로는 오버로딩이 안됨.
//    long add(int a, int b){
//        System.out.println("add(int a, int b) - ");
//        return a + b;
//    }

    long add(int a, long b){
        System.out.println("add(int a, long b) - ");
        return a + b; // 자동 형변환. 큰 타입으로 변환됨
    }
    
    long add(long a, int b){
        System.out.println("add(long a, int b) - ");
        return a + b;
    }

    long add(long a, long b){
        System.out.println("add(long a, long b) - ");
        return a + b;
    }

    int add(int[] a){
        System.out.println("add(int[] a) - ");
        int result = 0;
        for(int n : a) result += n;
        return result;
    }



}
