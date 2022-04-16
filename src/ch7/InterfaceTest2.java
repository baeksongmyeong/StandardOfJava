package ch7;

class A1 {
    void autoPlay(I i){
        i.play(); // 컴파일이 된다.
    }
}

interface I {
    public abstract void play();
}

class B1 implements I {
    @Override
    public void play() {
        System.out.println("play in B class");
    }
}

class C1 implements I {
    @Override
    public void play() {
        System.out.println("play in C class");
    }
}

public class InterfaceTest2 {
    public static void main(String[] args) {
        A1 a = new A1();
        a.autoPlay(new B1());
        a.autoPlay(new C1());
    }
}
