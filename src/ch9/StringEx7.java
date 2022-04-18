package ch9;

/*
* substring 메서드에서 index 는 0 부터 시작하고, start~end 에서 end 는 자른 결과에 포함되지 않는다.
* */
public class StringEx7 {
    public static void main(String[] args) {
        String fullName = "Hello.java";
        int index = fullName.indexOf('.');
        String fileName = fullName.substring(0, index);
        String ext = fullName.substring(index + 1);
        System.out.println("확장자를 제외한 이름은 " + fileName);
        System.out.println("확장자는 " + ext);
    }
}
