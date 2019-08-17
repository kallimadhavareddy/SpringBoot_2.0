package tk.madhavareddy.digitaldiary.presentation.exception;

public class NoRecordsFoundException extends RuntimeException {
    public NoRecordsFoundException(){
        super();
    }
    public NoRecordsFoundException(final String message){
        super(message);
    }
}
