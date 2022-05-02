package ch12;

/*
* Annotation : 코드 자신과는 관계 없고, 다른 프로그램에게 정보를 제공하여, 그에 맞는 행동을 취하게 하는 명령어
*   - JDK 제공 Annotation
*       - 1. 표준 어노테이션 : 컴파일러에게 정보를 제공하여, 그에 해당하는 행동을 취하게 한다. 보통 코드 검증 및 및 경고메시지 제어를 하게 된다.
*
*           - 1. @Override               : 에러 발생. 조상 클래스에 있는 메서드인지 확인 후, 컴파일 시 에러 발생
*           - 2. @Deprecated             : 경고 생성. 사용하지 않는 멤버로 설정. 이 멤버를 사용하면, 경고 메시지 발생시킴
*           - 3. @FunctionalInterface    : 경고 생성. 함수형 인터페이스 문법에 맞는지 확인 후, 경고 메시지 발생시킴
*           - 4. @SuppressWarnings       : 경고 억제.
*                   - @SuppressWarnings("deprecation")   : @Deprecated 가 붙은 멤버를 사용한 경우
*                   - @SuppressWarnings("unchecked")     : 지네릭스를 쓰는 멤버인데 타입변수를 대입하지 않은 경우
*                   - @SuppressWarnings("rawtypes")      : 지네릭스를 사용하지 않은 경우
*                   - @SuppressWarnings("varargs")       : 가변인자의 타입이 지네릭 타입인 경우
*           - 5. @SafeVarargs           : 경고 억제. 메서드의 매개변수중 가변인자가 있는데, 그 타입이 non-reifiable 인 경우(지네릭스처럼 컴파일후 사라지는 타입) unchecked 경고 발생
*                                         @SuppressedWarnings("unchecked") 로 경고 억제가 가능하나, 선언부, 호출부 모두 넣어줘야 함.
*                                         @SafeVarargs 는 선언부에만 넣어주면, 호출부도 자동으로 경고가 억제됨.
*
*       - 2. 메타 어노테이션 : 기존 또는 신규 어노테이션에 대한 특성을 부여할때 사용하는 어노테이션이다.
*
*           - 1. @Target() : 기존 또는 신규 어노테이션을 사용할 수 있는 범위를 한정지을때 사용하는 어노테이션
*                            사용할 수 있는 값들은 ElementType 열거형이 제공하는 값으로 한정된다.
*               - ElementType.TYPE           : 클래스, 인터페이스, enum 을 정의할 때, 그 위에 해당 어노테이션 사용가능 (타입)
*               - ElementType.TYPE_USE       : 클래스, 인터페이스, enum 을 사용할 때, 그 위에 해당 어노테이션 사용가능 (타입사용)
*               - ElementType.TYPE_PARAMETER : 타입 매개변수를 사용할 때, 그 위에 해당 어노테이션 사용가능
*               - ElementType.PACKAGE        : 패키지를 선언할 때, 그 위에 해당 어노테이션 사용가능
*               - ElementType.CONSTRUCTOR    : 생성자를 선언할 때, 그 위에 해당 어노테이션 사용가능
*               - ElementType.METHOD         : 메서드를 선언할 때, 그 위에 해당 어노테이션 사용가능
*               - ElementType.FIELD          : 멤버변수, enum상수를 선언할 때 , 그 위에 해당 어노테이션 사용가능 (필드)
*               - ElementType.LOCAL_VARIABLE : 지역변수를 선언할 때 , 그 위에 해당 어노테이션 사용가능
*
*           - 2. @Retention() : 기존 또는 신규 어노테이션이 프로그램 컴파일부터 실행까지 단계중 언제까지 기능을 제공할지 범위를 한정지을때 사용하는 어노테이션
*                               사용할 수 있는 값들은 RetentionPolicy 열거형이 제공하는 값으로 한정된다.
*               - RetentionPolicy.SOURCE  : 컴파일까지만 유효. 소스파일에만 존재. 컴파일 후 결과 파일인 *.class 파일에서는 제외됨.
*               - RetentionPolicy.CLASS   : 클래스 파일에 존재. 하지만 클래스로더에 의해 클래스가 로딩될 때, 어노테이션 정보는 제외됨.
*               - RetentionPolicy.RUNTIME : 클래스 파일에 존재. 클래스 로더에 의해 클래스가 로딩될 때, 어노테이션 정보도 포함됨.
*                                           실행중 클래스 인스턴스에서 어노테이션의 정보를 참조할 수 있음
* 
*           - 3. @Documented : 어노테이션에 대한 정보가 javadoc 으로 작성한 문서에 포함되도록 설정
*           - 4. @Inherited : 이 어노테이션이 붙은 어노테이션 A를 사용한 클래스를 상속시, 어노테이션 A도 상속됨
*           - 5. @Repetable(어노테이션.class) : 어노테이션을 반복해서 사용할 수 있도록 설정
*           - 6. @Native : 네이티브 메서드에 의해 참조되는 상수필드임을 알림
*                          네이티브 메서드란, OS 에서 제공하는 메서드와 연결되는 메서드이다.
*                          선언부만 존재하며, 구현부는 없고, 매개변수를 넣을 수 없다.
*                          native int count(); 와 같은 형태로 선언하며, OS 메서드와의 연결은 JNI 가 담당한다.
*
*   - 그 외 프로그램 제공 Annotation
*       - 제공하는 프로그램별로 기능이 정의되어 있다.
* */

class Parent {
    void parentMethod() { }
}
public class AnnotationEx1 extends Parent {
    // @Override 어노테이션이 있는 경우, 조상에 해당 메서드가 없으면 컴파일 에러를 발생시킴
    @Override
    //void parentMethod_2() {}
    void parentMethod() {}
}
