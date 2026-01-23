package Classdemo;

public class car {
    String brand,color;
    int speed;
    int hr_power;
    String DOM;//date of manufaturing

    public void display()
    {
        System.out.println(brand+" is driving at a speed of "+speed);
    }
    public void addFe()
    {
        System.out.println("Car has a hp of "+ hr_power+" and a DOM of "+DOM);
    }
}
