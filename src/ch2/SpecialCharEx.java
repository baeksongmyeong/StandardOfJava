package ch2;

public class SpecialCharEx {
    public static void main(String[] args) {
        System.out.println("작은따옴표 : " + '\''); // 작은따옴표
        System.out.println("탭 그리고 백스페이스 : " + "abc\t123\b456"); // 탭, 백스페이스
        System.out.println("개행 : " + '\n'); // 개행
        System.out.println("큰따옴표 : " + "\"Hello"); // 큰따옴표
        System.out.println("역슬래시 : " + "c:\\"); // 역슬래시

        String str = "ABC";

        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            System.out.println("char="+ch+", unicode="+(int)ch);
        }

        str.chars().forEach(ch->{
            System.out.println("unicode="+ch+", char="+(char)ch);
        });
    }
}
