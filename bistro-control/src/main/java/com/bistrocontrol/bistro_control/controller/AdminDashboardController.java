package com.bistrocontrol.bistro_control.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bistrocontrol.bistro_control.model.RestaurantTable;
import com.bistrocontrol.bistro_control.repository.RestaurantTableRepository;

@Controller
public class AdminDashboardController {
    
    @Autowired
    private RestaurantTableRepository restaurantTableRepository;

    @GetMapping("/admin/dashboard")
    public String showAdminDashboard() {
        List<RestaurantTable> tables = restaurantTableRepository.findAll();
        
        return "";
    }
}
