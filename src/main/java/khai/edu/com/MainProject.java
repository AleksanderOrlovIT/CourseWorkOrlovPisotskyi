package khai.edu.com;

public class MainProject {
    
    public static void main(String args[])
    {
        System.out.println("Running you program...");
        Picture figures = new Picture();
        figures.generateFigures(4);
        figures.outputInfo();
    }
}
