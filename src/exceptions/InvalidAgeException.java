package exceptions;

public class InvalidAgeException extends Exception{

    public InvalidAgeException() {
        super("InvalidAgeException: неподходящее значение возраста");
    }
}
