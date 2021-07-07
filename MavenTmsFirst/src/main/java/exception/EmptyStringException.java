package exception;

public class EmptyStringException extends MyException{
    public EmptyStringException(){
        super("Empty string detected");
    }
}
