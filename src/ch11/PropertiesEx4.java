package ch11;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PropertiesEx4 {
    public static void main(String[] args) {
        Properties prop = System.getProperties();
        prop.list(System.out);
        Set set = prop.stringPropertyNames();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            System.out.println(key + " : " + prop.getProperty(key));
        }
    }
}
