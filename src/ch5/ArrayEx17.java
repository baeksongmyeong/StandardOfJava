package ch5;

public class ArrayEx17 {
    public static void main(String[] args) {
        // 프로그램 매개변수가 3개가 아니면 종료
        if(args.length != 3){
            System.out.println("usage : java ArrayEx17 NUM1 OP NUM2");
            System.exit(0);
        }

        int num1 = 0;
        int num2 = 0;


        // 첫번째, 세번째 매개변수는 숫자
        try{
            num1 = Integer.parseInt(args[0]);
            num2 = Integer.parseInt(args[2]);
        }catch(Exception e){
            if ( e instanceof NumberFormatException){
                System.out.println("정수를 입력하세요. num1 : [" + args[0] + "], num2 : [" + args[2] + "]");
            }else{
                System.out.println("오류");
            }

            System.exit(-1);
        }

        if(args[1].length() != 1 || ( args[1].charAt(0) != '+' && args[1].charAt(0) != '-'  && args[1].charAt(0) != '*' && args[1].charAt(0) != '/')){
            System.out.println("연산자를 입력하세요. 연산자 : [" + args[1] + "]");
        }

        // 두번째 매개변수는 연산자. String 타입을 char 타입에 저장해야 하므로 charAt 을 사용해서 한 문자만 추출
        char op  = args[1].charAt(0);

        int result = 0;

        switch (op) {
            case '+' :
                result = num1 + num2;
                break;
            case '-' :
                result = num1 - num2;
                break;
            case '*' :
                result = num1 * num2;
                break;
            case '/' :
                result = num1 / num2;
                break;
            default :
                result = 0;
                break;
        }
        System.out.println(num1 + " " + op +" " + num2 + " = " + String.valueOf(result));
    }
}
