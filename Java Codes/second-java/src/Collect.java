import java.util.List;
import java.util.ArrayList;

class Car {
    String brand;
    Car(String brand)
    {
        this.brand = brand;
    }
}
public class Collect {
    public static void main(String[] args) {
        List<String> users = new ArrayList<>();
        users.add("Alice");
        users.add("BOB");
        users.add("RAHUL");
        users.add("12");
//        System.out.println("The array list contains : "+users);

        for(Object user : users){
            System.out.println(user);
        }
        // get element by index
        System.out.println("Get element by index : " + users.get(2));
//        users.add(500,"gaurav");
//        System.out.println("\n\n"+users); The error message says it clearly: IndexOutOfBoundsException: Index: 500, Size: 4

        //Creating List of Object
        Car car1 = new Car("BMW");
        Car car2 = new Car("Toyota");
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        for(Car car : carList){
            System.out.println(car.brand);
        }

    }

}
