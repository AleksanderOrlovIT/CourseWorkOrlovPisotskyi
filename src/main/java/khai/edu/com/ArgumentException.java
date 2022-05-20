package khai.edu.com;

class ArgumentException extends Exception{
    int error;
    public ArgumentException (int a)
    {error = a;}
    public String toString()
    {
        return "Error! Please, input positive numbers for creating figure";
    }
}
