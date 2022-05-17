package khai.edu.com;

import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class Picture {
    private ArrayList<Figure> figures = new ArrayList<Figure>();
    private ArrayList<String> names = new ArrayList<String>(Arrays.asList("Circle", "Rectangle", "Trapezium"));
    private Random rnd = new Random();

    public void outputInfo()
    {
        if(figures.size() == 0)
        {
            System.out.println("Your collection is empty! Add something pls.");
            return;
        }
        for(int i=0;i<figures.size();i++)
        {
            System.out.println("№" + (i+1));
            System.out.println(figures.get(i).returnName());
            System.out.println(figures.get(i).describeObject());
            System.out.println("Parameters of figure: \nArea - " + figures.get(i).findArea() + " cm^2.\n" + "Center of gravity - " +
            figures.get(i).findGravityCenter() + ".\nPerimeter - " + figures.get(i).findPerimeter() + " cm.");
            System.out.println("----------------------------------------");
        }
    }

    public void addFigure(int index)
    {
        double side,side2,side3,side4;
        Scanner sc = new Scanner(System.in);
        if(index<=0) throw new IllegalArgumentException("Wrong input. Argument is between 1 and any other positive integer");
        switch (index) {
            case 1:
                while(true) {
                    System.out.println("Input you radius for circle please");
                    if (sc.hasNextDouble() || sc.hasNextInt()) {
                        side = sc.nextDouble();
                        Circle circ = new Circle(side);
                        figures.add(circ);
                        break;
                    }
                }
                System.out.println("You added new circle!");
                break;
            case 2:
                while(true) {
                    System.out.println("Input you sides for rectangle please (a,b)");
                    if (sc.hasNextDouble() || sc.hasNextInt()) {
                        side = sc.nextDouble();
                        side2 = sc.nextDouble();
                        Rectangle rect = new Rectangle(side, side2);
                        figures.add(rect);
                        break;
                    }
                }
                System.out.println("You added new rectangle!");
                break;

            case 3:
                while(true) {
                    System.out.println("Input you sides for rectangle please (a,b)");
                    if (sc.hasNextDouble() || sc.hasNextInt()) {
                        side = sc.nextDouble();
                        side2 = sc.nextDouble();
                        side3 = sc.nextDouble();
                        side4 = sc.nextDouble();
                        Trapezium trap = new Trapezium(side, side2, side3, side4);
                        figures.add(trap);
                        break;
                    }
                }
                System.out.println("You added new trapezium!");
                    break;
            default :
                System.out.println("Something got wrong! Connect with your system manager.");
        }
    }

    public void cleanFigures()
    {
        figures.clear();
    }

    public void generateFigures(int a)
    {
        double side,side2,side3,side4;
        if(a<=0) throw new IllegalArgumentException("Wrong input. Argument is between 1 and any other positive integer");
        else {
            for(int i=0;i<a;i++)
            {
                String check = names.get(rnd.nextInt(0,3));
                switch (check) {
                case "Circle":
                    side = rnd.nextDouble(1,30);
                    Circle circ = new Circle(side);
                    figures.add(circ);
                    break;
                case "Rectangle":
                    side = rnd.nextDouble(1,30);
                    side2 = rnd.nextDouble(1,30);
                    Rectangle rect = new Rectangle(side, side2);
                    figures.add(rect);
                    break;
                case "Trapezium":
                    side = rnd.nextDouble(8,30);
                    side2 = side - 5;
                    side3 = rnd.nextDouble(1,30);
                    side4 = rnd.nextDouble(1,30);
                    Trapezium trap = new Trapezium(side,side2,side3,side4);
                    figures.add(trap);
                    break;
                default :
                System.out.println("Something got wrong! Connect with your system manager.");
                }
            }
        }
    }

}
