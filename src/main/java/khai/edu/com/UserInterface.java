package khai.edu.com;

public class UserInterface {

    public void sayHello()
    {
        System.out.println("Hello, dear user! Welcome to Orlov & Pisotskyi course project ;)");
    }
    public void outputMenu()
    {
        System.out.println("""
                Menu:
                1 - Add new figure to your collection
                2 - Show your collection of figures
                3 - See advanced parameters of figure
                4 - Delete your collection
                5 - Visualize your figure
                6 - Generate collection randomly
                0 - Exit""");
    }


}
