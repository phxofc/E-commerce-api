package br.com.pedro.Ecommerceapi.exceptions;

public class IncorrectLoginException extends RuntimeException{

    public IncorrectLoginException() {
        super();
    }

    public IncorrectLoginException(String message) {
        super(message);
    }

    public IncorrectLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectLoginException(IncorrectLoginException e) {
    }
}
