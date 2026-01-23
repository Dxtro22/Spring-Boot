import java.util.*;

public class eg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // number of test cases

        while (t-- > 0) {
            int n = sc.nextInt(); // number of elements

            ArrayList<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }

            // Now arr behaves like a user-defined array
            // You can pass it to functions
            solve(arr);
        }
    }

    static void solve(ArrayList<Integer> arr) {
        // Example operation
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
