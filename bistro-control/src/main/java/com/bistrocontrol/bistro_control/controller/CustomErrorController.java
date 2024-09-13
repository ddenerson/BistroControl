package com.bistrocontrol.bistro_control.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletRequest request) {

        Map<String, String> error = new HashMap<>();
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Object exception = request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);

        ModelAndView modelAndView = new ModelAndView("error");

        if (exception != null ){
            error.put("exception", exception.toString());
        }

        if (status == null) {
            error.put("status", "000");
            error.put("message", "Erro desconhecido");
  
            modelAndView.addObject("error", error);
            return modelAndView;
        }

        Integer statusCode = Integer.valueOf(status.toString());
        switch (statusCode) {
            case 403:
                error.put("message", "Você não possui permissão para acessar.");
                break;
            case 404:
                error.put("message", "A página acessada não existe.");
                break;
            case 500:
                error.put("message", "Ocorreu um erro interno no servidor.");
                break;
            default:
                break;
        }
        error.put("status", status.toString());       
        modelAndView.addObject("error", error);
 
        return modelAndView;
    }

    public String getErrorPath() {
        return "/error";
    }
    
}
