package ManagerContact.Exception;

public class InvalidPhoneNumberException extends Exception {
    private String InvalidPhoneNumberException;

    public InvalidPhoneNumberException() {
    }

    public InvalidPhoneNumberException(String invalidPhoneNumberException) {
        InvalidPhoneNumberException = invalidPhoneNumberException;
    }

    public String getInvalidPhoneNumberException() {
        return InvalidPhoneNumberException;
    }
}
