package khai.edu.com;

public class Circle extends Figure{
    private double radius;

    public Circle(double radius){
        setRadius(radius);
    }

    public void setRadius(double radius){
        if(radius <= 0) throw new IllegalArgumentException("Wrong input, please try again");
        this.radius = radius;
        System.out.println("You have made a circle with radius = " + radius);
    }

    public double getRadius(){
        return radius;
    }

    @Override
    public double findArea() {
        return Math.PI * getRadius() * getRadius();
    }

    @Override
    public double findGravityCenter() {
        return getRadius();
    }

    @Override
    public double findPerimeter() {
        return 2 * Math.PI * getRadius();
    }

    public double findDiameter(){
        return getRadius() + getRadius();
    }

    public double findSectorArea(int angle){
        return Math.PI * getRadius() * getRadius() / 360 * angle;
    }
    
    @Override
    public String returnName()
    {
        return "Circle";
    }

    @Override
    public String describeObject()
    {
        return ("Radius - " + getRadius()) + " cm.";
    }
}
