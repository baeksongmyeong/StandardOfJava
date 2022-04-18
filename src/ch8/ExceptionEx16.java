package ch8;

import java.io.File;

/* 예외 발생시 호출한 메서드로 예외를 전달하도록 함. 이렇게 하면, 호출한 메서드가 예외가 발생했음을 인지할 수 있다. */

public class ExceptionEx16 {

    public static void main(String[] args) {

        String[] strArr = new String[]{"a.txt", ""};

        try {
            for( String fileName : strArr){
                File f = createFile(fileName);
                System.out.println(f.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + " 다시 입력해 주시기 바랍니다.");
        }

    }

    static File createFile(String fileName) throws Exception {

        if(null == fileName || "".equals(fileName)){
            throw new Exception("파일 이름이 유효하지 않습니다.");
        }

        File f = new File(fileName);
        f.createNewFile();
        return f;

    }
}
