package com.example.donationservice.exception;

public class CampagneNotFoundException extends RuntimeException {
    public CampagneNotFoundException(String message) {
        super(message);
    }
}