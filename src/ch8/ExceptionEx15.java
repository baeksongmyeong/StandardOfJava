package ch8;

import java.io.File;
import java.io.IOException;

/* 예외가 발생하면 예외가 발생된 메서드 내에서 try~catch 문으로 처리하게 함. 이렇게 하면, 호출한 메서드는 예외 발생을 알지 못한다. */

public class ExceptionEx15 {

    public static void main(String[] args) {

        if(args.length == 0){
            args = new String[]{""};
        }

        File f = createFile(args[0]);
        System.out.println(f.getName());
    }

    static File createFile(String fileName){

        try{
            if(null == fileName || "".equals(fileName)){
                throw new Exception("파일이름이 유효하지 않습니다.");
            }
        }catch (Exception e){
            fileName = "제목없음.txt";
        }finally{
            File f = new File(fileName);
            createNewFile(f);
            return f;
        }
    }

    static void createNewFile(File f){
        try{
            f.createNewFile();
        }catch (IOException e){
            //
        }

    }

}
