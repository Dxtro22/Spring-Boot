package Encapsulation;


class car {
    private String brand,color;
    private int speed;
    private int hr_power;
    String DOM;//date of manufaturing

    public car(String brand, String color, int speed, int hr_power, String DOM)
    {
        this.brand=brand;
        this.color=color;
        //this.speed=speed;
        this.hr_power=hr_power;
        this.DOM=DOM;
        setSpeed(speed);
        System.out.println("Constructor is called");
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if(speed<0)
            speed=0;
        this.speed = speed;
    }

    public void drive()
    {
        System.out.println("Drive at a speed of "+speed);
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


public class encapsulationdemo {
    public static void main(String[] args) {
      car car1 = new car("KIA","TEAL",-150,210,"09/03/2002");
      car1.drive();
        System.out.println(car1.getSpeed());
      car1.setSpeed(300);
        System.out.println(car1.getSpeed());
      car car2 = new car( "Toyota","red",100,200,"22/01/2005");


    }
}
