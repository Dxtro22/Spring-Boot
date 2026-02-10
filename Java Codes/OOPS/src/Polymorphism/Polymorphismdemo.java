package Polymorphism;

public class Polymorphismdemo {
    static void main(String[] args) {

        car c1 = new car("BMW",120,4);
        c1.info();

        bike b1 = new bike("royal 350",220,"black");
        b1.info();

        c1.Start();
        vehicle v1 = new vehicle("Ford",231);
        v1.Start();

        //example of run time polymorphism
        vehicle v2 = new car("Curvv",1200,5);
        v2.Start();//output will starting a car
    }
}
