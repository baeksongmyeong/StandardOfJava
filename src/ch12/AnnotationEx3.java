package ch12;

import java.util.ArrayList;

/*
*
* */
class NewClass1 {
    int newField;
    int getNewField(){return this.newField;}
    @Deprecated int oldField;
    @Deprecated int getOldField(){return this.oldField;}
}

public class AnnotationEx3 {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        NewClass1 nc = new NewClass1();

        nc.oldField = 10;
        System.out.println(nc.getOldField());

        @SuppressWarnings("unchecked")
        ArrayList<NewClass1> list = new ArrayList();
        list.add(nc);

    }
}
