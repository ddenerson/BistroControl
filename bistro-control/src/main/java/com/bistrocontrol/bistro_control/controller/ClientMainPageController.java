package com.bistrocontrol.bistro_control.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bistrocontrol.bistro_control.model.NewReserveDto;
import com.bistrocontrol.bistro_control.service.RestaurantReserveService;

import jakarta.validation.Valid;



@Controller
public class ClientMainPageController {

    @Autowired
    private RestaurantReserveService restaurantReserveService;


    @GetMapping("/cliente")
    public ModelAndView showClientMainPage() {
        // Cria uma view para armazenar os dados que serão enviados juntos com ela.
        ModelAndView modelAndView = new ModelAndView("reservar");
        modelAndView.addObject("newReserveDto", new NewReserveDto("","",""));
        return modelAndView;
    }

    @PostMapping("/cliente/reservar")
    public String newReserve(@Valid NewReserveDto newReserveDto, BindingResult result, Model model) {
        System.out.println(newReserveDto);
        if(result.hasErrors()) {
            System.out.println("Informações preenchidas são inválidas.");
            System.out.println("Erros: " );
            for(FieldError error: result.getFieldErrors()) {
                System.out.println("Erro: " + error);
            }
            System.out.println("Passou aqui");
            return "/reservar";
        }

        var reserve = restaurantReserveService.newReserve(newReserveDto);
        if (reserve == null) {
            model.addAttribute("error", "Mesa indisponível para o horário e data selecionados.");
            return "reservar";
        }
        model.addAttribute("success", "Reserva efetuada!");

        return "/reservar";
    }

    @GetMapping("/cliente/controle-da-reserva")
    public ModelAndView showControlReservePage() {

        ModelAndView modelAndView = new ModelAndView("/cliente/controle-da-reserva");
        var reserves = restaurantReserveService.findClientReserves();
        if (reserves.isEmpty()) {
            modelAndView.addObject("message", "Você não possui reservas.");
            return modelAndView;
        }
        modelAndView.addObject("reservas", reserves);
        return modelAndView;
    }
    
    @GetMapping("/cliente/cancelar-reserva/{id}")
    public ModelAndView cancelReserve(@PathVariable String id) {

        this.restaurantReserveService.cancelReserve(Long.parseLong(id));

        ModelAndView modelAndView = new ModelAndView("/cliente/controle-da-reserva");
        var reserves = restaurantReserveService.findClientReserves();
        if (reserves.isEmpty()) {
            modelAndView.addObject("message", "Você não possui reservas.");
            return modelAndView;
        }
        modelAndView.addObject("reservas", reserves);
        
        return modelAndView;
    }
    
}
