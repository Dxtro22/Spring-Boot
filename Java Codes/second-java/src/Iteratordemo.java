import java.util.*;

public class Iteratordemo {
    public static void main(String[] args) {
        List<String> users = new ArrayList<>();
        users.add("John");
        users.add("Jane");
        users.add("Julie");
        users.add("Veer");
        users.add("Raj pal");

        //TO ITERATE IN THE COLLECTION WE HAVE 3 METHODS

        //1. FOR EACH LOOP(ENHANCED FOR LOOP)
        System.out.println("Using For each loop");
        for (String u : users) {
            System.out.println(u);
        }

        System.out.println("\n\nUsing For loop");
        //2. USING FOR LOOP
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }

        //3. USING ITERATOR
        System.out.println("\n\nUsing for Iterator");

        Iterator<String> it = users.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
