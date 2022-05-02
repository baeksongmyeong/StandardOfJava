package ch12;

class NewClass {
    int newField;
    @Deprecated int oldField;
    public int getNewField() {return newField;}
    @Deprecated public int getOldField() {return oldField;}
}

public class AnnotationEx2 {
    public static void main(String[] args) {
        NewClass nc = new NewClass();

        nc.newField = 10;
        System.out.println(nc.getNewField());

        nc.oldField = 20;
        System.out.println(nc.getNewField());
    }
}
