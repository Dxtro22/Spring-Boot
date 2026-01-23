package Constructors;

public class car {
    String brand,color;
    int speed;
    int hr_power;
    String DOM;//date of manufaturing

    public car(String brand, String color, int speed, int hr_power, String DOM)
    {
        this.brand=brand;
        this.color=color;
        this.speed=speed;
        this.hr_power=hr_power;
        this.DOM=DOM;
        System.out.println("Constructor is called");
    }

    public void display()
    {
        System.out.println(brand+" is driving at a speed of "+speed);
    }
    public void addFe()
    {
        System.out.println("Car has a hp of "+ hr_power+" and a DOM of "+DOM);
    }
}
