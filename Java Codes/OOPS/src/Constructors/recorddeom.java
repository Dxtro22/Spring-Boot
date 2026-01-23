package Constructors;
import java.util.*;

record Bike(String brand,int speed,int hr_power)
    {}
public class recorddeom {
    static void main() {
        Bike bike = new Bike("BMW",120,200);
        System.out.println("Brand : "+ bike.brand());
    }

}
