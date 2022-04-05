package ch5;

public class ArrayEx12 {
    public static void main(String[] args) {
        
        // String 배열 생성
        String[] names = new String[]{"Kim", "Park", "Yi"};
        String[] names2 = {"Kim", "Park", "Yi"};
        
        // String 배열 요소 접근 (참조변수에 접근해서 실제 String 객체의 주소를 알아온 후 String 객체에 접근)
        for (int i = 0; i < names.length; i++) {
            System.out.println("names["+i+"] : " + names[i]);
        }

        // String 배열에 인덱스 사용
        String tmp = names[2];
        System.out.println("tmp : " + tmp);

        // String 배열의 특정 요소 접근 및 값 변경
        names[0] = "Yu";
        for (String name : names) {
            System.out.println(name);
        }

    }

}