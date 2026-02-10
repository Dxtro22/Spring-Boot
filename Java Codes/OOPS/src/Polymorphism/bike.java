package Polymorphism;

public class bike extends vehicle {
    private String colour;

    public bike(String brand, int speed, String colour) {

        super(brand, speed);
        this.colour = colour;
    }
    @Override
    public void Start() {
        System.out.println("Starting a bike ... ");
    }

    @Override
    public void info()
    {
        super.info();
        System.out.println("Colour:"+colour);
    }

}
