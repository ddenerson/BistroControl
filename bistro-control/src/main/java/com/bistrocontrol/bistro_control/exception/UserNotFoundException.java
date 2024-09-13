package com.bistrocontrol.bistro_control.exception;

public class UserNotFoundException extends IllegalArgumentException {

    public UserNotFoundException(){
        super("User Not Found");
    }

    public UserNotFoundException(String msg) {
        super(String.format("User Not Found: {}", msg));
    }
    
    public UserNotFoundException(String msg, Throwable cause) {
        super(String.format("User Not Found: {}", msg), cause);
    }
    
}
