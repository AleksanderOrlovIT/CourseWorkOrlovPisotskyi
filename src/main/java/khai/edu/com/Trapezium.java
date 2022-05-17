package khai.edu.com;

public class Trapezium extends Figure{
    private double smallBase, bigBase, leftSide, rightSide;
    private String trapeziumType = "Arbitrary trapezium";

    public Trapezium(double a, double b, double c, double d){
        setSides(a,b,c,d);
    }

    public void setSides(double a, double b, double c, double d){
        if(a <= 0 || b <= 0 || c <= 0 || d <= 0 || a <= b)
            throw new IllegalArgumentException("Wrong input, please try again");
        if(c == d) setTrapeziumType("Isosceles trapezium");
        this.bigBase = a;
        this.smallBase = b;
        this.leftSide = c;
        this.rightSide = d;
    }

    public double getBigBase() {
        return bigBase;
    }

    public double getSmallBase() {
        return smallBase;
    }

    public double getLeftSide() {
        return leftSide;
    }

    public double getRightSide() {
        return rightSide;
    }

    public  double getMiddleLine(){
        return (getSmallBase() + getBigBase()) / 2;
    }

    public void setTrapeziumType(String line){
        this.trapeziumType = line;
    }

    public String getTrapeziumType(){
        return trapeziumType;
    }

    public double findHeight(){
        return (2 * findArea()) / (getSmallBase() + getBigBase());
    }

    public double findInscribedCircleRadius(){
        return findHeight() / 2;
    }

    public void checkIfTrapeziumIsRectangular(){
        if(findHeight() == getLeftSide() || findHeight() == getBigBase()) setTrapeziumType("Rectangular Trapezium");
    }

    @Override
    public double findArea() {
        return ((getSmallBase() + getBigBase()) / 2) *
                Math.sqrt(getLeftSide() * getLeftSide() -
                        ((getBigBase() - getSmallBase()) * (getBigBase() - getSmallBase())
                        + getLeftSide() * getLeftSide() - getRightSide() * getRightSide() /
                                (2 * (getBigBase() - getSmallBase()))) * ((getBigBase() - getSmallBase()) *
                                (getBigBase() - getSmallBase()) + getLeftSide() * getLeftSide() - getRightSide()
                                * getRightSide() / (2 * (getBigBase() - getSmallBase()))));
    }

    @Override
    public double findGravityCenter() {
        return (findHeight() / 3) * (2*getBigBase()*getSmallBase() / (getSmallBase() + getBigBase()));
    }

    @Override
    public double findPerimeter() {
        return getSmallBase() + getRightSide() + getLeftSide() + getRightSide();
    }
}
