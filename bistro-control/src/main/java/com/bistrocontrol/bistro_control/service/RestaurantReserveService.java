package com.bistrocontrol.bistro_control.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.bistrocontrol.bistro_control.exception.RestaurantTableNotFoundException;
import com.bistrocontrol.bistro_control.exception.UserNotFoundException;
import com.bistrocontrol.bistro_control.model.MyUserPrincipal;
import com.bistrocontrol.bistro_control.model.NewReserveDto;
import com.bistrocontrol.bistro_control.model.RestaurantReserve;
import com.bistrocontrol.bistro_control.model.RestaurantTable;
import com.bistrocontrol.bistro_control.repository.RestaurantReserveRepository;
import com.bistrocontrol.bistro_control.repository.RestaurantTableRepository;
import com.bistrocontrol.bistro_control.repository.UserRepository;

@Service
public class RestaurantReserveService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestaurantTableRepository tableRepository;

    @Autowired
    private RestaurantReserveRepository reserveRepository;
    
    public RestaurantReserve newReserve(NewReserveDto data) {
        var authentication = (MyUserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var userID = authentication.getId();

        var date = LocalDate.parse(data.date());
        var time = LocalTime.parse(data.time());
        var user = userRepository.findById(userID).orElseThrow(
            UserNotFoundException::new
        );

        var availableTables = tableRepository.findAvailableTables(date, time);
        if (availableTables.isEmpty()) {
            throw new RestaurantTableNotFoundException();
        }

        for(RestaurantTable table: availableTables) {
            if (table.getSeats() == Integer.parseInt(data.seats())) {
                return reserveRepository.save(new RestaurantReserve(user, table, date, time));
            }
        }
        
        return null;
    }

    public List<RestaurantReserve> findClientReserves() {
        var authentication = (MyUserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var userID = authentication.getId();
        var user = userRepository.findById(userID).orElseThrow(
            UserNotFoundException::new
        );
        var reserves = reserveRepository.findByUserId(user.getId());
        return reserves;
    }

    public void cancelReserve(Long id) {
        var reserve = reserveRepository.findById(id).orElseThrow();
        reserveRepository.delete(reserve);
    }
    

}
