package ch6;

public class VarArgsEx {
    public static void main(String[] args) {

        // 1. String 들을 가변인자로 전달
        System.out.println(concatenate("", "100", "200", "300"));
        
        // 2. 배열을 가변인자로 전달
        String[] strArr = new String[]{"100", "200", "300"};
        System.out.println(concatenate("-", strArr));
        System.out.println(concatenate(",", new String[]{"1", "2", "3"}));
        //System.out.println(concatenate("#", {"1", "2", "3"})); // 이런 형태는 지원되지 않음. new 를 통해 배열객체를 생성해서 전달해야 함
        System.out.println("["+concatenate(",", new String[0])+"]"); // 길이가 0 인 배열도 가능
        System.out.println("["+concatenate(",")+"]"); // 가변인자를 넘겨주지 않는것도 가능. 길이가 0 인 배열이 내부적으로 생성되서 수행됨

        // 3. 가변인자 오버로딩 메서드 호출
        System.out.println(concatenate(1, strArr));
    }

    static String concatenate(String delim, String... args){
        String result = "";
        // 가변인자는 배열로 다룰수 있음
        for(String str : args) result += str + delim;
        return result;
    }

    // 메서드를 호출하는 코드에서 오류가 발생. 위의 메서드와 차이가 없다고 판단함. 모든 인자가 String 이기때문에
//    static String concatenate(String... args){
//        return concatenate("", args);
//    }

    static String concatenate(int a, String... args){
        return concatenate(String.valueOf(a), args);
    }
}
