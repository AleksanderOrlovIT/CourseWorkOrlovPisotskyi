package khai.edu.com;

import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class Picture {
    private ArrayList<Figure> figures = new ArrayList<Figure>();
    private ArrayList<String> names = new ArrayList<String>(Arrays.asList("Circle", "Rectangle", "Trapezium"));
    private Random rnd = new Random();

    public void outputInfo()
    {
        for(int i=0;i<figures.size();i++)
        {
            System.out.println("№" + (i+1));
            System.out.println(figures.get(i).returnName());
            System.out.println(figures.get(i).describeObject());
            System.out.println("Parameters of figure: \nArea - " + figures.get(i).findArea() + " cm^2.\n" + "Center of gravity - " +
            figures.get(i).findGravityCenter() + ".\nPerimeter - " + figures.get(i).findPerimeter() + " cm.");
        }
    }

    public void generateFigures(int a)
    {
        double side,side2,side3,side4;
        if(a<=0) throw new IllegalArgumentException("Wrong input. Argument is between 1 and any other positive integer");
        else {
            for(int i=0;i<a;i++)
            {
                String check = names.get(rnd.nextInt(0,2));
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
                    side = rnd.nextDouble(1,30);
                    side2 = rnd.nextDouble(1,30);
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
