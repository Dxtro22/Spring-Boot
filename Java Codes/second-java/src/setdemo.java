import java.util.*;

public class setdemo {
    public static void main(String[] args)
    {
        Set<String> role = new HashSet<>();
        role.add("ADMIN");
        role.add("MANAGER");
        role.add("USER");

        for(String roles : role )
        {
            System.out.println(roles);
        }
    }
}
