package com.example.demo.Exceptions;

public class SensorNotFoundException extends RuntimeException{
    public SensorNotFoundException() {
    }

    public SensorNotFoundException(String message) {
        super(message);
    }

    public SensorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SensorNotFoundException(Throwable cause) {
        super(cause);
    }

    public SensorNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
