package Constructors;

record kite(String brand, String model) {}
public class recorddemon
{
    public static void main(String[] args) {
        kite bike = new kite("BMW","M4 COMPETITION");
        System.out.println("Brand : "+bike.brand());
        System.out.println("Model : "+bike.model());

    }
}
