package com.mockservice.exception;

public class SimulatedServerErrorException extends RuntimeException {
    public SimulatedServerErrorException(String message) {
        super(message);
    }
}
