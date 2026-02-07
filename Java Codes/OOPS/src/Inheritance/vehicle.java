package Inheritance;

public class vehicle {
    private String brand;
    private int speed;

    public vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void info()
    {
        System.out.println("Brand:" + brand+ ",Speed:" + speed);
    }
}


