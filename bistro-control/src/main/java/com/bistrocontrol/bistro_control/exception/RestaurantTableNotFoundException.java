package com.bistrocontrol.bistro_control.exception;

public class RestaurantTableNotFoundException extends IllegalArgumentException {

    public RestaurantTableNotFoundException(){
        super("RestaurantTable Not Found");
    }

    public RestaurantTableNotFoundException(String msg) {
        super(String.format("RestaurantTable Not Found: {}", msg));
    }
    
    public RestaurantTableNotFoundException(String msg, Throwable cause) {
        super(String.format("RestaurantTable Not Found: {}", msg), cause);
    }
    
}
