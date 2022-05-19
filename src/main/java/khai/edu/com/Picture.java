package khai.edu.com;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class Picture {
    private ArrayList<Figure> figures = new ArrayList<Figure>();
    private ArrayList<String> names = new ArrayList<String>(Arrays.asList("Circle", "Rectangle", "Trapezium"));
    private Random rnd = new Random();
    private DecimalFormat decimalFormat = new DecimalFormat("#.###");

    public void outputInfo() {
        if (figures.size() == 0) {
            System.out.println("Your collection is empty! Add something pls.");
            return;
        }
        for (int i = 0; i < figures.size(); i++) {
            String figureType = "";
            if (figures.get(i).getClass().equals(Circle.class)) figureType = "Circle";
            else if (figures.get(i).getClass().equals(Rectangle.class)) figureType = "Rectangle";
            else if (figures.get(i).getClass().equals(Trapezium.class)) figureType = "Trapezium";
            System.out.println("№" + (i + 1));
            System.out.println("Name - " + figures.get(i).returnName());
            System.out.println("Figure type - " + figureType);
            System.out.println(figures.get(i).describeObject());
            System.out.println("Parameters of figure: \nArea - " + decimalFormat.format(figures.get(i).findArea())
                    + " cm^2.\n" + "Center of gravity - " + decimalFormat.format(figures.get(i).findGravityCenter())
                    + ".\nPerimeter - " + decimalFormat.format(figures.get(i).findPerimeter()) + " cm.");
            System.out.println("----------------------------------------");
        }
    }

    public void addFigure(int index) {
        double side, side2, side3, h;
        String name;
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        if (index <= 0)
            throw new IllegalArgumentException("Wrong input. Argument is between 1 and any other positive integer");
        switch (index) {
            case 1:
                while (true) {
                    System.out.println("Input your radius for circle please");
                    if (sc.hasNextDouble() || sc.hasNextInt()) {
                        side = sc.nextDouble();
                        System.out.println("Input the name for circle please");
                        name = sc.next();
                        for (int i = 0; i < figures.size(); i++) {
                            if (figures.get(i).returnName().equals(name)) {
                                System.out.println("This name already exists, please change it to another");
                                i = -1;
                                name = sc.next();
                            }
                        }
                        Circle circ = new Circle(side, name);
                        figures.add(circ);
                        break;
                    } else sc.next();
                }
                System.out.println("You added new circle!");
                break;
            case 2:
                while (true) {
                    System.out.println("Input you sides for rectangle please (a,b)");
                    if (sc.hasNextDouble() || sc.hasNextInt()) {
                        side = sc.nextDouble();
                        if(sc.hasNextDouble() || sc.hasNextInt()) {
                            side2 = sc.nextDouble();
                            System.out.println("Input the name for rectangle please");
                            name = sc.next();
                            for (int i = 0; i < figures.size(); i++) {
                                if (figures.get(i).returnName().equals(name)) {
                                    System.out.println("This name already exists, please change it to another");
                                    i = -1;
                                    name = sc.next();
                                }
                            }
                            Rectangle rect = new Rectangle(side, side2, name);
                            figures.add(rect);
                            break;
                        }else sc.next();
                    } else sc.next();
                }
                System.out.println("You added new rectangle!");
                break;

            case 3:
                while (true) {
                    System.out.println("Input your length for trapezium please (a,b,c,h)");
                    if (sc.hasNextDouble() || sc.hasNextInt()) {
                        side = sc.nextDouble();
                        if(sc.hasNextDouble() || sc.hasNextInt()) {
                            side2 = sc.nextDouble();
                            if(sc.hasNextDouble() || sc.hasNextInt()) {
                                side3 = sc.nextDouble();
                                if(sc.hasNextDouble() || sc.hasNextInt()) {
                                    h = sc.nextDouble();
                                    System.out.println("Input the name for trapezium please");
                                    name = sc.next();
                                    for (int i = 0; i < figures.size(); i++) {
                                        if (figures.get(i).returnName().equals(name)) {
                                            System.out.println("This name already exists, please change it to another");
                                            i = -1;
                                            name = sc.next();
                                        }
                                    }
                                    Trapezium trap = new Trapezium(side, side2, side3, h, name);
                                    figures.add(trap);
                                    break;
                                }else sc.next();
                            }else sc.next();
                        }else sc.next();
                    }else sc.next();
                }
                System.out.println("You added new trapezium!");
                break;
            default:
                System.out.println("Something got wrong! Connect with your system manager.");
        }
    }

    public void cleanFigures() {
        figures.clear();
    }

    public void generateFigures(int a) {
        double side, side2, side3, h;
        StringBuilder name = new StringBuilder();
        int times;
        if (a <= 0)
            throw new IllegalArgumentException("Wrong input. Argument is between 1 and any other positive integer");
        else {
            for (int i = 0; i < a; i++) {
                String check = names.get(rnd.nextInt(0, 3));
                switch (check) {
                    case "Circle":
                        side = Math.ceil(rnd.nextDouble(1, 30));
                        times = rnd.nextInt(10);
                        for (int j = 0; j < times; j++) name.append(String.valueOf((char) rnd.nextInt(1000)));
                        Circle circ = new Circle(side, name.toString());
                        figures.add(circ);
                        break;
                    case "Rectangle":
                        side = Math.ceil(rnd.nextDouble(1, 30));
                        side2 = Math.ceil(rnd.nextDouble(1, 30));
                        name = new StringBuilder();
                        times = rnd.nextInt(10);
                        for (int j = 0; j < times; j++) name.append(String.valueOf((char) rnd.nextInt(1000)));
                        Rectangle rect = new Rectangle(side, side2, name.toString());
                        figures.add(rect);
                        break;
                    case "Trapezium":
                        h = rnd.nextDouble(3, 20);
                        side = rnd.nextDouble(4, 30);
                        side2 = rnd.nextDouble(1, side - 1.0);
                        side3 = rnd.nextDouble(h,Math.sqrt(h * h + (side - side2) * (side - side2)));
                        name = new StringBuilder();
                        times = rnd.nextInt(10);
                        for (int j = 0; j < times; j++) name.append(String.valueOf((char) rnd.nextInt(1000)));
                        Trapezium trap = new Trapezium(side, side2, side3, h, name.toString());
                        figures.add(trap);
                        break;
                    default:
                        System.out.println("Something got wrong! Connect with your system manager.");
                }
            }
        }
    }

    public void getInformationByName(String name) {
        boolean flag = false;
        for (int i = 0; i < figures.size(); i++) {
            if (figures.get(i).returnName().equals(name)) {
                String figureType = "";
                if (figures.get(i).getClass().equals(Circle.class)) figureType = "Circle";
                else if (figures.get(i).getClass().equals(Rectangle.class)) figureType = "Rectangle";
                else if (figures.get(i).getClass().equals(Trapezium.class)) figureType = "Trapezium";
                System.out.println("Name - " + figures.get(i).returnName());
                System.out.println("Figure type - " + figureType);
                System.out.println(figures.get(i).describeObject());
                System.out.println("Parameters of figure: \nArea - " + decimalFormat.format(figures.get(i).findArea())
                        + " cm^2.\n" + "Center of gravity - " + decimalFormat.format(figures.get(i).findGravityCenter())
                        + ".\nPerimeter - " + figures.get(i).findPerimeter() + " cm.");
                if (figures.get(i).getClass().equals(Circle.class)) {
                    Circle circle = (Circle) figures.get(i);
                    System.out.println("Diameter - " + circle.findDiameter());
                    System.out.println("Circle sector area with angle of 90 - " + circle.findSectorArea(90));
                } else if (figures.get(i).getClass().equals(Rectangle.class)) {
                    Rectangle rectangle = (Rectangle) figures.get(i);
                    System.out.println("Circumscribed circle radius - " + rectangle.findCircumscribedCircleRadius());
                    System.out.println("The angle between big side and diagonal - "
                            + rectangle.findSideAndDiagonalAngle());
                    System.out.println("Side between diagonals - " + rectangle.findSideBetweenDiagonals());
                } else if (figures.get(i).getClass().equals(Trapezium.class)) {
                    Trapezium trapezium = (Trapezium) figures.get(i);
                    System.out.println("Middle line - " + trapezium.getMiddleLine());
                    System.out.println("Trapezium type - " + trapezium.getTrapeziumType());
                    System.out.println("Inscribed circle radius - " + trapezium.findInscribedCircleRadius());
                }
                flag = true;
                break;
            }
        }
        if (!flag) System.out.println("There are no figure with that name");
    }

    public void getInformationByNumber(int number) {
        if (number >= figures.size() || number < 0) System.out.println("Wrong number please try again");
        else {
            String figureType = "";
            if (figures.get(number).getClass().equals(Circle.class)) figureType = "Circle";
            else if (figures.get(number).getClass().equals(Rectangle.class)) figureType = "Rectangle";
            else if (figures.get(number).getClass().equals(Trapezium.class)) figureType = "Trapezium";
            System.out.println("Name - " + figures.get(number).returnName());
            System.out.println("Figure type - " + figureType);
            System.out.println(figures.get(number).describeObject());
            System.out.println("Parameters of figure: \nArea - " + decimalFormat.format(figures.get(number).findArea())
                    + " cm^2.\n" + "Center of gravity - " + decimalFormat.format(figures.get(number).findGravityCenter())
                    + ".\nPerimeter - " + figures.get(number).findPerimeter() + " cm.");
            if (figures.get(number).getClass().equals(Circle.class)) {
                Circle circle = (Circle) figures.get(number);
                System.out.println("Diameter - " + circle.findDiameter());
                System.out.println("Circle sector area with angle of 90 - " + circle.findSectorArea(90));
            } else if (figures.get(number).getClass().equals(Rectangle.class)) {
                Rectangle rectangle = (Rectangle) figures.get(number);
                System.out.println("Circumscribed circle radius - " + rectangle.findCircumscribedCircleRadius());
                System.out.println("The angle between big side and diagonal - "
                        + rectangle.findSideAndDiagonalAngle());
                System.out.println("Side between diagonals - " + rectangle.findSideBetweenDiagonals());
            } else if (figures.get(number).getClass().equals(Trapezium.class)) {
                Trapezium trapezium = (Trapezium) figures.get(number);
                System.out.println("Middle line - " + trapezium.getMiddleLine());
                System.out.println("Trapezium type - " + trapezium.getTrapeziumType());
                System.out.println("Inscribed circle radius - " + trapezium.findInscribedCircleRadius());
            }
        }
    }
}