package Inheritance;

import static java.awt.Color.black;

public class Inheritancedemo {
    static void main(String[] args) {

        car c1 = new car("BMW",120,4);
        c1.info();

        bike b1 = new bike("royal 350",220,"black");
        b1.info();
    }
}
