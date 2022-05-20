package khai.edu.com;

import java.util.Scanner;

public class MainProject {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        UserInterface usGUI = new UserInterface();
        Picture figures = new Picture();
        int chose = 0, needed;
        usGUI.sayHello();
        while(true) {
        usGUI.outputMenu();
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.println("Please input correct number");
        }
        chose = sc.nextInt();
        switch(chose){
            case 1:
                System.out.println("Chose your figure: 1 - Circle, 2 - Rectangle, 3 - Trapezium");
                if(sc.hasNextInt())
                {
                    needed = sc.nextInt();
                    if(needed<1 || needed>3)
                    {
                        System.out.println("Wrong choice, try again!");
                        break;
                    }
                }
                else break;
                figures.addFigure(needed);
                break;
            case 2:
                figures.outputInfo();
                break;
            case 3:
                System.out.println("Press 1 if you want to search by name or press 2 if you want to search by number");
                int decision = 0;
                if(sc.hasNextInt())
                {
                    decision = sc.nextInt();
                    if(decision<1 || decision>2)
                    {
                        System.out.println("Wrong choice, try again!");
                        break;
                    }
                }
                if(decision == 1) {
                    System.out.println("Please input figure name");
                    figures.getInformationByName(sc.next());
                }
                else if(decision == 2) {
                    System.out.println("Please input figure number");
                    figures.getInformationByNumber(sc.nextInt());
                }
                break;
            case 4:
                figures.cleanFigures();
                break;
            case 5:
                System.out.print("Input your amount of generated figures - ");
                if(sc.hasNextInt())
                {
                    needed = sc.nextInt();
                }
                else break;
                figures.generateFigures(needed);
                break;
            case 0:
                return;
            default:
                System.out.println("Input correct choose pls!");
        }
        }
    }
}
