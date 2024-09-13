package com.bistrocontrol.bistro_control.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.bistrocontrol.bistro_control.model.RestaurantReserve;

@Repository
public interface ReservRepository extends CrudRepository<RestaurantReserve, Long> {
    
}
