import java.util.*;
import java.util.Map;

public class Mapdemo {
    public static void main(String[] args) {
        Map<Integer,String> usermap = new HashMap<>();
        usermap.put(1,"BMW");
        usermap.put(2,"Toyota");
        usermap.put(3,"GT");
        usermap.put(4,"SPLENDER");
        usermap.put(5,"S1000RR");

        System.out.println(usermap.get(23));

        System.out.println("All vehicle");
        for(Map.Entry<Integer,String> entry : usermap.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }

    }
}
