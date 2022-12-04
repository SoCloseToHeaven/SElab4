package exceptions;

public class InvalidFlightConditionsException extends RuntimeException{

    public InvalidFlightConditionsException(){
        super("InvalidFlightContidionsException: неподходящие условия для полёта");
    }
}
