package com.intute.profile.exception;

import lombok.ToString;

public class ResourceNotFoundException extends RuntimeException {

    private String message;
    public ResourceNotFoundException(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
