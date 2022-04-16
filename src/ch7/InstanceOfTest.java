package ch7;

/*
instanceof 연산자는 다형성이라는 것이 존재하는 자바 특성상
참조변수가 가리키는 인스턴스가 조상인지, 자손인지 알 수 없으므로, 이를 판단하기 위해 사용한다.
조상클래스와 연산시에도 true 가 반환된다.
 */
public class InstanceOfTest {
    public static void main(String[] args) {
        FireEngine fe = new FireEngine();

        if(fe instanceof FireEngine){
            System.out.println("This is a FireEngine instance.");
        }

        if(fe instanceof Car){
            System.out.println("This is a Car instance.");
        }

        if(fe instanceof Object){
            System.out.println("This is a Object instance.");
        }
    }
}
