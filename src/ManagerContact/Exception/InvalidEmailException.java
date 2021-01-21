package ManagerContact.Exception;

public class InvalidEmailException extends Exception {
    private String InvalidEmailException;

    public InvalidEmailException() {
    }

    public InvalidEmailException(String invalidEmailException) {
        InvalidEmailException = invalidEmailException;
    }

    public String getInvalidEmailException() {
        return InvalidEmailException;
    }
}
