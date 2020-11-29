package maria.clara.exceptions;

public class UnexistentStockException extends RuntimeException {
    public UnexistentStockException(String message){
        super(message);
    }
}

