package com.intute.profile.exception;

import lombok.ToString;

public class ApiException extends RuntimeException{

    String message;
    public ApiException(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return
                 message;
    }
}
