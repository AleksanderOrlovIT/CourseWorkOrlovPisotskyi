package khai.edu.com;

class ArgumentException extends Exception{
    int error;
    public ArgumentException (int a)
    {error = a;}
    public String toString()
    {
        if (error==0)
        {
            return "Error! Please, input numbers with correct proportions for trapezium.";
        }
        else return "Error! Please, input correct positive numbers for creating figure.";
    }
}
