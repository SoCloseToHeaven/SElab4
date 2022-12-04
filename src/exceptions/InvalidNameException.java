package exceptions;

public class InvalidNameException extends Exception{

    public InvalidNameException() {
        super("InvalidNameException: объект с таким именем не может быть создан");
    }
}
