package com.example.demo.Exceptions;

public class SensorIDMismatchException extends RuntimeException{

    public SensorIDMismatchException(){
    }

    public SensorIDMismatchException(String message) {
        super(message);
    }

    public SensorIDMismatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public SensorIDMismatchException(Throwable cause) {
        super(cause);
    }

    public SensorIDMismatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
