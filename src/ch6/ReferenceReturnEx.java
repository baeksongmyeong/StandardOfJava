package ch6;

public class ReferenceReturnEx {
    public static void main(String[] args) {
        Data3 d1 = new Data3();
        d1.x = 10;

        // 참조형을 메서드의 반환타입으로 설정
        Data3 d2 = copy(d1);

        System.out.println(d1.x);
        System.out.println(d2.x);
    }

    static Data3 copy(Data3 d) {
        Data3 tmp = new Data3();
        tmp.x = d.x;
        return tmp;
    }
}

class Data3 {
    int x;
}
