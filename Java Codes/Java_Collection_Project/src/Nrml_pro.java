import java.util.*;

class Users
{
    String name;
    String role;
    String status;

    Users(String name, String role, String status)
    {
        this.name = name;
        this.role = role;
        this.status = status;
    }
}

public class Nrml_pro {
    public static void main(String[] args) {

        Users e1 = new Users("Swastik", "Developer", "INACTIVE");
        Users e2 = new Users("Suvigya", "Spring boot developer", "ACTIVE");
        Users e3 = new Users("Vibhor", "SRE", "INACTIVE");
        Users e4 = new Users("Suraj", "IOS DEVELOPER", "ACTIVE");
        Users e5 = new Users("Rajesh", "Android Developer", "ACTIVE");

        List<Users> db = new ArrayList<>();
        db.add(e1);
        db.add(e2);
        db.add(e3);
        db.add(e4);
        db.add(e5);

        System.out.println("--- Printing All Users ---");
        System.out.printf("%-15s %-30s %-15s%n", "Name", "Role", "Status");
        System.out.println("------------------------------------------------------------");

        for(Users user : db) {
            System.out.printf("%-15s %-30s %-15s%n", user.name, user.role, user.status);
        }

        // --- CORRECT WAY TO REMOVE ---
        // You cannot use a 'for' loop to remove. Use removeIf() instead.
        // Logic: "Remove the user IF their status equals INACTIVE"
        db.removeIf(user ->user.status.equals("INACTIVE"));
        // --- PRINTING THE RESULT ---
        System.out.println("\n--- After Removing Inactive Users ---");
        System.out.printf("%-15s %-30s %-15s%n", "Name", "Role", "Status");
        System.out.println("------------------------------------------------------------");

        for(Users user : db) {
            System.out.printf("%-15s %-30s %-15s%n", user.name, user.role, user.status);
        }

        // --- COUNTING USERS PER ROLE ---

        // 1. Create a Map to store the counts
        // Key (String) = The Role Name
        // Value (Integer) = How many people have that role
        Map<String, Integer> roleCounts = new HashMap<>();

        for (Users user : db) {
            String role = user.role;

            // Check if we have seen this role before
            if (roleCounts.containsKey(role)) {
                // If yes, get the current count and add 1
                int currentCount = roleCounts.get(role);
                roleCounts.put(role, currentCount + 1);
            } else {
                // If no, this is the first time we see it. Set count to 1.
                roleCounts.put(role, 1);
            }
        }

        // 2. Print the results
        System.out.println("\n--- Users Per Role ---");
        for (String role : roleCounts.keySet()) {
            System.out.println(role + " : " + roleCounts.get(role));
        }
        }
    }