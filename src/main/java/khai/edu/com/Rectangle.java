package khai.edu.com;

public class Rectangle extends Figure{
    private double bigSide, smallSide;
    private String name;

    public void setName(String name){
        this.name = name;
    }

    public Rectangle(double a, double b, String name){
        setSides(a, b);
        setName(name);
    }

    public void setSides(double a, double b){
        if(a <= 0 || b<=0 || a==b){
            throw new IllegalArgumentException("Wrong input, please try again");
        }
        if(a > b) {
            bigSide = a;
            smallSide = b;
        }
        else {
            bigSide = b;
            smallSide = a;
        }
    }

    public double getBigSide(){
        return bigSide;
    }

    public double getSmallSide() {
        return smallSide;
    }

    @Override
    public double findArea() {
        return getBigSide() * getSmallSide();
    }

    @Override
    public double findGravityCenter() {
        return getSmallSide() / 2;
    }

    @Override
    public double findPerimeter() {
        return getBigSide() * 2 + getSmallSide() * 2;
    }

    public double getDiagonal(){
        return Math.sqrt(getBigSide() * getBigSide() + getSmallSide() * getSmallSide());
    }

    public double findCircumscribedCircleRadius(){
        return Math.sqrt(getBigSide() * getBigSide() + getSmallSide() * getSmallSide()) / 2;
    }

    public double findSideAndDiagonalAngle(){
        return Math.sin(getBigSide() / getDiagonal());
    }

    public double findSideBetweenDiagonals(){
        return 2 * findSideAndDiagonalAngle();
    }

    @Override
    public String returnName()
    {
        return name;
    }

    @Override
    public String describeObject()
    {
        return ("Side a - " + getBigSide() + " cm;\nSide b - " + getSmallSide() + " cm.");
    }
}