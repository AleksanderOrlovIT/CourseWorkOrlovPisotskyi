package khai.edu.com;

public class Circle extends Figure{
    private double radius;
    private String name;

    public void setName(String name){
        this.name = name;
    }

    public Circle(double radius, String name){
        setRadius(radius);
        setName(name);
    }

    public void setRadius(double radius){
            this.radius = radius;
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
        return name;
    }

    @Override
    public String describeObject()
    {
        return ("Radius - " + getRadius()) + " cm.";
    }
}
