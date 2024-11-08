package com.bistrocontrol.bistro_control.controller;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.bistrocontrol.bistro_control.model.RestaurantReserve;
import com.bistrocontrol.bistro_control.repository.RestaurantReserveRepository;
import com.bistrocontrol.bistro_control.repository.RestaurantTableRepository;
import com.bistrocontrol.bistro_control.service.RestaurantReserveService;


@Controller
public class AdminDashboardController {
    
    @Autowired
    private RestaurantTableRepository restaurantTableRepository;

    @Autowired
    private RestaurantReserveRepository restaurantReserveRepository;

    @Autowired
    private RestaurantReserveService restaurantReserveService;

    @GetMapping("/admin")
    public ModelAndView showAdminDashboard() {
        ModelAndView modelAndView = new ModelAndView("consultar-reservas");

        var time = findTimeInterval(LocalTime.now());
        System.out.println(LocalDate.now());
        System.out.println(time);

        var tables = restaurantTableRepository.findTableStatus(LocalDate.now(), time);
        if (tables.isEmpty()) {
            System.out.println("Nenhuma mesa cadastrada");
        }
        System.out.println(tables);
        modelAndView.addObject("tables", tables);

        return modelAndView;
    } 

    public LocalTime findTimeInterval(LocalTime time) {
        var t = time.getMinute() < 30 ? time.withMinute(0) : time.withMinute(30);
        return LocalTime.of(t.getHour(), t.getMinute());
    }

    @GetMapping("/admin/detalhes-da-reserva/{id}")
    public String getReserveDetails(@PathVariable String id, Model model) {

        System.out.println(id);
        RestaurantReserve reserve = restaurantReserveRepository.findById(Long.valueOf(id)).orElseThrow();
        System.out.println(reserve);

        model.addAttribute("codigoReserva", reserve.getId());
        model.addAttribute("codigoMesa", reserve.getRestaurantTable().getId());
        model.addAttribute("horaReserva", reserve.getReserveTime());
        model.addAttribute("dataReserva", reserve.getReserveDate());
        model.addAttribute("cliente", reserve.getUser().getName());
        
        return "detalhes-da-reserva";
    }

    @GetMapping("/admin/cancelar-reserva/{id}")
    public String cancelReservation(@PathVariable String id) {

        this.restaurantReserveService.cancelReserve(Long.parseLong(id));
        
        return "redirect:/admin";
    }
    
}
