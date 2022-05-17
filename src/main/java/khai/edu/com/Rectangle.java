package khai.edu.com;

public class Rectangle extends Figure{
    private double bigSide, smallSide;

    public Rectangle(double a, double b){
        setSides(a, b);
    }

    public void setSides(double a, double b){
        if(a == b || a <= 0 || b<=0){
            throw new IllegalArgumentException("Wrong input, please try again");
        }
        if(a > b) {
            bigSide = a;
            smallSide = b;
            System.out.println("You have made a rectangle with side a = " + a + " and side b = " + b);
        }
        else {
            bigSide = b;
            smallSide = a;
            System.out.println("You have made a rectangle with side a = " + a + " and side b = " + b);
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

    public double findCircumscribesCircleRadius(){
        return Math.sqrt(getBigSide() * getBigSide() + getSmallSide() * getSmallSide()) / 2;
    }

    public double findSideAndDiagonalAngle(){
        return Math.sin(getBigSide() / getDiagonal());
    }

    public double findSideBetweenDiagonals(){
        return 2 * findSideAndDiagonalAngle();
    }
}
