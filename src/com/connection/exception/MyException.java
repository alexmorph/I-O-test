package com.connection.exception;

public class MyException extends Exception {

    public MyException(Throwable exception) {
        initCause(exception);
    }

}
