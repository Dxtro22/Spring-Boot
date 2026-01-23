package Constructors;

public class constructordemo {
    static void main(String[] args) {
    car car1 = new car("KIA","TEAL",150,210,"09/03/2002");//instantiation(creating the object)
//        car1.speed = 100;//instance variables
//        car1.color = "red";
//        car1.brand = "BMW";
        car1.display();

        // creating the 2 object of the same class with additional features
        car car2 = new car("Toyota","red",100,200,"22/01/2005");
//        car2.hr_power = 100;
//        car2.DOM ="22/01/2005";
        car2.addFe();
        String A;
    }
}
