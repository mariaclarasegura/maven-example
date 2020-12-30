package maria.clara.exceptions;

public class HttpRequestFailureException extends RuntimeException {
    public HttpRequestFailureException(String message){
        super(message);
    }
}

