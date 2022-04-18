package ch7;

public class InnerEx3 {

    // 인스턴스 멤버 변수
    private int outerIv = 0;

    // static 멤버 변수
    static int outerCv = 0;

    // 인스턴스 내부 클래스
    class InstanceInner {
        int iiv = outerIv;  // 인스턴스 내부 클래스는 외부 클래스의 인스턴스 멤버를 외부 클래스의 인스턴스 없이도 참조할 수 있다.
        int iiv2 = outerCv; // 인스턴스 내부 클래스는 외부 클래스의 static 멤버를 외부 클래스의 인스턴스 없이도 참조할 수 있다.
    }
    
    // static 내부 클래스
    static class StaticInner {
        //int siv = outerIv; // static 내부 클래스는 외부 클래스의 인스턴스 멤버를 외부 클래스의 인스턴스 없이는 참조할 수 없다.
        int siv2 = outerCv;  // static 내부 클래스는 외부 클래스의 인스턴스 멤버를 외부 클래스의 인스턴스 없이도 참조할 수 있다.
    }

    // 인스턴스 메서드
    void myMethod(){
        int lv = 0;
        final int LV = 0;
        
        // 지역 내부 클래스
        class LocalInner{
            int liv = outerIv;
            int liv2 = outerCv;
            int liv3 = lv;
            int liv4 = LV;
        }
    }


}
