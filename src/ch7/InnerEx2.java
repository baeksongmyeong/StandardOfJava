package ch7;

public class InnerEx2 {
    
    // 내부 인스턴스 클래스
    class InstanceInner {}
    
    // 내부 static 클래스
    static class StaticInner {}

    // 인스턴스 멤버간에는 서로 직접 접근이 가능하다. ( 인스턴스 변수 iv - 인스턴스 내부 클래스 )
    InstanceInner iv = new InstanceInner();

    // static 멤버간에는 서로 직접 접근이 가능하다. ( static 변수 cv - static 내부 클래스 )
    static StaticInner cv = new StaticInner();

    // static 메서드에서 내부 클래스 접근
    static void staticMethod() {

        // static 멤버는 인스턴스 멤버에 직접 접근할 수 없다. ( static 메서드 - 인스턴스 내부 클래스 )
        // InstanceInner obj1 = new InstanceInner();

        // static 멤버에서 인스턴스 멤버에 접근하려면 외부 클래스의 인스턴스를 생성후에 접근할 수 있다. ( static 메서드 - 외부 클래스의 인스턴스 - 인스턴스 내부 클래스 )
        InnerEx2 outer = new InnerEx2();
        InstanceInner obj1 = outer.new InstanceInner();

        // static 멤버간에는 서로 직접 접근이 가능하다. ( static 메서드 - static 내부 클래스 )
        StaticInner obj2 = new StaticInner();
    }
    
    // 인스턴스 메서드에서 내부 클래스 접근
    void instanceMethod(){

        // 인스턴스 멤버는 인스턴스 뿐만 아니라 static 멤버에도 직접 접근할 수 있다. ( 인스턴스 메서드 - 인스턴스 내부 클래스 OR static 내부 클래스 )
        InstanceInner obj1 = new InstanceInner();
        StaticInner obj2 = new StaticInner();

        // 다른 메서드 내에 지역 내부 클래스는 외부에서 접근할 수 없다.
        //new LocalInner();

    }

    // 인스턴스 메서드에서 지역 내부 클래스 접근
    void myMethod(){
        
        // 지역 내부 클래스
        class LocalInner { }

        // 메서드 내에 지역 내부 클래스는 해당 메서드내에서 직접 접근할 수 있다.
        LocalInner lv = new LocalInner();
    }
    
}
