package com.bistrocontrol.bistro_control.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.bistrocontrol.bistro_control.exception.UserNotFoundException;

@ControllerAdvice
public class ExceptionController {
    
    @ExceptionHandler({UserNotFoundException.class})
    public ModelAndView notFoundException(IllegalArgumentException ex) {
        ModelAndView modelAndView = new ModelAndView("error-404");
        modelAndView.addObject("error: ", ex.getMessage());
        return modelAndView;
    }
}
