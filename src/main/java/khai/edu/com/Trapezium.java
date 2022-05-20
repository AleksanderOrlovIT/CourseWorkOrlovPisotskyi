package khai.edu.com;

public class Trapezium extends Figure{
    private double smallBase, bigBase, leftSide, rightSide;
    private String trapeziumType = "Arbitrary trapezium";
    private String name;

    public void setName(String name){
        this.name = name;
    }

    public Trapezium(double a, double b, double c, double h, String name){
        setSides(a,b,c,h);
        checkIfTrapeziumIsRectangular();
        setName(name);
    }

    public void setSides(double a, double b, double c, double h){
            this.bigBase = a;
            this.smallBase = b;
            this.leftSide = c;
            this.rightSide = Math.sqrt(Math.pow((a - Math.sqrt((c*c)-(h*h))),2) + (h*h));

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
    public double findArea(){
        return (0.5 * (smallBase + bigBase) * Math.sqrt(leftSide*leftSide - Math.pow((bigBase - smallBase)/2,2)));
    }


    @Override
    public double findGravityCenter() {
        return (findHeight() / 3) * (2*getBigBase()*getSmallBase() / (getSmallBase() + getBigBase()));
    }

    @Override
    public double findPerimeter() {
        return getSmallBase() + getRightSide() + getLeftSide() + getRightSide();
    }

    @Override
    public String returnName()
    {
        return name;
    }

    @Override
    public String describeObject()
    {
        return ("Smallbase - " + getSmallBase() + " cm;\nBig base - " + getBigBase() + 
        " cm;\nLeft side - "  + getLeftSide() + " cm;\nRight side - " + getRightSide() + " cm.");
    }
}
