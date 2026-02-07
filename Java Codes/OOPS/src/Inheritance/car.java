package Inheritance;

public class car extends vehicle{
    private int doors;


    public car(String brand, int speed,int doors) {
        super(brand, speed);
        this.doors = doors;
    }
    @Override
    public void info()
    {
        System.out.println("My car has a Speed of "+getSpeed()+"km/hr having a brand name "+getBrand()+" is of "+doors+" doors.");
    }
}
