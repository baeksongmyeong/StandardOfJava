package ch7;

/*
생성자를 private 으로 설정하여, 외부에서는 객체를 만들지 못하게 하고
public 메서드를 제공하여, 하나의 객체를 외부에서 공유하도록 설정하는 방법
 */

class Singleton {

    // 외부에 공유할 객체 1개를 미리 생성
    private static Singleton s = new Singleton();

    // 생성자를 private 으로 설정하여, 외부에서 객체를 만들지 못하게 함
    private Singleton(){}

    // 미리 만들어놓은 객체를 외부에 제공. 외부에서는 이 1개의 객체를 공유
    public static Singleton getSingleton(){
        if(null == s){
            s = new Singleton();
        }
        return s;
    }

}

public class SingletonTest {
    public static void main(String[] args) {
        //Singleton s = new Singleton(); // 생성자가 private 이라 접근 불가
        Singleton s = Singleton.getSingleton(); // static 으로 제공되는 메서드로 미리 만들어진 객체의 주소를 받아온다.
    }
}

