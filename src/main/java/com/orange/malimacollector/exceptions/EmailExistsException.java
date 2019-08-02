package com.orange.malimacollector.exceptions;

public class EmailExistsException extends Exception {
    public EmailExistsException(String errorMessage){
        super(errorMessage);
    }
}
